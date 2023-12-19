package  iKeeper.medicine_Information.Mapper;

import iKeeper.medicine_Information.Domain.MedicineInformation;
import iKeeper.medicine_Information.Dao.AgeDAO;
import iKeeper.medicine_Information.Dao.PregnantWomenDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface MedicineMapper {
    Optional<MedicineInformation> medicineInformationLoad(String medicineCode);
    Optional<AgeDAO> ageCheck(String medicineCode, int specificAgeA, String specificAgeB);
    Optional<PregnantWomenDAO> pregnantWomenCheck(String medicineCode);
}
