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
        String pageNumber = excelFileReader.getData("TC-01", "Page-Number");
        System.out.println("Page Number : "+pageNumber);
        LoginPage loginPage = new LoginPage(driver);


    }
}
