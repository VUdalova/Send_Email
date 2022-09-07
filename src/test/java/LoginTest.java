import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.By;


public class LoginTest {
    public WebDriver driver;


    @Before
    public void profileSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikto\\OneDrive\\Робочий стіл\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ukr.net/ua/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checklogin() {

        driver.switchTo().frame("mail widget");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("sendfortesting");
        driver.findElement(By.xpath("//input [@type='password']")).sendKeys("Send1111!!");
        driver.findElement(By.xpath("//button [@class='form__submit']")).click();
    }

    @Test
    public void incorrectpassword() {

        driver.switchTo().frame("mail widget");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("sendfortesting");
        driver.findElement(By.xpath("//input [@type='password']")).sendKeys("Send11!!");
        driver.findElement(By.xpath("//button [@class='form__submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[@class='form__error form__error_wrong form__error_visible']"));
    }

    @Test
    public void emptyfields () {

        driver.switchTo().frame("mail widget");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("");
        driver.findElement(By.xpath("//input [@type='password']")).sendKeys("");
        driver.findElement(By.xpath("//button [@class='form__submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[@class='form__error form__error_emptyBoth form__error_visible']"));

    }



}