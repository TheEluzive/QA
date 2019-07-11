package Automation_Best_Practices_and_Patterns;

import org.testng.annotations.DataProvider;

public class DataProviderUser {
    @DataProvider(name = "dataProviderUser")
    public Object[][] dataProviderUser() {
        return new Object[][]{{

                new NewUser("dgfdjghasgfh5@gmail.com",//email
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
                "Adress" //address alias)
                )

        }};
    }
}
