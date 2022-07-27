package iKeeper.medicine_Information.controller;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.service.MedicineService;
import iKeeper.medicine_Information.status.Message;
import iKeeper.medicine_Information.status.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@Slf4j
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    @GetMapping("/information/{medicineCode}")
    @Transactional
    public ResponseEntity test(@PathVariable(value = "medicineCode")String medicineCode)
    {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        MedicineInformation me = medicineService.MedicineInformationLoad(medicineCode);
        Message message = new Message(StatusEnum.OK,"성공",me);
        return new ResponseEntity(message,headers,HttpStatus.OK);
    }
}
