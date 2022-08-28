package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.dto.AgeDTO;
import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.mapper.MedicineMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class AgeServiceTest {
    @Autowired
    AgeService ageService;
    @Test
    void ageCheck() {
        InputRequestDTO inputRequestDTO= new InputRequestDTO();
        List <String> medicineCodes = List.of(new String[]{"645000170", "645000190", "645000210", "645000180"});
        int ageA = 15;
        String ageB = "세 (3)";
        boolean isPregnantWomen = false;
        inputRequestDTO.setMedicineCode(medicineCodes);
        inputRequestDTO.setAgeA(ageA);
        inputRequestDTO.setAgeB(ageB);
        inputRequestDTO.setPregnantWomen(isPregnantWomen);
//        for (String medicineCode : medicineCodes)
//            medicineMapper.ageCheck(medicineCode,ageA,ageB);
//              medicineMapper.medicineInformationLoad(medicineCode);
                ageService.ageCheck(inputRequestDTO);
    }
    @Test
    void ageListCheck()
    {

    }
    @Test
    void test()
    {
    }
}