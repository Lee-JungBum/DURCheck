package iKeeper.medicine_Information.domain;

import lombok.Builder;
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
    private String componentCode;
    private String atcCode;

}
