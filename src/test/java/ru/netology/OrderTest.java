package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSendForm() {
        driver.get("http://localhost:9999");
        WebElement form = driver.findElement(By.cssSelector("form"));
        form.findElements(By.cssSelector("input")).get(0).sendKeys("Артемий");
        form.findElements(By.cssSelector("input")).get(1).sendKeys("+79183332323");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("button")).click();
        WebElement result = driver.findElement(By.cssSelector("[data-test-id=order-success]"));
        assertTrue(result.isDisplayed());
    }

}
