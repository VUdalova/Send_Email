import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SendEmail {
    private WebDriver driver;

    @Before
    public void profileSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikto\\OneDrive\\Робочий стіл\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ukr.net/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void sendEmail() {

        driver.switchTo().frame("mail widget");
        driver.findElement(By.name("login")).sendKeys("sendfortesting");
        driver.findElement(By.id("id-input-password")).sendKeys("Send1111!!");
        driver.findElement(By.xpath("//button [@class='form__submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div/a[@href='https://mail.ukr.net']")).click();
        Set<String> handleswindow = driver.getWindowHandles();
        for (String windowHandle : handleswindow) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//div/aside/button")).click();
        driver.findElement(By.className("input")).sendKeys("sendemailtest61@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("test case");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("This is a test email!!");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[text()=\"Надіслати\"]")).click();

    }
}
