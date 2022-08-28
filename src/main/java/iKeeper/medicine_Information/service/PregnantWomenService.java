package iKeeper.medicine_Information.service;

import iKeeper.medicine_Information.dto.InputRequestDTO;
import iKeeper.medicine_Information.dto.PregnantWomenDTO;
import iKeeper.medicine_Information.mapper.MedicineMapper;

import java.util.ArrayList;
import java.util.List;

public class PregnantWomenService {
    private MedicineMapper medicineMapper;
    public PregnantWomenService(MedicineMapper medicineMapper)
    {
        this.medicineMapper =medicineMapper;
    }
    public List<PregnantWomenDTO> pregnantWomenCheck(List<String> medicineCodes)
    {
        List<PregnantWomenDTO> pregnantWomenCheckList= new ArrayList<>();
        for(String medicineCode : medicineCodes)
        {
            pregnantWomenCheckList.add(medicineMapper.pregnantWomenCheck(medicineCode));
        }
        return pregnantWomenCheckList;
    }
}
