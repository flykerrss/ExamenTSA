package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        String baseUrl = "https://simpalsid.com/user/login"; //https://simpalsid.com/user/register
        String existingUser = "danuds98@gmail.com";
        String userPass = "POSTdop231";
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement loginElement= driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys(existingUser);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(userPass);
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'username')]")));
        driver.close();
        driver.quit();

    }

}
