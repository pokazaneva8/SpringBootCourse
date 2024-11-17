package ru.pokazaneva.MySecondAppSpringBoot.controller;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pokazaneva.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.pokazaneva.MySecondAppSpringBoot.exception.ValidationFailedException;
import ru.pokazaneva.MySecondAppSpringBoot.model.*;
import ru.pokazaneva.MySecondAppSpringBoot.service.*;
import ru.pokazaneva.MySecondAppSpringBoot.util.DateTimeUtil;
import java.util.Date;
import java.time.Year;
import java.util.Calendar;

@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final AnnualBonusService annualBonusService;
    private final QBonusService qBonusService;
    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService")
                        ModifyResponseService modifyResponseService,
                        @Qualifier("ModifyPackageRequestService")
                        ModifyRequestService modifyRequestService,
                        AnnualBonusService annualBonusService,
                        QBonusService qBonusService){
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.annualBonusService = annualBonusService;
        this.qBonusService = qBonusService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        log.info("request: {}", request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("response created: {}", response);
        try {
           validationService.isValid(bindingResult);
        } catch (ValidationFailedException e){
            return generateErrorResponse(response, ErrorCodes.VALIDATION_EXCEPTION,
                    ErrorMessages.VALIDATION, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e){
            return generateErrorResponse(response, ErrorCodes.UNSUPPORTED_EXCEPTION,
                    ErrorMessages.UNSUPPORTED, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return generateErrorResponse(response, ErrorCodes.UNKNOWN_EXCEPTION,
                    ErrorMessages.UNKNOWN, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.setAnnualBonus(annualBonusService.calculate(request.getPosition(), request.getSalary(),
                request.getBonus(), request.getWorkDays(), Year.now().getValue()));

        response.setQuarterlyBonus(qBonusService.calculate(request.getPosition(),
                    request.getSalary(), request.getBonus(), request.getWorkDays(),
                Year.now().getValue(), getCurrentQuarter()));

        modifyResponseService.modify(response);
        modifyRequestService.modify(request);
        log.info("final response: {}", response);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }

    private ResponseEntity<Response> generateErrorResponse(Response response, ErrorCodes code,
                                                           ErrorMessages message, HttpStatus status) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(code);
        response.setErrorMessage(message);
        log.info("response error data: {}", response);
        return new ResponseEntity<>(response, status);
    }
    private int getCurrentQuarter() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int monthValue = calendar.get(Calendar.MONTH);
        return monthValue / 3;
    }
}
