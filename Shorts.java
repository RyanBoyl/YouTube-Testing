import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Shorts extends SignIn{
    @BeforeClass
    void setup() throws InterruptedException{
          driver.get("https://www.YouTube.com");
    } // setup
    
    /* Verfiy that shorts are present */
    @Test(priority = 1)
    void verifyShortAppears() throws InterruptedException{
        WebElement shorts_button = driver.findElement(By.linkText("Shorts"));
        shorts_button.click();
    } // verifyShortAppears
    
    /* Verify that shorts can be paused and resumed */
    @Test(priority = 2)
    void pauseandResumeShort() throws InterruptedException{
        // paused
        Thread.sleep(5000);
        WebElement pause_button = driver.findElement(By.xpath("//*[@id=\'player-container\']/div[1]/ytd-shorts-player-controls/yt-icon-button[1]"));
        pause_button.click();
        
        // resumed 
        Thread.sleep(2000);
        WebElement resume_button = driver.findElement(By.xpath("//*[@id=\'player-container\']/div[1]/ytd-shorts-player-controls/yt-icon-button[1]"));
        resume_button.click();
        Thread.sleep(2000);
    } // pauseShort

    /* Verify that shorts can be muted and unmuted*/ 
    @Test(priority = 4)
    void muteandUmuteShort() throws InterruptedException{
        // mute
        WebElement mute_button = driver.findElement(By.xpath("//*[@id=\"player-container\"]/div[1]/ytd-shorts-player-controls/yt-icon-button[2]"));
        mute_button.click();
        Thread.sleep(2000);
        
        // unmute 
        WebElement unmute_button = driver.findElement(By.xpath("//*[@id=\"player-container\"]/div[1]/ytd-shorts-player-controls/yt-icon-button[2]"));
        unmute_button.click();
        Thread.sleep(2000);
    } // muteShort

    /* Verify that shorts can be liked and unliked */
    @Test(priority = 5)
    void likeAndUnlikeShort() throws InterruptedException{
        // like
        WebElement like_button = driver.findElement(By.xpath("//*[@id=\'like-button\']/yt-button-shape/label/button"));
        like_button.click();
        Thread.sleep(2000);

        // unlike
        like_button.click();
        Thread.sleep(2000);
        
    } // likeandUnlikeShort

    /* Verify that shorts can be disliked and undisliked */
    @Test(priority = 7)
    void dislikeAndUndislikeShort() throws InterruptedException{
        // dislike
        WebElement unlike_button = driver.findElement(By.xpath("//*[@id=\'dislike-button\']/yt-button-shape/label/button/yt-touch-feedback-shape/div/div[2]"));
        unlike_button.click();
        Thread.sleep(2000);
        
        // undislike
        unlike_button.click();
        Thread.sleep(2000);
    } // dislikeandUndislikeShort

    /* Verify that shorts can be scrolled through (down and up) */
    @Test (priority = 8)
    void scrollThroughShorts() throws InterruptedException{
        // down
        WebElement down_arrow = driver.findElement(By.xpath("//*[@id=\'navigation-button-down\']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        down_arrow.click();
        Thread.sleep(2000);
        
        // up
        WebElement up_arrow = driver.findElement(By.xpath("//*[@id=\'navigation-button-up\']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        up_arrow.click();
        Thread.sleep(2000);
    } // scrollThroughShorts

    /* Verify that captions can be viewed */
    @Test(priority = 9)
    void testCaptions() throws InterruptedException{
        // click on 3 dots button
        WebElement three_dots_button = driver.findElement(By.xpath("//*[@id=\"menu-button\"]/ytd-menu-renderer"));
        three_dots_button.click();
        Thread.sleep(3000);
        
        // click on captions button
        WebElement captions_button = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-navigation-item-renderer[1]"));
        captions_button.click();
        Thread.sleep(3000);
    } // testCaptions

    /* Verify that the 'Description' is present */
    @Test(priority = 10)
    void testDescription() throws InterruptedException{
        // click on the 3 dots button
        WebElement three_dots_button = driver.findElement(By.xpath("//*[@id=\"menu-button\"]/ytd-menu-renderer"));
        three_dots_button.click();
        Thread.sleep(3000);
        
        // click on description button
        WebElement description_button = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]"));
        description_button.click();
        Thread.sleep(3000);
    } // testDescription
    
} // Shorts