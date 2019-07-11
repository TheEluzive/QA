package Automation_Best_Practices_and_Patterns;

public class NewUser {

    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String day;
    private String month;
    private String year;
    private boolean newsletterRadio;
    private boolean optinRadio;
    private String firstname2;
    private String lastname2;
    private String adress1;
    private String adress2;
    private String city;
    private String postcode;
    private String country;
    private String state;
    private String additionalInformation;
    private String homePhone;
    private String mobileNumber;
    private String addressAlias;

    public NewUser(String email, String firstname, String lastname, String password, String day, String month,
                   String year, boolean newsletterRadio, boolean optinRadio, String firstname2, String lastname2,
                   String adress1, String adress2, String city, String postcode, String country, String state,
                   String additionalInformation, String homePhone, String mobileNumber, String addressAlias) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.newsletterRadio = newsletterRadio;
        this.optinRadio = optinRadio;
        this.firstname2 = firstname2;
        this.lastname2 = lastname2;
        this.adress1 = adress1;
        this.adress2 = adress2;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.state = state;
        this.additionalInformation = additionalInformation;
        this.homePhone = homePhone;
        this.mobileNumber = mobileNumber;
        this.addressAlias = addressAlias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public boolean isNewsletterRadio() {
        return newsletterRadio;
    }

    public void setNewsletterRadio(boolean newsletterRadio) {
        this.newsletterRadio = newsletterRadio;
    }

    public boolean isOptinRadio() {
        return optinRadio;
    }

    public void setOptinRadio(boolean optinRadio) {
        this.optinRadio = optinRadio;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
