package Selenium_Education;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dataProviderForRegistration")
    public Object[][] DataProviderForRegistration() {
        return  new Object[][]{
                {
                        "1gdfgjhggfdgfdjghasgfh5@gmail.com",//email
                        "Evgeny",//firstname
                        "Tkach", //lastname
                        "2345dfghqwerty", //password
                        "24", //day
                        "5", //month
                        "1997", //year
                        true, //newsletter radio
                        true, //optin radio
                        "", //firstname + ...
                        "", //lastname + ...
                        "Street street", //adress1
                        "5",//adress2
                        "Volgograd", //city
                        "12345", //postcode
                        "21", //country //only USA
                        "10", //state 1-50
                        "something", //Additional information
                        "12-23-34", //home phone
                        "89876543210", //mobile number
                        "Adress", //address alias

                },
                {
                        "12gfdhgfdgfs7gh5@gmail.com",//email
                        "Evgeny",//firstname
                        "Tkach", //lastname
                        "2345dfghqwerty", //password
                        "24", //day
                        "5", //month
                        "1997", //year
                        true, //newsletter radio
                        true, //optin radio
                        "", //firstname + ...
                        "", //lastname + ...
                        "Street street", //adress1
                        "5",//adress2
                        "Volgograd", //city
                        "12345", //postcode
                        "21", //country //only USA
                        "10", //state 1-50
                        "something", //Additional information
                        "12-23-34", //home phone
                        "89876543210", //mobile number
                        "Adress", //address alias

                },
                {
                        "12jg3hgfdhdgfhfdds666665@gmail.com",//email
                        "Evgeny",//firstname
                        "Tkach", //lastname
                        "2345dfghqwerty", //password
                        "24", //day
                        "5", //month
                        "1997", //year
                        true, //newsletter radio
                        true, //optin radio
                        "", //firstname + ...
                        "", //lastname + ...
                        "Street street", //adress1
                        "5",//adress2
                        "Volgograd", //city
                        "12345", //postcode
                        "21", //country //only USA
                        "10", //state 1-50
                        "something", //Additional information
                        "12-23-34", //home phone
                        "89876543210", //mobile number
                        "Adress", //address alias

                }

        };
    }
}

