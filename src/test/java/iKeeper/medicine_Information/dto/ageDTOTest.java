package iKeeper.medicine_Information.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ageDTOTest {
    //age합치기 test
    @Test
    void ageABC() {
        AgeDTO ageDTO = new AgeDTO();
        assertEquals(ageDTO.AgeABC(15,"세","미만"),"15세미만");
    }
}