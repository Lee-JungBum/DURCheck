package iKeeper.medicine_Information.Dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InputRequestDTO {

    @ApiModelProperty(example = "약품코드")
    private List<String> medicineCodes;
    @ApiModelProperty(example = "약품이름")
    private List<String> medicineNames;
    @ApiModelProperty(example = "나이")
    private int ageA;
    @ApiModelProperty(example = "나이구분(주, 개월, 세)")
    private String ageB;
    @ApiModelProperty(example = "is임산부")
    private boolean pregnantWomen;
//    @ApiModelProperty(example = "먹는기간")
//    private int
    public boolean boolPregnantWomen()
    {
       return pregnantWomen;
    }
}
