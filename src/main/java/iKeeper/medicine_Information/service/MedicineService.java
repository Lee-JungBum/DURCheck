package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.dto.AnswerResponseDTO;
import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.dto.MedicineInformationDTO;
import iKeeper.medicine_Information.dto.PregnantWomanAnswerResponseDTO;
import iKeeper.medicine_Information.error.EmptyPropertyException;
import iKeeper.medicine_Information.error.ageTypeException;
import iKeeper.medicine_Information.mapper.MedicineMapper;
import io.swagger.models.auth.In;
import jdk.jfr.Unsigned;
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
    public MedicineService(MedicineMapper medicineMapper)
    {
        this.medicineMapper=medicineMapper;
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
    @Transactional
    public PregnantWomanAnswerResponseDTO pregnantWomanAnswerService(InputRequestDTO inputRequestDTO)
    {
        serviceCheck(inputRequestDTO);
        PregnantWomanAnswerResponseDTO pregnantWomanAnswerResponseDTO = pregnantWomanAnswer(inputRequestDTO);
        return pregnantWomanAnswerResponseDTO;
    }
    private void serviceCheck(InputRequestDTO inputRequestDTO)
    {
        for(int i = 0; i<= inputRequestDTO.getMedicineCode().size(); i++) checkEmpty(inputRequestDTO.getMedicineCode().get(i),"medicineCode");
        checkEmpty(String.valueOf(inputRequestDTO.getAge_a()),"age_a");
        checkEmpty(String.valueOf(inputRequestDTO.getAge_b()),"age_b");
        checkEmpty(String.valueOf(inputRequestDTO.isPregnantWomen()),"pregnantWomen");
    }
    private void checkEmpty(String value, String propertyName)
    {
        if(value==null||value.isEmpty())
        {
            throw new EmptyPropertyException(propertyName);
        }
    }
    private PregnantWomanAnswerResponseDTO pregnantWomanAnswer(InputRequestDTO inputRequestDTO)
    {
        List<String> medicineCodes = inputRequestDTO.getMedicineCode();
        answer(inputRequestDTO);
        return new PregnantWomanAnswerResponseDTO();//수정해야함
    }
    private AnswerResponseDTO answer(InputRequestDTO inputRequestDTO)
    {
        ageService.ageCheck(inputRequestDTO);
        return new AnswerResponseDTO();//수정해야함
    }


}
