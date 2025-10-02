package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodels.LoginPage;
import utilities.ExcelFileReader;

import static utilities.DriverFactory.driver;

public class LoginPageTest {



    @Test
    public void successLoginTest() {
        ExcelFileReader excelFileReader = new ExcelFileReader();
        String username = excelFileReader.getData("TC_01", "Username");
        String password = excelFileReader.getData("TC_01", "Password");
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        //LoginPage loginPage = new LoginPage(driver);


    }
}
