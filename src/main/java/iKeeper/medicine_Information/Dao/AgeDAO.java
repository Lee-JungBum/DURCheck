package iKeeper.medicine_Information.Dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AgeDAO {
    @ApiModelProperty(example = "성분코드")
    private String ingredientCode;
    @ApiModelProperty(example = "약품코드")
    private String medicineCode;
    @ApiModelProperty(example = "약품이름")
    private String medicineName;
    @ApiModelProperty(example = "나이(int)")
    private int specificAgeA;
    @ApiModelProperty(example = "나이구분(주, 개월, 세)")
    private String specificAgeB;
    @ApiModelProperty(example = "나이구분값(미만 이상 이하)")
    private String specificAgeC;
    @ApiModelProperty(example = "상세설명")
    private String detailInformation;

    public String AgeABC(int specificAgeA,String specificAgeB,String specificAgeC)
    {
        return specificAgeA+specificAgeB+specificAgeC;
    }
    public void Null(String medicineCode,String medicineName)
    {
        ingredientCode = "";
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        specificAgeA = 0 ;
        specificAgeB = "";
        specificAgeC = "";
        detailInformation = "";

    }
}
