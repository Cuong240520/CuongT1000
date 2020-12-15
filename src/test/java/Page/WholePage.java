package Page;


import Commons.Result2Excels;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class WholePage {

    static String view_page = "//a[@href='http://tester.local/about/']";
//    static String txt_passterPassword = "//input[@name='passster_password']";
//    static String btn_submit = "//button[@name='submit']";
    static String checkInfo = "//p[.='Test successfully']";


    public static void EnterProtect(WebDriver driver, String passwordWholeProtect) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(view_page));
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.name("passster_password")).sendKeys(passwordWholeProtect);
    }
    public static void Submit(WebDriver driver) {
        driver.findElement(By.name("submit")).click();

    }

    public static void CheckInfoDisplay(WebDriver driver) throws IOException {
        String getText = driver.findElement(By.xpath(checkInfo)).getText();
        if (getText.equals("Test successfully")) {
            Result2Excels.saveResult2ExcelFile("ResultTesT", "Result", "TC01", "Verify that Password protect the whole page activated when user activate protection and set up Password at  Passter in setting site", "Passed");
        } else
            Result2Excels.saveResult2ExcelFile("ResultTesT", "Result", "TC01", "Verify that Password protect the whole page activated when user activate protection and set up Password at  Passter in setting site", "Failed");
        Assert.assertEquals("Test successfully",getText);
    }
    }


