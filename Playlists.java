// Necessary packages
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
public class Playlists extends SignIn{
    @Test (priority = 1)
    void createNewPlayList() throws InterruptedException{
        driver.get("https://www.youtube.com/watch?v=V2dJgrDqSdY&feature=youtu.be&themeRefresh=1");
        Thread.sleep(4000);
        WebElement three_dots_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[2]/div[2]/div/div/ytd-menu-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        three_dots_button.click();
        Thread.sleep(2000);
        WebElement save_button = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[2]/tp-yt-paper-item/yt-formatted-string"));
        save_button.click();
        Thread.sleep(2000);

        WebElement create_new_playlist_button = driver.findElement(By.linkText("Create new playlist"));
        create_new_playlist_button.click();
        Thread.sleep(2000);

        WebElement create_new_playlist_textbox = driver.findElement(By.cssSelector("#input-2 > input"));
        create_new_playlist_textbox.sendKeys("Test playlist");
        Thread.sleep(2000);

        WebElement create_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[3]/ytd-add-to-playlist-create-renderer/div/div/ytd-button-renderer"));
        create_button.click();
        Thread.sleep(2000);
    } // createNewPlayList
    @Test(priority = 2)
    void addVideosToPlayList() throws InterruptedException{

        // Add another video
        driver.get("https://www.youtube.com/watch?v=fJs68cn1K9s");
        Thread.sleep(2000);
        WebElement three_dots_button_2nd_video = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[2]/div[2]/div/div/ytd-menu-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        three_dots_button_2nd_video.click();
        Thread.sleep(2000);
        WebElement save_button_2nd_video = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown[1]/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[1]/tp-yt-paper-item/yt-icon/yt-icon-shape/icon-shape/div"));
        save_button_2nd_video.click();
        Thread.sleep(2000);
        WebElement test_playList_checkbox_2nd_video = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[2]/ytd-playlist-add-to-option-renderer[2]/tp-yt-paper-checkbox/div[1]"));
        test_playList_checkbox_2nd_video.click();
        Thread.sleep(2000);
        // Get out of the popup
        WebElement exit_button_2nd_video = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[1]/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div"));
        exit_button_2nd_video.click();
        Thread.sleep(2000);
        // Go back to YouTube main page
        WebElement YouTube_icon = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/ytd-topbar-logo-renderer/a/div/ytd-logo/yt-icon"));
        YouTube_icon.click();
        Thread.sleep(2000);
    } // addVideosToPlayList
    @Test(priority = 3)
    void viewPlayList() throws InterruptedException{
        WebElement playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-collapsible-section-entry-renderer/div[2]/ytd-guide-entry-renderer[3]/a/tp-yt-paper-item/yt-formatted-string"));
        playlist_button.click();
        Thread.sleep(2000);
        // Click on the playlist
        WebElement view_full_playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[6]/ytd-rich-grid-row[1]/div/ytd-rich-item-renderer[1]/div/yt-lockup-view-model/div/div[2]/yt-lockup-metadata-view-model/div[1]/div/yt-content-metadata-view-model/div[3]"));
        view_full_playlist_button.click();
        Thread.sleep(2000);
    } // viewPlayList
//    @Test(priority = 4)
//    void removeVideoFromPlayList()throws InterruptedException {
//        WebElement three_dots_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon/yt-icon-shape"));
//        three_dots_button.click();
//        Thread.sleep(2000);
//        WebElement remove_from_test_playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown[1]/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[4]/tp-yt-paper-item"));
//        remove_from_test_playlist_button.click();
//        Thread.sleep(2000);
//    } // removeVideoFromPlayList
    @Test(priority = 4)
    void modifyPlayListTitle() throws InterruptedException{
        // Title
        WebElement edit_title_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/ytd-inline-form-renderer/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        edit_title_button.click();
        Thread.sleep(2000);
        WebElement title_text_box = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/ytd-inline-form-renderer/div[2]/yt-text-input-form-field-renderer/tp-yt-paper-input/tp-yt-paper-input-container/div[2]/div/iron-input/input"));
        title_text_box.click();
        Thread.sleep(2000);
        title_text_box.clear();
        Thread.sleep(2000);
        title_text_box.sendKeys("New Title PlayList");
        Thread.sleep(2000);
        WebElement save_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/ytd-inline-form-renderer/div[2]/div/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        save_button.click();
        Thread.sleep(2000);
        // Description
//        WebElement edit_description_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/div[3]/ytd-inline-form-renderer/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
//        edit_description_button.click();
//        Thread.sleep(2000);
//       WebElement description_text_box = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/div[3]/ytd-inline-form-renderer/div[2]/yt-text-input-form-field-renderer/tp-yt-paper-textarea/tp-yt-paper-input-container/div[2]/div/tp-yt-iron-autogrow-textarea/div[2]/textarea"));
//       description_text_box.click();
//       Thread.sleep(2000);
//       description_text_box.sendKeys("Modified Playlist description");
    } // modifyPlayListTitle
    @Test(priority = 5)
    void sortByMostPopular() throws InterruptedException{
        WebElement sort_drop_down = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[1]/ytd-sort-filter-header-renderer/div/div[2]/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu"));
        sort_drop_down.click();
        Thread.sleep(2000);
        WebElement most_popular_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[1]/ytd-sort-filter-header-renderer/div/div[2]/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu/tp-yt-paper-menu-button/tp-yt-iron-dropdown/div/div/tp-yt-paper-listbox/a[3]"));
        most_popular_button.click();
        Thread.sleep(2000);
    } // sortByMostPopular
    @Test(priority = 6)
    void sortByPublishedNewest() throws InterruptedException{
        WebElement sort_drop_down = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[1]/ytd-sort-filter-header-renderer/div/div[2]/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu"));
        sort_drop_down.click();
        Thread.sleep(2000);
        WebElement date_published_newest_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[1]/ytd-sort-filter-header-renderer/div/div[2]/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu/tp-yt-paper-menu-button/tp-yt-iron-dropdown/div/div/tp-yt-paper-listbox/a[4]/tp-yt-paper-item/tp-yt-paper-item-body/div[1]/div"));
        date_published_newest_button.click();
        Thread.sleep(2000);
    } // sortByPublishedNewest

    @Test(priority = 7)
    void removeVideoFromPlayList()throws InterruptedException {
        WebElement three_dots_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon/yt-icon-shape"));
        three_dots_button.click();
        Thread.sleep(2000);
        WebElement remove_from_test_playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown[1]/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[4]/tp-yt-paper-item"));
        remove_from_test_playlist_button.click();
        Thread.sleep(2000);
    } // removeVideoFromPlayList

    @Test(priority = 8)
    void playPlaylist() throws InterruptedException{
        WebElement play_all_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-playlist-header-renderer/div/div[2]/div[1]/div/div[2]/ytd-button-renderer[1]/yt-button-shape/a/yt-touch-feedback-shape/div"));
        play_all_button.click();
        Thread.sleep(2000);
    } // playPlayList
    @Test(priority = 9)
    void loopPlayList() throws InterruptedException{
        WebElement loop_playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[2]/div/ytd-playlist-panel-renderer/div/div[1]/div/div[2]/div[1]/div[1]/ytd-menu-renderer/div[1]/ytd-playlist-loop-button-renderer/div/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div"));
        loop_playlist_button.click();
        Thread.sleep(3000);
        // turn off loop
        loop_playlist_button.click();
        Thread.sleep(3000);
    } // loopPlayList
    @Test(priority = 10)
    void shufflePlayList() throws InterruptedException{
        WebElement shuffle_playlist_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[2]/div/ytd-playlist-panel-renderer/div/div[1]/div/div[2]/div[1]/div[1]/ytd-menu-renderer/div[1]/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div"));
        shuffle_playlist_button.click();
        Thread.sleep(2000);
    } // shufflePlayList
    @Test(priority = 11)
    void removePlayList() throws InterruptedException{
        // Go to channel
        WebElement guide_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/yt-icon-button[2]/button/yt-icon/yt-icon-shape/icon-shape/div"));
        guide_button.click();
        Thread.sleep(2000);
        WebElement playlists_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-collapsible-section-entry-renderer/div[2]/ytd-guide-entry-renderer[3]/a/tp-yt-paper-item/yt-formatted-string"));
        playlists_button.click();
        Thread.sleep(2000);
        WebElement three_dots_button = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[6]/ytd-rich-grid-row[1]/div/ytd-rich-item-renderer[1]/div/yt-lockup-view-model/div/div[2]/yt-lockup-metadata-view-model/div[2]/button-view-model/button/yt-touch-feedback-shape/div"));
        three_dots_button.click();
        Thread.sleep(2000);
        WebElement delete_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown[2]/div/yt-sheet-view-model/yt-contextual-sheet-layout/div[2]/yt-list-view-model/yt-list-item-view-model[1]/div/div[2]/div/span"));
        delete_button.click();
        Thread.sleep(2000);
    } // removePlayList
    @AfterSuite
    void closeBrowser() throws InterruptedException{
        // Logout of YouTube
        // Click on the user's account
        WebElement sign_in_button = driver.findElement(By.id("avatar-btn"));
        sign_in_button.click();
        Thread.sleep(2000);
        // Click the 'Sign Out' button
        WebElement sign_out_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[3]/div[1]/yt-multi-page-menu-section-renderer[1]/div[2]/ytd-compact-link-renderer[3]/a/tp-yt-paper-item/div[2]/yt-formatted-string[1]"));
        sign_out_button.click();
        Thread.sleep(3500);
        // We are finished with all tests (We can close the browser)
        driver.quit();
    } // closeBrowser
} // PlayLists
 