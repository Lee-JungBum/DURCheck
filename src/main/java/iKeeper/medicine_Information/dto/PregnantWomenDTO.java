package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PregnantWomenDTO {
    private String ingredientCode;
    private String medicineCode;
    private String medicineName;
    private String tabooGrade;
    private String detailInformation;
}
