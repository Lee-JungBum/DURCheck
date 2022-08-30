package iKeeper.medicine_Information.Dao;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AgeDAO {
    private String ingredientCode;
    private String medicineCode;
    private String medicineName;
    private int specificAgeA;
    private String specificAgeB;
    private String specificAgeC;
    private String detailInformation;

    public String AgeABC(int specificAgeA,String specificAgeB,String specificAgeC)
    {
        return specificAgeA+specificAgeB+specificAgeC;
    }
    public void Null(String medicineCode,String medicineName)
    {
        ingredientCode = "";
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        specificAgeA = 0 ;
        specificAgeB = "";
        specificAgeC = "";
        detailInformation = "";

    }
}
