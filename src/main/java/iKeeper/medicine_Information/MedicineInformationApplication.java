package iKeeper.medicine_Information;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackageClasses = MedicineInformationApplication.class)
@SpringBootApplication
public class MedicineInformationApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedicineInformationApplication.class, args);

	}

}
