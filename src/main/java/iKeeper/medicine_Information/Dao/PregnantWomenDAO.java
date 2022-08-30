package iKeeper.medicine_Information.Dao;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PregnantWomenDAO {
    private String ingredientCode;
    private String medicineCode;
    private String medicineName;
    private String tabooGrade;
    private String detailInformation;

    public void Null(String medicineCode, String medicineName)
    {
        ingredientCode = "";
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        tabooGrade="";
        detailInformation = "";
    }
}
