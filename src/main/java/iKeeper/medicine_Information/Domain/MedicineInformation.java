package iKeeper.medicine_Information.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MedicineInformation {
    private int idx;
    private String medicineName;
    private String specification;
    private int productUnit;
    private String representativeCode;
    private String standardCode;
    private String medicineCode;
    private String ingredientCode;
    private String atcCode;

}
