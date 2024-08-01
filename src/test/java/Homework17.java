import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {
        @Test
        public void addSongToPlaylist() {
            navigateToSite();
            inputEmail("ramiro.blaz@testpro.io");
            inputPass("bWPgs0uK");
            loginBttn();
            WebElement searchField = driver.findElement(By.cssSelector(""));
            searchField.clear();
            searchField.sendKeys("HoliznaCCO");
            WebElement viewAll = driver.findElement(By.id("button[data-test='view-all-songs-btn']"));
            viewAll.click();
            WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"));
            firstSong.click();
            WebElement addTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
            addTo.click();
            WebElement favList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[4]"));
            favList.click();
            WebElement addSongNotice = driver.findElement(By.xpath("//div[@class='alertify-logs top right']"));
            Assert.assertEquals(addSongNotice, "Added 1 song into favorites", "Add song notification not present.");
            //WebElement favPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[1]/a"));
            //favPlaylist.click();

            //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));


           /* String url = "https://qa.koel.app/";
            driver.get(url);
            Assert.assertTrue(avatarIcon.isDisplayed());
            */
        }

    }


