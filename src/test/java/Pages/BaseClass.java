package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    By usernameInput = By.xpath("//input[@id='user-name']");
    By passwordInput = By.xpath("//input[@id='password']");
    protected PageFactory pageFactory;

    @BeforeClass
    public void Setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/PropertiesFile/Config.properties");
        Properties data = new Properties();
        data.load(reader);
        WebDriver driver = null;

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pageFactory = new PageFactory(driver);
        driver.manage().window().maximize();
        driver.findElement(usernameInput).sendKeys(data.getProperty("username"));
        driver.findElement(passwordInput).sendKeys(data.getProperty("password"));
    }
}
