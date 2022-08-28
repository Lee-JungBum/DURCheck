package iKeeper.medicine_Information.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AnswerResponseDTO {
    private List<AgeDTO> ageDTO;
    public void setAnswer(List<AgeDTO> ageDTO)
    {
        this.ageDTO=ageDTO;
    }
}
