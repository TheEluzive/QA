package Z_TestNG_Education;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;



public class Test {

    @DataProvider(name  = "someDataProviderName")
    public Object[][] simpleDataProvider(){
        return new Object[][]{
                {1, 1},
                {1, 2},
                {2, 2},
        };

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
        Assert.assertEquals(i,j, "Provided numbers are not equal");
        System.out.println("hardAssertEquals Method Was Executed");
    }

    private final SoftAssert softAssertion = new SoftAssert();
    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void softAssertEqualsTest(Integer i, Integer j){
        System.out.println("softAssertEquals Method Was Started");
        softAssertion.assertEquals(i,j, "Provided numbers are not equal");
        System.out.println("softAssertEquals Method Was Executed");

    }

    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void hardAssetNotEqualsTest(Integer i, Integer j){
        System.out.println("hardAssertNotEquals Method Was Started");
        Assert.assertNotEquals(i,j, "Provided numbers are equal");
        System.out.println("hardAssertEquals Method Was Executed");
    }


    @org.testng.annotations.Test(dataProvider = "someDataProviderName")
    public void softAssertNotEqualsTest(Integer i, Integer j){
        System.out.println("softAssertNotEquals Method Was Started");
        softAssertion.assertNotEquals(i,j, "Provided numbers are equal");
        System.out.println("softAssertNotEquals Method Was Executed");

    }

    @org.testng.annotations.Test
    @Parameters({"firstValue"})
    public void paramertizedTestAssertTrue(boolean firstValue){
        Assert.assertTrue(firstValue, "Provided value not true");

    }

    @org.testng.annotations.Test
    @Parameters({"secondValue"})
    public void paramertizedTestAssertFalse(boolean secondValue){
        Assert.assertTrue(secondValue, "Provided value not true");
    }
}
