import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Comments extends SignIn {
    @BeforeClass
    void setup() throws InterruptedException {
        //Scroll to comments section
        JavascriptExecutor commentsScroll = (JavascriptExecutor) driver;
        WebElement comments = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[4]/div[1]/div/ytd-text-inline-expander/div[2]/ytd-structured-description-content-renderer/div/ytd-video-description-infocards-section-renderer/div[2]/div[2]/div/ytd-button-renderer[2]/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]"));
        commentsScroll.executeScript("arguments[0].scrollIntoView();", comments);
        Thread.sleep(2000);
    }
    
    /* Verify that a comment can be liked and unliked */
    @Test(priority = 1)
    void likeComment() throws InterruptedException {
        // liking a comment
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-toggle-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        // unliking a comment
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-toggle-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a comment can be disliked and undisliked */
    @Test(priority = 2)
    void dislikeComment() throws InterruptedException {
        // disliking a comment
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-toggle-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        // undisliking a comment 
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-toggle-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a comment can be edited */
    @Test(priority = 3)
    void testCommentEdit() throws InterruptedException {
        // Go to the comment
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-navigation-item-renderer[1]/a/tp-yt-paper-item/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        // Add a '!' to the end of the comment
        driver.findElement(By.cssSelector("#contenteditable-root")).sendKeys("!");
        Thread.sleep(2000);
        // Click 'Save'
        driver.findElement(By.cssSelector("#submit-button > yt-button-shape:nth-child(1) > button:nth-child(1) > yt-touch-feedback-shape:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    /* Verify that text can be entered in the 'Add a reply' box */
    @Test(priority = 4)
    void testReplyBox() throws InterruptedException {
        // Go to 'Add a reply' and send type test data
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contenteditable-root\"]")).sendKeys("Test478?%"); // test data
        Thread.sleep(2000);
        
        // Click the cancel button
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[2]/ytd-comment-reply-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/div[5]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that an emoji can be entered in the 'Add a reply' box */
    @Test(priority = 5)
    void testReplyBoxEmoji() throws InterruptedException {
        // Click on 'Add a reply'
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[2]/ytd-comment-reply-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/span[1]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        
        // get cat emoji
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[2]/ytd-comment-reply-dialog-renderer/ytd-commentbox/div[2]/div/div[6]/span/yt-emoji-picker-renderer/div[1]/tp-yt-paper-input/tp-yt-paper-input-container/div[2]/div/iron-input/input")).sendKeys("cat");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"\uD83D\uDE3A\"]")).click();
        Thread.sleep(2000);
        
        // Cancel sending the reply
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[2]/ytd-comment-reply-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/div[5]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a reply can be sent */
    @Test(priority = 6)
    void testReplySend() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[1]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contenteditable-root\"]")).sendKeys("Test Reply");
        Thread.sleep(2000);
        
        // Click the 'Reply' button to send it
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[2]/ytd-comment-engagement-bar/div[2]/ytd-comment-reply-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/div[5]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a reply can be deleted */
    @Test(priority = 7)
    void testReplyDelete() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/div/ytd-comment-replies-renderer/div[2]/ytd-comment-view-model/div[3]/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-navigation-item-renderer[2]/a/tp-yt-paper-item/yt-formatted-string")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/yt-confirm-dialog-renderer/div[2]/div[2]/yt-button-renderer[3]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that text can be entered in the 'Add a comment' box */
    @Test(priority = 8)
    void testCommentBox() throws InterruptedException {
        // Click on 'Add a comment box and type test data 
        driver.findElement(By.xpath("//*[@id=\"placeholder-area\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contenteditable-root\"]")).sendKeys("Test478?%"); // test data
        Thread.sleep(2000);
        
        // Cancel sending the comment
        driver.findElement(By.cssSelector("#thumbnail-input-row > div:nth-child(2) > div:nth-child(7) > div:nth-child(7) > ytd-button-renderer:nth-child(1) > yt-button-shape:nth-child(1) > button:nth-child(1) > yt-touch-feedback-shape:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    /* Verify that an emoji can be entered in the 'Add a comment' box */
    @Test(priority = 9)
    void testCommentBoxEmoji() throws InterruptedException {
        // Click on 'Add a commnent'
        driver.findElement(By.xpath("//*[@id=\"placeholder-area\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[5]/ytd-comment-simplebox-renderer/div[3]/ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/span[1]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
        
        // get cat emoji
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[5]/ytd-comment-simplebox-renderer/div[3]/ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[6]/span/yt-emoji-picker-renderer/div[1]/tp-yt-paper-input/tp-yt-paper-input-container/div[2]/div/iron-input/input")).sendKeys("cat");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"\uD83D\uDE3A\"]")).click();
        Thread.sleep(2000);
        
        // Cancel sending the comment
        driver.findElement(By.cssSelector("#thumbnail-input-row > div:nth-child(2) > div:nth-child(7) > div:nth-child(7) > ytd-button-renderer:nth-child(1) > yt-button-shape:nth-child(1) > button:nth-child(1) > yt-touch-feedback-shape:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    /* Verify that a comment can be sent */
    @Test(priority = 10)
    void testCommentSend() throws InterruptedException {
        // Click on comment box and type test data 
        driver.findElement(By.xpath("//*[@id=\"placeholder-area\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contenteditable-root\"]")).sendKeys("Test Comment"); // test data
        Thread.sleep(2000);
        
        // Click the 'Comment' button to send it
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[5]/ytd-comment-simplebox-renderer/div[3]/ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/div[5]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a comment can be deleted */
    @Test(priority = 11)
    void testCommentDelete() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-view-model/div[3]/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-navigation-item-renderer[2]/a/tp-yt-paper-item/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/yt-confirm-dialog-renderer/div[2]/div[2]/yt-button-renderer[3]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that comments can be sorted in different ways */
    @Test(priority = 12)
    void sortComments() throws InterruptedException {
        // Sort by "Newest first"
        driver.findElement(By.cssSelector("yt-sort-filter-sub-menu-renderer.ytd-comments-header-renderer > yt-dropdown-menu:nth-child(2) > tp-yt-paper-menu-button:nth-child(1) > div:nth-child(1) > tp-yt-paper-button:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[1]/div[2]/span/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu/tp-yt-paper-menu-button/tp-yt-iron-dropdown/div/div/tp-yt-paper-listbox/a[2]/tp-yt-paper-item/tp-yt-paper-item-body/div[1]/div")).click();
        Thread.sleep(2000);
        
        // Sort by "Top comments"
        driver.findElement(By.cssSelector("yt-sort-filter-sub-menu-renderer.ytd-comments-header-renderer > yt-dropdown-menu:nth-child(2) > tp-yt-paper-menu-button:nth-child(1) > div:nth-child(1) > tp-yt-paper-button:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[1]/div[2]/span/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu/tp-yt-paper-menu-button/tp-yt-iron-dropdown/div/div/tp-yt-paper-listbox/a[1]/tp-yt-paper-item/tp-yt-paper-item-body")).click();
        Thread.sleep(2000);
    }
}
 
