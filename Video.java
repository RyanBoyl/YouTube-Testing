import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Video extends SignIn
{
    /* Verify the video can be played and paused */
    @Test(priority = 1)
    void playAndPause() throws InterruptedException
    {   
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button")).click();
        Thread.sleep(2000);
    }

    /* Verify that the video can be muted and unmuted */
    @Test(priority = 2)
    void muteAndUnmute() throws InterruptedException
    {
        // mute
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > span > button")).click();
        Thread.sleep(2000);
        
        // unmute
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > span > button")).click();
        Thread.sleep(2000);
    }

    /* Verify that a video can go in and out of full screen */
    @Test(priority = 3)
    void fullScreen() throws InterruptedException
    {   
        driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
        Thread.sleep(2000);


        driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that a video can go in and out of theater mode */
    @Test(priority = 4)
    void theaterMode() throws InterruptedException
    {   
        // in
        driver.findElement(By.cssSelector(".ytp-size-button")).click();
        Thread.sleep(2000);
        
        // out
        driver.findElement(By.cssSelector(".ytp-size-button")).click();
        Thread.sleep(2000);
        
    }
    
    /* Verify that a video can be liked and unliked */
    @Test(priority = 6)
    void like() throws InterruptedException {
        // like
        driver.findElement(By.cssSelector("#top-level-buttons-computed > segmented-like-dislike-button-view-model > yt-smartimation > div > div > like-button-view-model > toggle-button-view-model > button-view-model > button > yt-touch-feedback-shape > div > div.yt-spec-touch-feedback-shape__fill")).click();
        Thread.sleep(2000);
        
        // unlike
        driver.findElement(By.cssSelector("#top-level-buttons-computed > segmented-like-dislike-button-view-model > yt-smartimation > div > div > like-button-view-model > toggle-button-view-model > button-view-model > button > yt-touch-feedback-shape > div > div.yt-spec-touch-feedback-shape__fill")).click();
        Thread.sleep(2000);
    }

    /* Verif that a video can be disliked */
    @Test(priority = 7)
    void dislike() throws InterruptedException {
        // dislike
        driver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/segmented-like-dislike-button-view-model/yt-smartimation/div/div/dislike-button-view-model/toggle-button-view-model/button-view-model/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        
        // undisliked
        driver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/segmented-like-dislike-button-view-model/yt-smartimation/div/div/dislike-button-view-model/toggle-button-view-model/button-view-model/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a user can subscribe and unsubscribe to a video's creator from a video */
    @Test(priority = 8)
    void subscribeFromVideo() throws InterruptedException {
        // Subscribe from video 
        driver.findElement(By.xpath("//*[@id=\"subscribe-button-shape\"]")).click();
        Thread.sleep(10000);
        
        // Unsubscribe from video
        driver.findElement(By.xpath("//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]/tp-yt-paper-item")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a video can be saved to the "Watch Later" playlist */
    @Test(priority = 9)
    void saveVideoToPlaylist() throws InterruptedException {
        // Click on three dots button
        driver.findElement(By.cssSelector("#button-shape > button > yt-touch-feedback-shape > div > div.yt-spec-touch-feedback-shape__fill")).click();
        Thread.sleep(2000);

        // add to playlist
        driver.findElement(By.cssSelector("#items > ytd-menu-service-item-renderer:nth-child(2) > tp-yt-paper-item > yt-formatted-string")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("ytd-playlist-add-to-option-renderer.style-scope:nth-child(1) > tp-yt-paper-checkbox:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(2000);
        
        // remove from playlist
        driver.findElement(By.cssSelector("ytd-playlist-add-to-option-renderer.style-scope:nth-child(1) > tp-yt-paper-checkbox:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(2000);
        
        // click off the playlist popup
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[1]/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
    }

    /* Verify that autoplay can be turned off and on */
    @Test(priority = 10)
    void autoplay() throws InterruptedException
    {   
        // turning autplay off
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-right-controls > button:nth-child(2) > div > div")).click();
        Thread.sleep(2000);
        
        // turning autoplay on
        driver.findElement(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-right-controls > button:nth-child(2) > div > div")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that a video's description can be viewed */
    @Test(priority = 11)
    void viewDescription() throws InterruptedException
    {
        // scroll into view
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement scroll = driver.findElement(By.cssSelector("yt-img-shadow.ytd-video-owner-renderer > img:nth-child(1)"));
        exe.executeScript("arguments[0].scrollIntoView();", scroll);
        Thread.sleep(2000);
        
        // click on "more" to see full description
        driver.findElement(By.xpath("//*[@id=\"expand\"]")).click();
        Thread.sleep(2000);
    }
}
