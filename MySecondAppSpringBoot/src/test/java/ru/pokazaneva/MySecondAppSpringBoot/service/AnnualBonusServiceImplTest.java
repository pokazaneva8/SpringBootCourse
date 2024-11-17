package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.pokazaneva.MySecondAppSpringBoot.model.Positions;

import static org.assertj.core.api.Assertions.assertThat;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        //given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int year = 2021;

        // when
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays, year);

        // then
        double expected = 360493.82716804938;
        assertThat(result).isEqualTo(expected);
    }
}