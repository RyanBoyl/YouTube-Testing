import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Channel extends SignIn
{
    @BeforeClass
    void setup() throws InterruptedException {
        driver.get("https://www.youtube.com/@NoCATNoLiFE/");
    }
    
    /* Verify that the user can subscribe and unsubscribe to the channel from the channel page */
    @Test(priority = 1)
    void subscribeFromChannel() throws InterruptedException
    {   
        // subscribe to the channel from the channel page
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/div[2]/div/div[1]/div/div[2]/div[2]/ytd-subscribe-button-renderer/yt-smartimation/div/__slot-el/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(10000);
        
        // Unsubscribe from the channel from the channel page
        driver.findElement(By.xpath("//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#items > ytd-menu-service-item-renderer:nth-child(4) > tp-yt-paper-item > yt-formatted-string")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the Aabout page can be viewed */
    @Test(priority = 2)
    void checkAboutPage() throws InterruptedException
    {   // Click on About page
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/div[2]/div/div[1]/div/div[1]/div[1]/ytd-channel-tagline-renderer/a/div/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        //Click off the About page
        driver.findElement(By.cssSelector("ytd-button-renderer.ytd-engagement-panel-title-header-renderer > yt-button-shape:nth-child(1) > button:nth-child(1) > yt-touch-feedback-shape:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the Video page can be cliked on */
    @Test(priority = 3)
    void checkVideoPage() throws InterruptedException
    {   
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/tp-yt-app-toolbar/div/div/tp-yt-paper-tabs/div/div/yt-tab-group-shape/div[1]/yt-tab-shape[2]/div[1]")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the channel's videos can be filtered by popularity */
    @Test(priority = 4)
    void popularFilter() throws InterruptedException
    {   
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[1]/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[1]/ytd-feed-filter-chip-bar-renderer/div/div/div[3]/iron-selector/yt-chip-cloud-chip-renderer[2]")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the channel's videos can be filtered by the oldest posted */
    @Test(priority = 5)
    void oldestFilter() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[1]/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[1]/ytd-feed-filter-chip-bar-renderer/div/div/div[3]/iron-selector/yt-chip-cloud-chip-renderer[3]")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the Live page can be clicked on */
    @Test(priority = 6)
    void checkLivePage() throws InterruptedException {
        driver.findElement(By.cssSelector("yt-tab-shape.yt-tab-shape-wiz:nth-child(3) > div:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    /* Verify that the Playlists page can be clicked on */
    @Test(priority = 7)
    void checkPlaylistsPage() throws InterruptedException {
        driver.findElement(By.cssSelector("yt-tab-shape.yt-tab-shape-wiz:nth-child(4) > div:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    /* Verify that the Community page can be clicked on */
    @Test(priority = 8)
    void checkCommunityPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/tp-yt-app-toolbar/div/div/tp-yt-paper-tabs/div/div/yt-tab-group-shape/div[1]/yt-tab-shape[5]/div[1]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a Community post can be clicked on */
    @Test(priority = 9)
    void checkCommunityPost() throws InterruptedException {
        driver.findElement(By.cssSelector("ytd-backstage-post-thread-renderer.style-scope:nth-child(1) > div:nth-child(1) > ytd-backstage-post-renderer:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > ytd-backstage-image-renderer:nth-child(1) > a:nth-child(1) > div:nth-child(1) > yt-img-shadow:nth-child(1) > img:nth-child(1)")).click();
        Thread.sleep(2000);
        
        //Return to channel page
        driver.findElement(By.cssSelector("yt-img-shadow.ytd-backstage-post-renderer > img:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    /* Verify that the search functionality for the channel page works */
    @Test(priority = 10)
    void searchChannelPage() throws InterruptedException
    { 
        // Go to search bar for the channel page and type test data
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/tp-yt-app-toolbar/div/div/tp-yt-paper-tabs/div/div/yt-tab-group-shape/div[1]/yt-tab-shape[6]/ytd-expandable-tab-renderer/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div/tp-yt-app-toolbar/div/div/tp-yt-paper-tabs/div/div/yt-tab-group-shape/div[1]/yt-tab-shape[6]/ytd-expandable-tab-renderer/form/tp-yt-paper-input/tp-yt-paper-input-container/div[2]/div/iron-input/input"));
        search.sendKeys("water"); // test data

        // Enter search
        search.sendKeys(Keys.RETURN);
        Thread.sleep(4000);
    }
}
 