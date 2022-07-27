package  iKeeper.medicine_Information.mapper;

import iKeeper.medicine_Information.domain.MedicineInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.Optional;

@Mapper
public interface MedicineMapper {
    Optional<MedicineInformation> medicineInformationLoad(String medicineCode);
}
