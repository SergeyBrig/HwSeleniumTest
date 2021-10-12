import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HwSeleniumTest {

    WebDriver driver1;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Applications/Wedr/chromedriver");

        driver1 = new ChromeDriver();

            driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver1.manage().window().maximize();

    }

    @AfterMethod
    public void setDown(){
        driver1.quit();
    }

    @Test
    public void hwTest() {


            driver1.get("https://toywiz.com/login.php");

            WebElement username = driver1.findElement(By.id("login_email"));
            WebElement password = driver1.findElement(By.id("login_pass"));
            WebElement button = driver1.findElement(By.cssSelector(".form-actions .button, .form-actions a, .form-actions input"));

            username.sendKeys("adcfd@gmail.com");
            password.sendKeys("1492829");

            button.click();

            WebElement error = driver1.findElement(By.cssSelector(".alertBox-message"));

            Assert.assertEquals(error.getText(), "Your email address or password is incorrect. Please try again. If you've forgotten your sign in details, just click the 'Forgot your password?' link below.");



    }

    @Test
    public void linkTest (){
        driver1.get("https://toywiz.com/login.php");

        WebElement sendMail = driver1.findElement(By.id("nl_email"));
        WebElement signUp = driver1.findElement(By.cssSelector(".footer-top .newsletter-subscription .form .form-prefixPostfix .button, .footer-top .newsletter-subscription .form-field .form-prefixPostfix .button"));

        sendMail.sendKeys("as1t@gmail.com");
        signUp.click();

        Assert.assertEquals(driver1.getCurrentUrl(), "https://toywiz.com/subscribe.php?result=success");
    }
}
