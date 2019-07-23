package Z_Selenium_Education;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dataProviderForRegistration")
    public Object[][] DataProviderForRegistration() {
        return  new Object[][]{
                {
                        "dgfdjghasgfh5@gmail.com",//email
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
                        "Street street", //address1
                        "5",//address2
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
                        "fs7gh5@gmail.com",//email
                        "NeEvgeny",//firstname
                        "NeTkach", //lastname
                        "234533333332", //password
                        "24", //day
                        "5", //month
                        "1997", //year
                        false, //newsletter radio
                        true, //optin radio
                        "", //firstname + ...
                        "", //lastname + ...
                        "Street street", //address1
                        "5",//address2
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
                        "dgfhfdds666665@gmail.com",//email
                        "TochnoNeEvgeny",//firstname
                        "TochnoNeTkach", //lastname
                        "2345dfghqwerty", //password
                        "24", //day
                        "5", //month
                        "1997", //year
                        true, //newsletter radio
                        true, //optin radio
                        "", //firstname + ...
                        "", //lastname + ...
                        "Street street", //address1
                        "5",//address2
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

