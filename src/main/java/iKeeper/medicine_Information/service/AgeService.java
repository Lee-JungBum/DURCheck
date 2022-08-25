package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.error.ageTypeException;

import java.util.List;

public class AgeService {
    /*
     *   연령금기를 위한 연령체크
     */
    public int ageCheck(InputRequestDTO inputRequestDTO) {
        int ageType = inputRequestDTO.getAge_b();
        int age = inputRequestDTO.getAge_a();
        List<String> medicineCode = inputRequestDTO.getMedicineCode();
        if (age<=1) throw new ageTypeException();
        if (ageType == 1) {             //좀더 이쁘게 꾸밀수 있을듯?
            newBornBaby(age);
        } else if (ageType == 2) {
            baby(age);
        } else if (ageType == 3) {

        } else throw new ageTypeException();
        return 1; //수정해야함
    }
    private int newBornBaby(int age)
    {
        if(age>=4) throw new ageTypeException();    //4주이상이면 잘못된 요청
        return age;
    }
    private int baby(int age)
    {
        if(age>=36) throw new ageTypeException();
        return age;
    }
    private int otherThanBabies(int age)
    {
        return age;
    }
}
