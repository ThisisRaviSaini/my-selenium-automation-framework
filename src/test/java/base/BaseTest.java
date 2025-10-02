package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.DriverFactory;
import utilities.ExcelFileReader;
import utilities.PropertyFileReader;

public class BaseTest {

    protected WebDriver driver;
    protected ExcelFileReader excelFileReader;

    @BeforeClass
    public void setup() {
        PropertyFileReader.loadPropertyFile("src/test/resources/config.properties");
        String browser = PropertyFileReader.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        driver.get(PropertyFileReader.getProperty("url"));

        excelFileReader = new ExcelFileReader();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

