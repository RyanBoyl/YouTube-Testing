import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.ArrayList;
import java.util.Set;
public class HomePage extends SignIn {
    @BeforeClass
    void setup() {
        //System.setProperty("webdriver.firefox.driver", "C:\\Users\\david\\Web Browser Drivers\\FireFox_driver\\geckodriver.exe");
        //driver = new ChromeDriver();
    } // setup
    @Test(priority = 1)
    void verifyHomePageAppears() throws InterruptedException {
        //driver.get("https://www.YouTube.com");
        //driver.manage().window().maximize();
        //Thread.sleep(23000);
    } // verifyHomePageAppears
    @Test(priority = 2)
    void verifyScrollThroughVideos() throws InterruptedException {
        JavascriptExecutor executeable = (JavascriptExecutor) driver;
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
    } // verifyScrollThroughVideos
    @Test(priority = 3)
    void verifyTrending() throws  InterruptedException{
        WebElement trending_button = driver.findElement(By.linkText("Trending"));
        trending_button.click();
        Thread.sleep(2000);
    } // verifyTrending
    @Test(priority = 4)
    void verifyAccountChannelInfo() throws InterruptedException{
        WebElement your_channel_button = driver.findElement(By.linkText("Your channel"));
        your_channel_button.click();
        Thread.sleep(2000);
    } // verifyAccountChannelInfo
    @Test(priority = 5)
    void verifyHistory() throws InterruptedException {
        WebElement history_button = driver.findElement(By.linkText("History"));
        history_button.click();
        Thread.sleep(2000);
    } // verifyHistory
    @Test(priority = 6)
    void verifySubscriptions() throws InterruptedException {
        WebElement subscriptions_button = driver.findElement(By.linkText("Subscriptions"));
        subscriptions_button.click();
        Thread.sleep(2000);
    } // verifySubscriptions

    @Test(priority = 7)
    void verifyBellIcon() throws InterruptedException {
        WebElement notification_bell = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[3]/div[2]/ytd-notification-topbar-button-renderer/yt-icon-button/button"));
        notification_bell.click();
        Thread.sleep(2000);
    } // verifyBellIcon
    @Test(priority = 8)
    void verifyWatchLater() throws InterruptedException {
        WebElement watch_later_button = driver.findElement(By.linkText("Watch later"));
        watch_later_button.click();
        Thread.sleep(2000);
    } // verifyWatchLater
    @Test(priority = 9)
    void verifyYourVideos() throws InterruptedException{
        Set<String> parent_window = driver.getWindowHandles();
        WebElement your_videos_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-collapsible-section-entry-renderer/div[2]/ytd-guide-entry-renderer[4]/a/tp-yt-paper-item/yt-formatted-string"));
        your_videos_button.click();  // After clicking the your_videos_button it will open in a new tab
        Thread.sleep(3000);
        // Switch back to home page
        ArrayList<String> list = new ArrayList<String>(parent_window);
        driver.switchTo().window(list.get(0));
        Thread.sleep(2000);
    } // verifyYourVideos
    @Test(priority = 10)
    void verifyLikedVideos() throws InterruptedException {
        WebElement liked_videos_button = driver.findElement(By.linkText("Liked videos"));
        liked_videos_button.click();
        Thread.sleep(2000);
    } // verifyLikedVideos
} // HomePage
 