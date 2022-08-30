package iKeeper.medicine_Information.Dto;

import iKeeper.medicine_Information.Dao.AgeDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ageDTOTest {
    //age합치기 test
    @Test
    void ageABC() {
        AgeDAO ageDAO = new AgeDAO();
        assertEquals(ageDAO.AgeABC(15,"세","미만"),"15세미만");
    }
}