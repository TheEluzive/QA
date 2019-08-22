package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String postCode;
    private String country;
    private String state;
    private String additionalInformation;
    private String homePhone;
    private String mobileNumber;
    private String addressAlias;
}
