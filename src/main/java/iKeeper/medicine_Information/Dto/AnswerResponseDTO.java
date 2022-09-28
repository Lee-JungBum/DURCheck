package iKeeper.medicine_Information.Dto;

import iKeeper.medicine_Information.Dao.AgeDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AnswerResponseDTO {
    @ApiModelProperty(example = "약품조회결과")
    private List<AgeDAO> ageDAO;
    public void setAnswer(List<AgeDAO> ageDAO)
    {
        this.ageDAO = ageDAO;
    }
}
