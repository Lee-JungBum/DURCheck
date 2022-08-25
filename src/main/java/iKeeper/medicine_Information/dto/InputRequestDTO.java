package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InputRequestDTO {
    private List<String> medicineCode;
    private int age_a;
    private int age_b;
    private boolean isPregnantWomen;
}
