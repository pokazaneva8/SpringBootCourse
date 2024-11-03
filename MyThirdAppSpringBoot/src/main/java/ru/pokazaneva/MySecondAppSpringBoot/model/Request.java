package ru.pokazaneva.MySecondAppSpringBoot.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank
    @Length(min = 1, max = 32)
    private String uid;

    @NotBlank
    @Length(min = 1, max = 32)
    private String operationUid;

    private Systems systemName;

    @NotBlank
    private String systemTime;

    private String source;

    @Min(value = 1)
    @Max(value = 100000)
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
