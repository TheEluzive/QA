package Model;

import Test.BaseTest;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonPropertyOrder
public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String day;
    private String month;
    private String year;
    private boolean newsLetterRadio;
    private boolean optinRadio;
    private String addressFirstName;
    private String addressLastName;
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
    private String newPassword;









}
