package iKeeper.medicine_Information.dto;

import lombok.Getter;

@Getter
public class AgeDTO {
    int specificAgeA;
    String specificAgeB;
    String specificAgeC;
    String detailInformation;

    public String AgeABC(int specificAgeA,String specificAgeB,String specificAgeC)
    {
        return specificAgeA+specificAgeB+specificAgeC;
    }
}
