package ru.pokazaneva.MySecondAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Response;
import ru.pokazaneva.MySecondAppSpringBoot.util.DateTimeUtil;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService
        implements ModifyResponseService {
    @Override
    public Response modify(Response response){
        UUID uuid = UUID.randomUUID();
        response.setSystemTime(DateTimeUtil.getCustomFormat()
                .format(new Date()));
        log.info("modify response system time: {}", response);
        return  response;
    }
}
