package Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Address address;
    private PersonalInfo personalInfo;
    private boolean subscribeToNews;
    private boolean subscribeForSpecialOffers;
}
