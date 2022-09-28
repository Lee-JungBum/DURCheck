package iKeeper.medicine_Information.Domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MedicineInformation {
    @ApiModelProperty(example = "idx")
    private int idx;
    @ApiModelProperty(example = "약품이름")
    private String medicineName;
    @ApiModelProperty(example = "규격")
    private String specification;
    @ApiModelProperty(example = "제품단위")
    private int productUnit;
    @ApiModelProperty(example = "대표코드")
    private String representativeCode;
    @ApiModelProperty(example = "표준코드")
    private String standardCode;
    @ApiModelProperty(example = "약품코드")
    private String medicineCode;
    @ApiModelProperty(example = "성분코드")
    private String ingredientCode;
    @ApiModelProperty(example = "ATC코드")
    private String atcCode;

}
