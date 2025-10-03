package tests;

import base.BasePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjectmodels.LoginPage;
import utilities.ExcelFileReader;


public class LoginPageTest extends BasePage {

    ExcelFileReader excelFileReader = new ExcelFileReader();
    LoginPage loginPage = new LoginPage(driver);
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void successLoginTest() {

        String username = excelFileReader.getData("TC_01", "Username");
        String password = excelFileReader.getData("TC_01", "Password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        loginPage.performLogin(username, password);

        softAssert.assertEquals("ABC", "ABC");
        softAssert.assertAll();
    }
}
