package Tests;

import Commons.LoadConfigFile;
import Objects.Users;
import Page.ContentProtection;
import Page.WholePage;
import Page.LoginLocalPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestProtect {
    Properties properties;
    String propertyFilePath = ".\\src\\test\\java\\Resources\\Configs\\Config.properties";
    static WebDriver driver;
    int TimeOut = 1000;
    Users user = new Users();


    @BeforeMethod
    public void Method() {
        properties = LoadConfigFile.loadPropertiesFile(propertyFilePath);
        System.setProperty(properties.getProperty("ChromeWebDriver"), properties.getProperty("WebDriver_Resource"));
        driver = new ChromeDriver();

        user.setUsername(properties.getProperty("username"));
        user.setPassword(properties.getProperty("password"));
        user.setPasswordWholeProtect(properties.getProperty("passwordWholeProtect"));
        user.setPasswordProtectContent(properties.getProperty("passwordProtectContent"));


        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(properties.getProperty("SiteURL"));
    }

@Test(description = "Verify that the whole page information displays when the user enters the correct Password protection the whole page and click the submit button")
public void WholePage_Protection() throws IOException {
    LoginLocalPage.EnterDataLogin(driver, user.getUsername(), user.getPassword());
    LoginLocalPage.Login(driver);
    WholePage.EnterProtect(driver, user.getPasswordWholeProtect());
    WholePage.Submit(driver);
    WholePage.CheckInfoDisplay(driver);

    driver.close();
}
@Test(description = "Verify that the content information protected displays when user enters the correct password protect partial content  and click the submit button")
public void Content_Protection() throws IOException {
    LoginLocalPage.EnterDataLogin(driver, user.getUsername(), user.getPassword());
    LoginLocalPage.Login(driver);
    ContentProtection.EnterProtect(driver, user.getPasswordProtectContent());
    ContentProtection.Submit(driver);
    ContentProtection.CheckInfoDisplay(driver);

    driver.close();
}

       @AfterTest
    public void closeBrow() {
        driver.quit();
    }
}

