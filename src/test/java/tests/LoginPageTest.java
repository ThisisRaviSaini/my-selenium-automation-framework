package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodels.LoginPage;
import utilities.ExcelFileReader;



public class LoginPageTest extends BaseTest {

    
    @Test
    public void successLoginTest() {
        ExcelFileReader excelFileReader = new ExcelFileReader();
        String username = excelFileReader.getData("TC_01", "Username");
        String password = excelFileReader.getData("TC_01", "Password");
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);


    }
}
