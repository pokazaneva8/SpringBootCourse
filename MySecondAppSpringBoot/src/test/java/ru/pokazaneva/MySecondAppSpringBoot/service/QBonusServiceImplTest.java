package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.pokazaneva.MySecondAppSpringBoot.model.Positions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QBonusServiceImplTest {

    @Test
    void calculate() {
        //given
        Positions position = Positions.TL;
        double bonus = 2.5;
        int workDays = 40;
        double salary = 100000.00;
        int year = 2020;
        int quarter = 4;

        // when
        double result = new QBonusServiceImpl().calculate(
                position, salary, bonus, workDays, year, quarter);

        // then
        double expected = 1495000.0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonusThrowsErrorForNonManager() {
        Positions position = Positions.DESIGNER;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int year = 2020;
        int quarter = 4;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QBonusServiceImpl().calculate(position, salary, bonus, workDays, year, quarter);
        });
        String expectedMessage = "Квартальная премия рассчитывается только для управленцев/менеджеров";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}