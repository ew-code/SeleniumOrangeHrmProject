package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogginIntoApplication() throws InterruptedException {
        Thread.sleep(2000);
      var username = driver.findElement(By.name("username"));
      username.sendKeys("Admin");

      var password = driver.findElement(By.name("password"));
      password.sendKeys("admin123");

      driver.findElement(By.tagName("button")).click();
    }
}
