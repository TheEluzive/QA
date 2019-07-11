package Automation_Best_Practices_and_Patterns;

import Selenium_Education.DataProviderClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main {


    @Test(dataProvider = "dataProviderUser", dataProviderClass = DataProviderUser.class)
    public void Test(NewUser newUser){

        SignIn_Out_And_Registration signIn = new SignIn_Out_And_Registration();
        String[] emailAndPasswordFromRegisration = signIn.registration(signIn.driver, newUser);
        System.out.println(emailAndPasswordFromRegisration[0] + " " + emailAndPasswordFromRegisration[1]);
        signIn.signIn(signIn.driver, emailAndPasswordFromRegisration[0], emailAndPasswordFromRegisration[1]);
    }
}
