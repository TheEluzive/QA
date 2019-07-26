package Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@JsonPropertyOrder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String password;
    private boolean newsLetterRadio;
    private boolean optinRadio;
    private Address address;
    private PersonalInfo personalInfo;
}
