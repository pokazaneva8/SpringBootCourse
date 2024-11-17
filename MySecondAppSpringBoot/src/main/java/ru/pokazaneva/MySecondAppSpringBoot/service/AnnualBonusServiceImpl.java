package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Positions;

import java.util.Calendar;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate (Positions positions, double salary, double bonus, int workDays, int year) {
        int daysInYear = getDays(year);
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    private int getDays(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }
}