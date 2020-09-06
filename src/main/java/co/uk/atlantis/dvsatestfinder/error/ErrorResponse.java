package co.uk.atlantis.dvsatestfinder.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("message")
    private String moreInformation;

    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;

    @JsonProperty("httpCode")
    private String httpCode;

    @JsonProperty("error")
    private List<String> errorList;
}
