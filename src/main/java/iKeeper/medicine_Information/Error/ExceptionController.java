package iKeeper.medicine_Information.Error;

import iKeeper.medicine_Information.Status.Message;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.charset.Charset;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler({
        EmptyPropertyException.class,
    })
    @ApiResponse(code=404, message="입력값에 오류가 있을때")
    public ResponseEntity BadRequestException(final RuntimeException ex)
    {
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        log.info(ex.toString());
        log.warn("CheckData");
        return new ResponseEntity(message,headers, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({
            IndexOutOfBoundsException.class,
    })
    @ApiResponse(code=404, message="입력의 크기수가 다를때")
    public ResponseEntity indexOutOfBoundsException(final IndexOutOfBoundsException ex)
    {
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        log.info(ex.toString());
        log.warn("약품코드 갯수와 약품이름 갯수가 다르다.");
        return new ResponseEntity(message,headers, HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler({
//            ageTypeException.class,
//    })
//    public ResponseEntity unspecifiedAgeType(final ageTypeException ex)
//    {
//        Message message = new Message();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
//        log.warn("unspecified ageType");
//        return new ResponseEntity(message,headers,HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler({
//            EmptyPropertyException.class,
//    })
//    public ResponseEntity EmptyPropertyException(final EmptyPropertyException ex)
//    {
//        Message message = new Message();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
//        log.warn("EmptyPropertyException");
//        return new ResponseEntity(message,headers,HttpStatus.BAD_REQUEST);
//    }
}

