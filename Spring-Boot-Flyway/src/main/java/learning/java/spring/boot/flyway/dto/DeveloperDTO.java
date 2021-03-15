package learning.java.spring.boot.flyway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeveloperDTO {

    @JsonProperty(value = "firstname", required = true)
    private final String firstName;

    @JsonProperty(value = "lastname", required = true)
    private final String lastName;

    @JsonProperty(value = "age", required = true)
    private final Integer age;

    @JsonProperty(value = "position", required = true)
    private final String position;

    @JsonProperty(value = "salary", required = true)
    private final Integer salary;

    @JsonProperty(value = "isInHomeOffice", defaultValue = "false")
    private final Boolean isInHomeOffice = Boolean.FALSE;
}
