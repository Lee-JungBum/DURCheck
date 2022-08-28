package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
public class AgeDTO {
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
}
