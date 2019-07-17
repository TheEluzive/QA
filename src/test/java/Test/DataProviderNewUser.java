package Test;

import Model.DataPool;
import Model.NewUser;
import org.testng.annotations.DataProvider;


public class DataProviderNewUser {



    @DataProvider(name = "dataProviderNewUser")
    public Object[] dataProviderNewUser() {
        int n = 2;
        Object[] newUsers = new NewUser[n];
        for (int i =0; i<n; i++) {
            newUsers[i] = new NewUser();
            ((NewUser)newUsers[i]).setEmail(i+(((NewUser)newUsers[i]).getEmail())) ;
            BaseTest.LOGGER.debug(newUsers[i].toString());

        }
        return newUsers;
    }
}
