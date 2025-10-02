package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodels.LoginPage;
import utilities.ExcelFileReader;



public class LoginPageTest extends BaseTest {
    ExcelFileReader excelFileReader = new ExcelFileReader();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void successLoginTest() {

        String username = excelFileReader.getData("TC_01", "Username");
        String password = excelFileReader.getData("TC_01", "Password");
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);

        loginPage.performLogin(username,password);
        
    }
}
