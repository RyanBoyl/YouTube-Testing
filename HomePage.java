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
    /* Verify that video can be scrolled throuhg on the home page */
    @Test(priority = 1)
    void verifyScrollThroughVideos() throws InterruptedException {
        JavascriptExecutor executeable = (JavascriptExecutor) driver;
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        executeable.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
    } // verifyScrollThroughVideos

    /* Verfiy that clicking on 'Trending' directs user to trending */
    @Test(priority = 2)
    void verifyTrending() throws  InterruptedException{
        WebElement trending_button = driver.findElement(By.linkText("Trending"));
        trending_button.click();
        Thread.sleep(2000);
    } // verifyTrending

    /* Verfiy that clicking on 'Your Channel' directs user to their account channel information */
    @Test(priority = 3)
    void verifyAccountChannelInfo() throws InterruptedException{
        WebElement your_channel_button = driver.findElement(By.linkText("Your channel"));
        your_channel_button.click();
        Thread.sleep(2000);
    } // verifyAccountChannelInfo

    /* Verfiy that clicking 'History' redirects user to history */
    @Test(priority = 4)
    void verifyHistory() throws InterruptedException {
        WebElement history_button = driver.findElement(By.linkText("History"));
        history_button.click();
        Thread.sleep(2000);
    } // verifyHistory

    /* Verify that clicking 'subscriptions' directs users to their subscriptions */
    @Test(priority = 5)
    void verifySubscriptions() throws InterruptedException {
        WebElement subscriptions_button = driver.findElement(By.linkText("Subscriptions"));
        subscriptions_button.click();
        Thread.sleep(2000);
    } // verifySubscriptions

    /* Verify that clicking the bell icon displays notifications */
    @Test(priority = 6)
    void verifyBellIcon() throws InterruptedException {
        WebElement notification_bell = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[3]/div[2]/ytd-notification-topbar-button-renderer/yt-icon-button/button"));
        notification_bell.click();
        Thread.sleep(2000);
    } // verifyBellIcon

    /* Verify that clicking 'Watch later' directs user to watch later */
    @Test(priority = 7)
    void verifyWatchLater() throws InterruptedException {
        WebElement watch_later_button = driver.findElement(By.linkText("Watch later"));
        watch_later_button.click();
        Thread.sleep(2000);
    } // verifyWatchLater

    @Test(priority = 8)
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

    /*  Vefiy that clicking on 'Liked videos' directs user to their liked videos */
    @Test(priority = 9)
    void verifyLikedVideos() throws InterruptedException {
        WebElement liked_videos_button = driver.findElement(By.linkText("Liked videos"));
        liked_videos_button.click();
        Thread.sleep(2000);
    } // verifyLikedVideos
} // HomePage
 