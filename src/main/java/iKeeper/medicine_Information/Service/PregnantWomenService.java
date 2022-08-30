package iKeeper.medicine_Information.Service;

import iKeeper.medicine_Information.Dao.PregnantWomenDAO;
import iKeeper.medicine_Information.Mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class PregnantWomenService {
    private MedicineMapper medicineMapper;
    public PregnantWomenService(MedicineMapper medicineMapper)
    {
        this.medicineMapper =medicineMapper;
    }
    public List<PregnantWomenDAO> pregnantWomenCheck(List<String> medicineCodes, List<String> medicineNames)
    {
        List<PregnantWomenDAO> pregnantWomenCheckList= new ArrayList<>();
        int i = 0;
        for(String medicineCode : medicineCodes)
        {
            PregnantWomenDAO pregnantWomenDAO = new PregnantWomenDAO();
            String medicineName= medicineNames.get(i);
            try {
                pregnantWomenDAO = medicineMapper.pregnantWomenCheck(medicineCode).orElseThrow();
                pregnantWomenCheckList.add(pregnantWomenDAO);
            }catch (NoSuchElementException e)
            {
                log.info(e.toString());
                log.info("해당약품 "+medicineName+" PregnantWomenTest 통과");
                pregnantWomenDAO.Null(medicineCode,medicineName);
                pregnantWomenCheckList.add(pregnantWomenDAO);
            }
        }
        return pregnantWomenCheckList;
    }
}
