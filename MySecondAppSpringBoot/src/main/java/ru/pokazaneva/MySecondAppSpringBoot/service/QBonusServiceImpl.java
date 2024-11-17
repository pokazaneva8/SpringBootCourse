package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Positions;
import java.time.Year;

@Service
public class QBonusServiceImpl implements QBonusService {
    @Override
    public double calculate(Positions position, double salary, double bonus, int workDays, int year, int quarter) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("Квартальная премия рассчитывается только для управленцев/менеджеров");
        }
        int daysInQuarter = getdaysInQuarter(year, quarter);
        return salary * bonus * daysInQuarter * position.getPositionCoefficient() / workDays;
    }

    private int getdaysInQuarter(int year, int quarter) {
        if (quarter < 1 || quarter > 4) {
            throw new IllegalArgumentException("Номер квартала должен быть от 1 до 4 включительно");
        }
        int result = 0;
        int startMonth = (quarter - 1) * 3 + 1;
        int endMonth = startMonth + 2;
        for (int month = startMonth; month <= endMonth; month++) {
            result += Year.of(year).atMonth(month).lengthOfMonth();
        }
        return result;
    }
}
