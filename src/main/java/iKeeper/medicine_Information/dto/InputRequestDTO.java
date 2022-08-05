package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InputRequestDTO {
    List<String> medicineCode;
    int age;
    boolean isPregnantWomen;
}
