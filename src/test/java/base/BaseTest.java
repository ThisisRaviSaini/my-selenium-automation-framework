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
        excelFileReader = new ExcelFileReader();

        String browser = PropertyFileReader.getProperty("browser");
        String url = PropertyFileReader.getProperty("url");

        driver = DriverFactory.initDriver(browser);
        driver.get(url);

    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

