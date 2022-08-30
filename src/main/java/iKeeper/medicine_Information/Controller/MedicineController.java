package iKeeper.medicine_Information.Controller;

import iKeeper.medicine_Information.Domain.MedicineInformation;
import iKeeper.medicine_Information.Dto.AnswerResponseDTO;
import iKeeper.medicine_Information.Dto.PregnantWomanAnswerResponseDTO;
import iKeeper.medicine_Information.Dto.InputRequestDTO;
import iKeeper.medicine_Information.Service.AgeService;
import iKeeper.medicine_Information.Service.MedicineService;
import iKeeper.medicine_Information.Service.PregnantWomenService;
import iKeeper.medicine_Information.Status.Message;
import iKeeper.medicine_Information.Status.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@Slf4j
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    @Autowired
    AgeService ageService;
    @Autowired
    PregnantWomenService pregnantWomenService;
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
        log.info(inPutRequestDTO.toString());//지우기
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
        if(inPutRequestDTO.isPregnantWomen())
        {
            log.info("test구간입니다");
            PregnantWomanAnswerResponseDTO pregnantWomanAnswerResponseDTO = medicineService.pregnantWomanAnswerService(inPutRequestDTO);
            Message message = new Message(StatusEnum.OK,"성공",pregnantWomanAnswerResponseDTO);
            return new ResponseEntity(message,headers,HttpStatus.OK);
        }
        AnswerResponseDTO answerResponseDTO = medicineService.answerService(inPutRequestDTO);
        Message message = new Message(StatusEnum.OK,"성공",answerResponseDTO);
        return new ResponseEntity(message,headers,HttpStatus.OK);
    }
    @PostMapping("/test")
    public void test2()
    {
//        log.info(inPutRequestDTO.getMedicineNames().toString());
//        log.info(String.valueOf(inPutRequestDTO.isPregnantWomen()));
//        return String.valueOf(inPutRequestDTO.isPregnantWomen());

//        InputRequestDTO inputRequestDTO= new InputRequestDTO();
//        List <String> medicineCodes = List.of(new String[]{"645000170", "645000190", "645000210", "645000180"});
//        int ageA = 15;
//        String ageB = "세 (3)";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
//        Message message = new Message(StatusEnum.OK,"성공",pregnantWomenService.pregnantWomenCheck(medicineCodes));
//        return new ResponseEntity(message,headers,HttpStatus.OK);

    }
}
