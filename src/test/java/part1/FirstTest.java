package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginIntoApplication() {
      var username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      username.sendKeys("Admin");

      var password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
      password.sendKeys("admin123");

      driver.findElement(By.tagName("button")).click();
    }
}
