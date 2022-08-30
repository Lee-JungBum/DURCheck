package iKeeper.medicine_Information.Dto;

import iKeeper.medicine_Information.Dao.PregnantWomenDAO;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PregnantWomanAnswerResponseDTO
{
    private AnswerResponseDTO answerResponseDTO;
    private List<PregnantWomenDAO> pregnantWomenDAO;

    public void setPregnantWomenAnswer(List<PregnantWomenDAO> pregnantWomenDAO)
    {
        this.pregnantWomenDAO = pregnantWomenDAO;
    }
    public void setAnswer(AnswerResponseDTO answerResponseDTO)
    {
        this.answerResponseDTO=answerResponseDTO;

    }
}
