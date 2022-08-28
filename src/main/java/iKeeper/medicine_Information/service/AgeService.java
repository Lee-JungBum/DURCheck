package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.dto.AgeDTO;
import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.error.ageTypeException;
import iKeeper.medicine_Information.mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class AgeService {
    /*
     *   연령금기를 위한 연령체크
     */
    private MedicineMapper medicineMapper;
    public AgeService(MedicineMapper medicineMapper){this.medicineMapper=medicineMapper;}
    public List<AgeDTO> ageCheck(InputRequestDTO inputRequestDTO) {
        String ageType = inputRequestDTO.getAgeB();
        int age = inputRequestDTO.getAgeA();
        List<String> medicineCode = inputRequestDTO.getMedicineCode();
        log.info("medicineCode : "+medicineCode.toString()+"    age : "+age+"   ageType : "+ageType);
        if (age<=1) throw new ageTypeException();
        List<AgeDTO> ageDTO;
        if (ageType.equals("주 (1)")) {             //좀더 이쁘게 꾸밀수 있을듯?
            ageDTO=newBornBaby(age,medicineCode,ageType);
        } else if (ageType.equals("개월 (2)")) {
            ageDTO=baby(age,medicineCode,ageType);
        } else if (ageType.equals("세 (3)")) {
            ageDTO=otherThanBabies(age,medicineCode,ageType);
        } else throw new ageTypeException();
        return ageDTO; //수정해야함
    }

    private List<AgeDTO> newBornBaby(int age, List<String> medicineCode, String ageType)
    {
        if(age>4) throw new ageTypeException();    //4주이상이면 잘못된 요청
        List<AgeDTO> ageDTO = ageListCheck(medicineCode,age,ageType);
        return ageDTO;
    }
    private List<AgeDTO> baby(int age, List<String> medicineCode, String ageType)
    {
        if(age>=36) throw new ageTypeException();
        List<AgeDTO> ageDTO = ageListCheck(medicineCode,age,ageType);
        return ageDTO;
    }
    private List<AgeDTO> otherThanBabies(int age, List<String> medicineCode, String ageType)
    {
        log.info("test");
        List<AgeDTO> ageDTO = ageListCheck(medicineCode,age,ageType);
        return ageDTO;
    }
    public List<AgeDTO> ageListCheck(List<String> medicineCodes,int age, String ageType)
    {

        List<AgeDTO> answer = new ArrayList<>();
        for(String medicineCode: medicineCodes)
        {

            log.info(medicineCode+"조회 요청");
            AgeDTO ageDTO = medicineMapper.ageCheck(medicineCode,age,ageType);
            log.info("조회결과 : "+ageDTO.toString());
            answer.add(ageDTO);
        }
        return answer;
    }
}
