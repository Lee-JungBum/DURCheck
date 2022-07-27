package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
