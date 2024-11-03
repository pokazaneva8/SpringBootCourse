package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.pokazaneva.MySecondAppSpringBoot.model.Request;

@Service
@Qualifier("ModifyPackageRequestService")
public class ModifyPackageRequestService implements ModifyRequestService {

    private final ModifyRequestService sourceService;
    private final ModifyRequestService systemNameService;
    private final ModifyRequestService systemTimeService;

    public ModifyPackageRequestService(
            @Qualifier("ModifySourceRequestService") ModifyRequestService sourceService,
            @Qualifier("ModifySystemNameRequestService") ModifyRequestService systemNameService,
            @Qualifier("ModifySystemTimeRequestService") ModifyRequestService systemTimeService
    ) {
        this.sourceService = sourceService;
        this.systemNameService = systemNameService;
        this.systemTimeService = systemTimeService;
    }

    @Override
    public void modify(Request request) {
        sourceService.modify(request);
        systemTimeService.modify(request);
        systemNameService.modify(request);
    }
}
