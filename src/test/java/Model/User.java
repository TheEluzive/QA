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
    private String adressFirstName;
    private String adressLastName;
    private String adress1;
    private String adress2;
    private String city;
    private String postCode;
    private String country;
    private String state;
    private String additionalInformation;
    private String homePhone;
    private String mobileNumber;
    private String addressAlias;





    public User() {

        this.email = System.currentTimeMillis() + "evgeny.tkach@gmail.com";//email
        BaseTest.LOGGER.debug("Constructor generated email:" +  this.email);
        this.firstName = "Evgeny";//firstName
        this.lastName = "Tkach"; //lastName
        this.password = "2345dfghqwerty"; //password
        this.day = "24"; //day
        this.month = "5"; //month
        this.year = "1997"; //year
        this.newsLetterRadio = true; //newsletter radio
        this.optinRadio = true; //optin radio
        this.adressFirstName = ""; //firstName + ...
        this.adressLastName = ""; //lastName + ...
        this.adress1 = "Street street"; //adress1
        this.adress2 = "5";//adress2
        this.city = "Volgograd"; //city
        this.postCode = "12345"; //postCode
        this.country = "21"; //country //only USA
        this.state = "10"; //state 1-50
        this.additionalInformation = "something"; //Additional information
        this.homePhone = "12-23-34"; //home phone
        this.mobileNumber = "89876543210"; //mobile number
        this.addressAlias = "Adress"; //address alias)

    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", newsLetterRadio=" + newsLetterRadio +
                ", optinRadio=" + optinRadio +
                ", adressFirstName='" + adressFirstName + '\'' +
                ", adressLastName='" + adressLastName + '\'' +
                ", adress1='" + adress1 + '\'' +
                ", adress2='" + adress2 + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                '}';
    }
}
