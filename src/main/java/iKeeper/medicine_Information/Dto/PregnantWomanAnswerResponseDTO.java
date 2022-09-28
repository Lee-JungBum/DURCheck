package iKeeper.medicine_Information.Dto;

import iKeeper.medicine_Information.Dao.PregnantWomenDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PregnantWomanAnswerResponseDTO
{
    @ApiModelProperty(example = "약품조회결과")
    private AnswerResponseDTO answerResponseDTO;
    @ApiModelProperty(example = "임산부약품조회결과")
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
