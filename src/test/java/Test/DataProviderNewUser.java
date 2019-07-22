package Test;

import Model.User;
import org.testng.annotations.DataProvider;


public class DataProviderNewUser {



    @DataProvider(name = "dataProviderNewUser")
    public Object[] dataProviderNewUser() {
        int n = 2;
        Object[] newUsers = new User[n];
        for (int i =0; i<n; i++) {
            newUsers[i] = new User();
            ((User)newUsers[i]).setEmail(i+(((User)newUsers[i]).getEmail())) ;
            BaseTest.LOGGER.debug(newUsers[i].toString());

        }
        return newUsers;
    }
}
