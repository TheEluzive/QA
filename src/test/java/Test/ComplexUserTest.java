package Test;

import Model.Address;
import Model.PersonalInfo;
import Model.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComplexUserTest extends BaseTest {
    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void complexUserTest(Address address, PersonalInfo personalInfo){
        User user1 = new User(address, personalInfo);
        System.out.println("Something");

    }
}
