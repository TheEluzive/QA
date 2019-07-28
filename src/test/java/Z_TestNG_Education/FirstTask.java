package Z_TestNG_Education;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListener.class)
public class FirstTask {
    @DataProvider(name  = "someDataProviderName")
    public Object[][] simpleDataProvider(){
        return new Object[][]{
                {1, 1},
                {1, 2},
                {2, 4},
        };

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Tests");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Tests");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Groups");
    }

    @org.testng.annotations.Test(expectedExceptions = {ArithmeticException.class, Exception.class})

    public void testWithExpectedException() throws Exception{
        int i = 1/0;
        throw new Exception();
    }
    @org.testng.annotations.Test
    public void testWithoutExpectedException() {
        int i = 1/0;
    }

    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void hardAssetEqualsTest(Integer i, Integer j){
        System.out.println("hardAssertEquals Method Was Started");
        Assert.assertEquals(Math.sqrt(i),j, "Provided sqrt and number are not equal");
        System.out.println("hardAssertEquals Method Was Executed");
    }

    private final SoftAssert softAssertion = new SoftAssert();
    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void softAssertEqualsTest(Integer i, Integer j){
        System.out.println("softAssertEquals Method Was Started");
        softAssertion.assertEquals(Math.pow(i,2),j, "Provided pow and numbers are not equal");
        System.out.println("softAssertEquals Method Was Executed");

    }

    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void hardAssetNotEqualsTest(Integer i, Integer j){
        System.out.println("hardAssertNotEquals Method Was Started");
        Assert.assertNotEquals(Math.sqrt(i),j, "Provided numbers are equal");
        System.out.println("hardAssertEquals Method Was Executed");
    }

    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void softAssertNotEqualsTest(Integer i, Integer j){
        System.out.println("softAssertNotEquals Method Was Started");
        softAssertion.assertNotEquals(Math.pow(i,2),j, "Provided numbers are equal");
        System.out.println("softAssertNotEquals Method Was Executed");

    }

    @org.testng.annotations.Test()
    public void softAssertFailTest(){
        System.out.println("softAssertFailTest Method Was Started");
        if (Math.PI <3.14&&Math.PI>3.15) Assert.fail("Fail!!");
        System.out.println("softAssertFailTest Method Was Executed");

    }

    @org.testng.annotations.Test
    @Parameters({"firstValue", "secondValue"})
    public void paramertizedTestAssertTrue(int firstValue, int secondValue){
        Assert.assertTrue(Math.sqrt(firstValue)==Math.pow(secondValue,2), "Provided value not true");

    }

    @org.testng.annotations.Test
    @Parameters({"secondValue"})
    public void paramertizedTestAssertFalse(int firstValue, int secondValue){
        Assert.assertTrue(Math.sqrt(firstValue)==Math.pow(secondValue,2), "Provided value not true");
    }

}
