package iKeeper.medicine_Information.Controller;

import iKeeper.medicine_Information.Dto.InputRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags="Medicine Controller")
public interface MedicineControllerDocs {
    @ApiOperation(value="DUR Check",notes = "요청자의 DUR을 체크합니다.")
    public ResponseEntity medicineData(@RequestBody @ApiParam(value = "약품의 idx 리스트,약품의 이름 리스트, 나이, 단위, 임산부 여부") InputRequestDTO inPutRequestDTO);
}
