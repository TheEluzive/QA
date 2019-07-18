package Test;

import org.testng.annotations.DataProvider;

import static Test.BaseTest.dataPool;

public class DataProviderNewUserFromJson {
    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }
}
