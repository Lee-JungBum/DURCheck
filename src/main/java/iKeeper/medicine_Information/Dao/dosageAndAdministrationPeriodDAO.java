package iKeeper.medicine_Information.Dao;

import io.swagger.annotations.ApiModelProperty;

public class dosageAndAdministrationPeriodDAO {

    @ApiModelProperty(example = "약품코드")
    private String medicineCode;
    @ApiModelProperty(example = "약품이름")
    private String medicineName;
    @ApiModelProperty(example = "성분코드")
    private String ingredientCode;
    @ApiModelProperty(example = "1일 최대투여량")
    private String maximumDailyDosage;
    @ApiModelProperty(example = "1일 최대투여기준량")
    private int maximumDailyStandardDosage;
    @ApiModelProperty(example = "점검기준 성분량")
    private int inspectionStandardComponentContent;
    @ApiModelProperty(example = "최대투여기간")
    private String maximunDosagePeriod;
}
