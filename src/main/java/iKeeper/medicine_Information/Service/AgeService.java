package iKeeper.medicine_Information.Service;

import iKeeper.medicine_Information.Dao.AgeDAO;
import iKeeper.medicine_Information.Dto.InputRequestDTO;
import iKeeper.medicine_Information.Error.ageTypeException;
import iKeeper.medicine_Information.Mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class AgeService {
    /*
     *   연령금기를 위한 연령체크
     */
    private MedicineMapper medicineMapper;
    public AgeService(MedicineMapper medicineMapper){this.medicineMapper=medicineMapper;}
    public List<AgeDAO> ageCheck(InputRequestDTO inputRequestDTO) {
        String ageType = inputRequestDTO.getAgeB();
        int age = inputRequestDTO.getAgeA();
        List<String> medicineCodes = inputRequestDTO.getMedicineCodes();
        List<String> medicineNames = inputRequestDTO.getMedicineNames();
        log.info("medicineCode : "+medicineCodes.toString()+"    age : "+age+"   ageType : "+ageType);
        if (age<=1) throw new ageTypeException();
        List<AgeDAO> ageDAO;
        if (ageType.equals("주 (1)")) {             //좀더 이쁘게 꾸밀수 있을듯?
            ageDAO =newBornBaby(age,medicineCodes,ageType,medicineNames);
        } else if (ageType.equals("개월 (2)")) {
            ageDAO =baby(age,medicineCodes,ageType,medicineNames);
        } else if (ageType.equals("세 (3)")) {
            ageDAO =otherThanBabies(age,medicineCodes,ageType,medicineNames);
        } else throw new ageTypeException();
        return ageDAO; //수정해야함
    }

    private List<AgeDAO> newBornBaby(int age, List<String> medicineCodes, String ageType, List<String> medicineNames)
    {
        if(age>4) throw new ageTypeException();    //4주이상이면 잘못된 요청
        List<AgeDAO> ageDAO = ageListCheck(medicineCodes,age,ageType,medicineNames);
        return ageDAO;
    }
    private List<AgeDAO> baby(int age, List<String> medicineCodes, String ageType, List<String> medicineNames)
    {
        if(age>=36) throw new ageTypeException();
        List<AgeDAO> ageDAO = ageListCheck(medicineCodes,age,ageType,medicineNames);
        return ageDAO;
    }
    private List<AgeDAO> otherThanBabies(int age, List<String> medicineCodes, String ageType, List<String> medicineNames)
    {
        List<AgeDAO> ageDAO = ageListCheck(medicineCodes,age,ageType,medicineNames);
        log.info("test");
        return ageDAO;
    }
    public List<AgeDAO> ageListCheck(List<String> medicineCodes, int age, String ageType, List<String> medicineNames)
    {
        log.info("test");
        List<AgeDAO> answer = new ArrayList<>();
        int i=0;
        for(String medicineCode: medicineCodes)
        {

            String medicineName = medicineNames.get(i);
            AgeDAO ageDAO = new AgeDAO();
            log.info(medicineCode+"조회 요청");

            try {
                ageDAO = medicineMapper.ageCheck(medicineCode, age, ageType).orElseThrow();
            }catch (NoSuchElementException e)
            {
                log.info(e.toString());
                log.info("해당약품 "+medicineName+" ageTest 통과");
                ageDAO.Null(medicineCode,medicineName);
            }
            log.info("조회결과 : "+ ageDAO.toString());
            answer.add(ageDAO);
        }
        return answer;
    }
}
