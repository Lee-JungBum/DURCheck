package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.dto.AnswerResponseDTO;
import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.dto.PregnantWomanAnswerResponseDTO;
import iKeeper.medicine_Information.error.EmptyPropertyException;
import iKeeper.medicine_Information.mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MedicineService {

   private MedicineMapper medicineMapper;
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
    public Object<> answerService(InputRequestDTO inputRequestDTO)
    {
        for(int i = 0; i<= inputRequestDTO.getMedicineCode().size(); i++) checkEmpty(inputRequestDTO.getMedicineCode().get(i),"medicineCode");
        checkEmpty(String.valueOf(inputRequestDTO.getAge()),"Age");
        checkEmpty(String.valueOf(inputRequestDTO.isPregnantWomen()),"PregnantWomen");
        if(inputRequestDTO.isPregnantWomen())
        {
            PregnantWomanAnswerResponseDTO pregnantWomanAnswerResponseDTO = pregnantWomanAnswer(inputRequestDTO);
            return pregnantWomanAnswerResponseDTO;
        }
        AnswerResponseDTO answerResponseDTO = answer(inputRequestDTO);
        return answerResponseDTO;
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
    }
    private AnswerResponseDTO answer(InputRequestDTO inputRequestDTO)
    {

    }
    private
    private
}
