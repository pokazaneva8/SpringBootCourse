package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Positions;

@Service
public interface QBonusService {
    double calculate(Positions position, double salary, double bonus, int workDays, int year, int quarter);
}
