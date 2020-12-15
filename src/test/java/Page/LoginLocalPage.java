package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLocalPage {
//    static String txt_username= "//input[@id='user_login']";
//    static String txt_password= "//input[@id='user_pass']";
//    static String btn_Login ="//input[@id='wp-submit']";
    public static void EnterDataLogin(WebDriver driver, String username, String password){
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
    }
    public static void Login(WebDriver driver){
        driver.findElement(By.id("wp-submit")).click();
    }
}
