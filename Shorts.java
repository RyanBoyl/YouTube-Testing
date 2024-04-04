// Necessary packages
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
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\hoyen\\Downloads\\Chrome Driver\\chromedriver.exe");
//        driver =  new FirefoxDriver();
          driver.get("https://www.YouTube.com");
//        driver.manage().window().maximize();
//        Thread.sleep(30000); // For sign in
    } // setup


    @Test(priority = 1)
    void verifyShortAppears() throws InterruptedException{
        WebElement shorts_button = driver.findElement(By.linkText("Shorts"));
        shorts_button.click();
    } // verifyShortAppears


    @Test(priority = 2)
    void pauseandResumeShort() throws InterruptedException{
        Thread.sleep(5000);
        WebElement pause_button = driver.findElement(By.xpath("//*[@id=\'player-container\']/div[1]/ytd-shorts-player-controls/yt-icon-button[1]"));
        pause_button.click();
        Thread.sleep(2000);
        WebElement resume_button = driver.findElement(By.xpath("//*[@id=\'player-container\']/div[1]/ytd-shorts-player-controls/yt-icon-button[1]"));
        resume_button.click();
        Thread.sleep(2000);
    } // pauseShort


    @Test(priority = 4)
    void muteandUmuteShort() throws InterruptedException{
        WebElement mute_button = driver.findElement(By.xpath("//*[@id=\"player-container\"]/div[1]/ytd-shorts-player-controls/yt-icon-button[2]"));
        mute_button.click();
        Thread.sleep(2000);
        WebElement unmute_button = driver.findElement(By.xpath("//*[@id=\"player-container\"]/div[1]/ytd-shorts-player-controls/yt-icon-button[2]"));
        unmute_button.click();
        Thread.sleep(2000);
    } // muteShort


    @Test(priority = 5)
    void likeAndUnlikeShort() throws InterruptedException{
        WebElement like_button = driver.findElement(By.xpath("//*[@id=\'like-button\']/yt-button-shape/label/button"));
        like_button.click();
        Thread.sleep(2000);
    } // likeandUnlikeShort


    @Test(priority = 7)
    void dislikeAndUndislikeShort() throws InterruptedException{
        WebElement unlike_button = driver.findElement(By.xpath("//*[@id=\'dislike-button\']/yt-button-shape/label/button/yt-touch-feedback-shape/div/div[2]"));
        unlike_button.click();
        Thread.sleep(2000);
        unlike_button.click();
        Thread.sleep(2000);
    } // dislikeandUndislikeShort


    @Test (priority = 8)
    void scrollThroughShorts() throws InterruptedException{
        WebElement down_arrow = driver.findElement(By.xpath("//*[@id=\'navigation-button-down\']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        down_arrow.click();
        Thread.sleep(2000);
        WebElement up_arrow = driver.findElement(By.xpath("//*[@id=\'navigation-button-up\']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        up_arrow.click();
        Thread.sleep(2000);
    } // scrollThroughShorts


    @Test(priority = 9)
    void testCaptions() throws InterruptedException{
        WebElement three_dots_button = driver.findElement(By.xpath("//*[@id=\"menu-button\"]/ytd-menu-renderer"));
        three_dots_button.click();
        Thread.sleep(3000);
        WebElement captions_button = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-navigation-item-renderer[1]"));
        captions_button.click();
        Thread.sleep(3000);
    } // testCaptions


    @Test(priority = 10)
    void testDescription() throws InterruptedException{
        WebElement three_dots_button = driver.findElement(By.xpath("//*[@id=\"menu-button\"]/ytd-menu-renderer"));
        three_dots_button.click();
        Thread.sleep(3000);
        WebElement description_button = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]"));
        description_button.click();
        Thread.sleep(3000);
    } // testDescription
} // Shorts