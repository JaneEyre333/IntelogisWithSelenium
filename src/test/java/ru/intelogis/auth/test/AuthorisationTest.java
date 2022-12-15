package ru.intelogis.auth.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.intelogis.auth.data.DataGenerator;
import ru.intelogis.auth.page.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorisationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://ilswebreact-develop.azurewebsites.net/");
        loginPage = new LoginPage(driver, wait);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    @DisplayName("Valid data")
    void shouldLoginSuccess() {
        var authInfo = DataGenerator.getValidAuthInfo();
        loginPage.validLogin(authInfo);
    }


    @Test
    @DisplayName("Wrong login")
    void shouldFailWrongLogin() {
        var authInfo = DataGenerator.getInvalidLogin();
        loginPage.invalidLogin(authInfo);
    }

    @Test
    @DisplayName("Wrong password")
    void shouldFailWrongPassword() {
        var authInfo = DataGenerator.getInvalidPassword();
        loginPage.invalidLogin(authInfo);
    }


}
