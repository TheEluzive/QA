package Test;

import Model.NewUser;
import Page.BasePage;
import Page.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class RegistrationTest extends BaseTest {

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void RegistrationTest(NewUser newUser) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        NewUser account = objectMapper.readValue( new File( System.getProperty("user.dir")+"src/test/java/Model/NewUser.json" ), NewUser.class );

        System.out.println( account );
        RegistrationPage registrationPage;
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        registrationPage.inputEmailAndOpenRegistrationPage(newUser.getEmail());
        registrationPage.inputPersonalInformation(newUser);
        BasePage.buttonLogout.click();
        registrationPage.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.personalArea);
        BasePage.buttonLogout.click();
    }
}
