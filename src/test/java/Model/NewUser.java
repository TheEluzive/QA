package Model;

import Page.BasePage;
import Test.BaseTest;

public class NewUser {

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
    private String usedEmail;

    public String getUsedEmail() {
        return usedEmail;
    }

    public void setUsedEmail(String usedEmail) {
        this.usedEmail = usedEmail;
    }


    public NewUser() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "email='" + email + '\'' +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isNewsLetterRadio() {
        return newsLetterRadio;
    }

    public void setNewsLetterRadio(boolean newsLetterRadio) {
        this.newsLetterRadio = newsLetterRadio;
    }

    public boolean isOptinRadio() {
        return optinRadio;
    }

    public void setOptinRadio(boolean optinRadio) {
        this.optinRadio = optinRadio;
    }

    public String getAdressFirstName() {
        return adressFirstName;
    }

    public void setAdressFirstName(String adressFirstName) {
        this.adressFirstName = adressFirstName;
    }

    public String getAdressLastName() {
        return adressLastName;
    }

    public void setAdressLastName(String adressLastName) {
        this.adressLastName = adressLastName;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }
}
