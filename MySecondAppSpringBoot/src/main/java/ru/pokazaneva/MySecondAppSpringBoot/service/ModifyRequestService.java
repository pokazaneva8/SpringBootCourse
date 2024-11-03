package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {
    void modify (Request request);
}
