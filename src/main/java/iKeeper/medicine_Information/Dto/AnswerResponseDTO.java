package iKeeper.medicine_Information.Dto;

import iKeeper.medicine_Information.Dao.AgeDAO;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AnswerResponseDTO {
    private List<AgeDAO> ageDAO;
    public void setAnswer(List<AgeDAO> ageDAO)
    {
        this.ageDAO = ageDAO;
    }
}
