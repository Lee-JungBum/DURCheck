package iKeeper.medicine_Information.Dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InputRequestDTO {
    private List<String> medicineCodes;
    private List<String> medicineNames;
    private int ageA;
    private String ageB;
    private boolean pregnantWomen;
    public boolean boolPregnantWomen()
    {
       return pregnantWomen;
    }
}
