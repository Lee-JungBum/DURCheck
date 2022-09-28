package iKeeper.medicine_Information.Dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PregnantWomenDAO {
    @ApiModelProperty(example = "성분코드")
    private String ingredientCode;
    @ApiModelProperty(example = "약품코드")
    private String medicineCode;
    @ApiModelProperty(example = "약품이름")
    private String medicineName;
    @ApiModelProperty(example = "금기등급")
    private String tabooGrade;
    @ApiModelProperty(example = "상세설명")
    private String detailInformation;

    public void Null(String medicineCode, String medicineName)
    {
        ingredientCode = "";
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        tabooGrade="";
        detailInformation = "";
    }
}
