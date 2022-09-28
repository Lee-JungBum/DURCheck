package iKeeper.medicine_Information.Dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MedicineInformationDAO {
    @ApiModelProperty(example = "약품코드")
    private int medicineCode;
    @ApiModelProperty(example = "성분코드")
    private int ingredientCode;

}
