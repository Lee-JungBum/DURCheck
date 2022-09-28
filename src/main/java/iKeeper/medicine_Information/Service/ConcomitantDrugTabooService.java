package iKeeper.medicine_Information.Service;

import iKeeper.medicine_Information.Dao.ConcomitantDrugTabooDAO;
import iKeeper.medicine_Information.Mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@Slf4j
public class ConcomitantDrugTabooService {
    MedicineMapper medicineMapper;
    public ConcomitantDrugTabooService(MedicineMapper medicineMapper)
    {
        this.medicineMapper=medicineMapper;
    }
//    public ConcomitantDrugTabooDAO concomitantDrugTaboo()
//    {
//        Stream stream;
//
//        return
//    }
}
