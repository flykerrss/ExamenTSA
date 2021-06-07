package TestNG;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;

    String baseUrl = "https://simpalsid.com/user/login"; //https://simpalsid.com/user/register

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }
    @Test
    public void RegisterWithRandomUserTest(){
        String newUserName = "username" + RandomStringUtils.randomAlphabetic(2);
        String loginEMailText = "mail+"+ RandomStringUtils.randomNumeric(3) + "@gmail.com";
        String userPass = RandomStringUtils.randomAlphanumeric(6);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement loginElement = driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement loginEMail = driver.findElement(By.xpath("//div/input[@name=\"email\"]"));
        loginEMail.sendKeys(loginEMailText);
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys(newUserName);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(userPass);
        WebElement rulesCheckbox = driver.findElement(By.xpath("//input[@id='agree-rules']"));
        rulesCheckbox.isSelected();
        rulesCheckbox.click();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
    }

    @Test
    public void LoginWithDefaultUserTest(){
        WebElement loginElement= driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys("ajax0070909");//use your username
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("qwe123!@#");//use your password
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //logout
        driver.get(baseUrl);
        WebElement loginElement2= driver.findElement(By.xpath("//a[text()='Выйти из аккаунта']"));
        loginElement2.click();
    }


    @AfterMethod
    public void afterMethods(){
        driver.close();
        driver.quit();
    }
}
