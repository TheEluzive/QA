package Automation_Best_Practices_and_Patterns;

import org.testng.annotations.Test;

public class Main {
    private String[] emailAndPasswordFromRegistration;
    private static int countUserForRegistration = 2;
    private static RegistratedUser[] registratedUser = {new RegistratedUser(), new RegistratedUser()};
    private SignIn_Out_And_Registration signInOutAndRegistration = new SignIn_Out_And_Registration();
    private int countRegistratedUsers = 0;




    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void testRegistration(NewUser newUser) {
        emailAndPasswordFromRegistration = signInOutAndRegistration.registration(signInOutAndRegistration.driver, newUser);
        System.out.println(emailAndPasswordFromRegistration[0] + " " + emailAndPasswordFromRegistration[1]);
        registratedUser[countRegistratedUsers]=new RegistratedUser(emailAndPasswordFromRegistration[0],emailAndPasswordFromRegistration[1]);
        signInOutAndRegistration.signInAndOut(signInOutAndRegistration.driver, registratedUser[countRegistratedUsers].getEmail(),
                registratedUser[countRegistratedUsers].getPassword());
        countRegistratedUsers++;
    }




}
