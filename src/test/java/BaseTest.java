import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BaseTest {
    public WebDriver driver;
    @BeforeSuite
    //inititiate web driver and
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    //Added ChromeOptions argument below to fix websocket error
        public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
        //public void closeBrowser(){
        //driver.quit();
    }

    public void loginBttn() {
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']-"));
        loginButton.click();
    }

    public void inputPass(String Pass) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(Pass);
    }

    public void inputEmail(String Email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(Email);
    }

    public void navigateToSite() {
       String url = "https://qa.koel.app/";
       driver.get(url);
    }
}