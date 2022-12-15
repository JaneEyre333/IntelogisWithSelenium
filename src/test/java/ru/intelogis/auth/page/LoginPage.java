package ru.intelogis.auth.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.intelogis.auth.data.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement submitButton;
    private WebElement loginWarning;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginField = wait.until(visibilityOfElementLocated(By.cssSelector("#login")));
        passwordField = driver.findElement(By.cssSelector("#password"));
        submitButton = driver.findElement(By.cssSelector("[type='submit']"));
    }

    public LoginPage(WebDriverWait wait) {
        loginWarning = wait.until(visibilityOfElementLocated(By.cssSelector("[class='content'] div")));
        assertEquals("Ошибка авторизации. Неверные логин/пароль", loginWarning.getText().strip());
    }

    public MainPage validLogin(DataGenerator.AuthInfo info) {
        loginField.sendKeys(info.getLogin());
        passwordField.sendKeys(info.getPassword());
        submitButton.click();
        return new MainPage(driver, wait);
    }

    public LoginPage invalidLogin(DataGenerator.AuthInfo info) {
        loginField.sendKeys(info.getLogin());
        passwordField.sendKeys(info.getPassword());
        submitButton.click();
        return new LoginPage(wait);
    }
}
