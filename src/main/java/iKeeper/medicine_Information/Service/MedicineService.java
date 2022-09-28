package iKeeper.medicine_Information.Service;

import iKeeper.medicine_Information.Dao.AgeDAO;
import iKeeper.medicine_Information.Dao.PregnantWomenDAO;
import iKeeper.medicine_Information.Domain.MedicineInformation;
import iKeeper.medicine_Information.Dto.*;
import iKeeper.medicine_Information.Error.EmptyPropertyException;
import iKeeper.medicine_Information.Mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MedicineService {

    private MedicineMapper medicineMapper;
    private AgeService ageService;
    private PregnantWomenService pregnantWomenService;
    public MedicineService(MedicineMapper medicineMapper,AgeService ageService,PregnantWomenService pregnantWomenService)
    {
        this.medicineMapper=medicineMapper;
        this.ageService=ageService;
        this.pregnantWomenService=pregnantWomenService;
    }
    public MedicineInformation MedicineInformationLoad(String medicineCode){
        Optional<MedicineInformation> medicineInformation= medicineMapper.medicineInformationLoad(medicineCode);
        medicineInformation.orElseThrow(()->new RuntimeException());
        return medicineInformation.get();
    }
    @Transactional
    public AnswerResponseDTO answerService(InputRequestDTO inputRequestDTO)
    {
        serviceCheck(inputRequestDTO);
        AnswerResponseDTO answerResponseDTO = answer(inputRequestDTO);
        return answerResponseDTO;
    }
    private AnswerResponseDTO answer(InputRequestDTO inputRequestDTO)
    {
        AnswerResponseDTO answerResponseDTO = new AnswerResponseDTO();
        log.info(inputRequestDTO.toString());
        List<AgeDAO> ageDAO =ageService.ageCheck(inputRequestDTO);
        answerResponseDTO.setAnswer(ageDAO);
        return answerResponseDTO;
    }
    private void serviceCheck(InputRequestDTO inputRequestDTO)
    {
        for(int i = 0; i< inputRequestDTO.getMedicineCodes().size(); i++) {
            log.info(checkEmpty(inputRequestDTO.getMedicineCodes().get(i), "medicineCode"));
            log.info(checkEmpty(inputRequestDTO.getMedicineNames().get(i),"medicineName"));
        }
        log.info(checkEmpty(String.valueOf(inputRequestDTO.getAgeA()),"ageA"));
        log.info(checkEmpty(String.valueOf(inputRequestDTO.getAgeB()),"ageB"));
        log.info( checkEmpty(String.valueOf(inputRequestDTO.isPregnantWomen()),"pregnantWomen"));
    }
    private String checkEmpty(String value, String propertyName)
    {
        if(value==null||value.isEmpty())
        {
            throw new EmptyPropertyException(propertyName);
        }
        return propertyName+"의 값 : "+value;
    }

    @Transactional
    public PregnantWomanAnswerResponseDTO pregnantWomanAnswerService(InputRequestDTO inputRequestDTO)
    {
        serviceCheck(inputRequestDTO);
        PregnantWomanAnswerResponseDTO pregnantWomanAnswerResponseDTO = new PregnantWomanAnswerResponseDTO();
        AnswerResponseDTO answerResponseDTO = answer(inputRequestDTO);
        log.info("answer통과지점");
        List<PregnantWomenDAO> pregnantWomenDAO = pregnantWomenService.pregnantWomenCheck(inputRequestDTO.getMedicineCodes(),inputRequestDTO.getMedicineNames());
        log.info("pregnantWomenTest 통과지점");
        pregnantWomanAnswerResponseDTO.setAnswer(answerResponseDTO);
        pregnantWomanAnswerResponseDTO.setPregnantWomenAnswer(pregnantWomenDAO);
        return pregnantWomanAnswerResponseDTO;
    }

}
