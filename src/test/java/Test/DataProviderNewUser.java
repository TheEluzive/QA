package Test;

import Model.User;
import org.testng.annotations.DataProvider;


public class DataProviderNewUser {



    @DataProvider(name = "dataProviderNewUser")
    public Object[] dataProviderNewUser() {
        int amountRandomUsers = 2;
        Object[] newUsers = new User[amountRandomUsers];
        for (int i =0; i<amountRandomUsers; i++) {
            newUsers[i] = new User();
            ((User)newUsers[i]).setEmail(i+(((User)newUsers[i]).getEmail())) ;
            BaseTest.LOGGER.debug(newUsers[i].toString());

        }
        return newUsers;
    }
}
