package ru.intelogis.auth.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement heading;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        heading = wait.until(visibilityOfElementLocated(By.className("ils-title")));
        assertEquals("Главная", heading.getText().strip());
    }

}
