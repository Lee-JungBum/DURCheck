package iKeeper.medicine_Information.error;

import iKeeper.medicine_Information.status.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.charset.Charset;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler({
        RuntimeException.class,
    })
    public ResponseEntity BadRequestException(final RuntimeException ex)
    {
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        log.warn("CheckData");
        return new ResponseEntity(message,headers, HttpStatus.BAD_REQUEST);
    }
}

