package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@ToString
public class InputRequestDTO {
    private List<String> medicineCode;
    private int ageA;
    private String ageB;
    private boolean isPregnantWomen;
}
