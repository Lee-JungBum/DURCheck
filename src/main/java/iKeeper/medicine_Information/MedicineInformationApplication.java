package iKeeper.medicine_Information;

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
