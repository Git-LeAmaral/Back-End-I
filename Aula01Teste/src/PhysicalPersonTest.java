import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PhysicalPersonTest {

    //GIVEN WHEN THEN
    //DADO UM CENÁRIO, QUANDO, ENTÃO

    @Test
    @DisplayName("GIVEN A PERSON WITH 10 YEARS OLD, WHEN WE VALIDATE AGE, RETURN FALSE")
    public void givenPersonWith10years_whenValidate_thenReturnUnder18() {
        //given
        PhysicalPerson physicalPerson = new PhysicalPerson("Leticia", 13);
        //when
        boolean isOver18Years = physicalPerson.isOver18Years();
        //then
        Assertions.assertFalse(isOver18Years);
    }

    @Test
    @DisplayName("GIVEN A PERSON WITH 20 YEARS OLD, WHEN WE VALIDATE AGE, RETURN FALSE")
    public void givenPersonWith20years_whenValidate_thenReturnOver18() {
        //given
        String name = "Leandro Amaral";
        LocalDate dateOfBirth = LocalDate.of(1986, Month.NOVEMBER, 11);
        PhysicalPerson physicalPerson = new PhysicalPerson(name, dateOfBirth);
        //when
        boolean isOver18Years = physicalPerson.isOver18Years();
        //then
        Assertions.assertTrue(isOver18Years);
        Assertions.assertEquals(name, physicalPerson.getName());
        Assertions.assertEquals(dateOfBirth, physicalPerson.getDateOfBirth());
    }
}