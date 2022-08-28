package iKeeper.medicine_Information.controller;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.dto.AnswerResponseDTO;
import iKeeper.medicine_Information.dto.MedicineInformationDTO;
import iKeeper.medicine_Information.dto.PregnantWomanAnswerResponseDTO;
import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.service.AgeService;
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
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    @Autowired
    AgeService ageService;
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
    @PostMapping("/medicineData")
    @Transactional
    public ResponseEntity medicineData(@RequestBody InputRequestDTO inPutRequestDTO)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
        if(inPutRequestDTO.isPregnantWomen())
        {
            PregnantWomanAnswerResponseDTO pregnantWomanAnswerResponseDTO = medicineService.pregnantWomanAnswerService(inPutRequestDTO);
            Message message = new Message(StatusEnum.OK,"성공",pregnantWomanAnswerResponseDTO);
            return new ResponseEntity(message,headers,HttpStatus.OK);
        }
        AnswerResponseDTO answerResponseDTO = medicineService.answerService(inPutRequestDTO);
        Message message = new Message(StatusEnum.OK,"성공",answerResponseDTO);
        return new ResponseEntity(message,headers,HttpStatus.OK);
    }
    @PostMapping("/test")
    public ResponseEntity test2()
    {
        InputRequestDTO inputRequestDTO= new InputRequestDTO();
        List <String> medicineCodes = List.of(new String[]{"645000170", "645000190", "645000210", "645000180"});
        int ageA = 15;
        String ageB = "세 (3)";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
        Message message = new Message(StatusEnum.OK,"성공",ageService.ageListCheck(medicineCodes,ageA,ageB));
        return new ResponseEntity(message,headers,HttpStatus.OK);
    }
}
