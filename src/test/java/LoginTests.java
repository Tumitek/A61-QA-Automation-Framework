import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        navigateToSite();
        inputEmail("ramiro.blaz@testpro.io");
        inputPass("bWPgs0uK");
        loginBttn();


        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));



        Assert.assertTrue(avatarIcon.isDisplayed());


    }

}
