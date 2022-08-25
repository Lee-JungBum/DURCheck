package  iKeeper.medicine_Information.mapper;

import iKeeper.medicine_Information.domain.MedicineInformation;
import iKeeper.medicine_Information.dto.MedicineInformationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.Optional;

@Mapper
public interface MedicineMapper {
    Optional<MedicineInformation> medicineInformationLoad(String medicineCode);
    Optional<MedicineInformationDTO> ageCheck(String medicineCode);
}
