import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Search extends SignIn
{
    /* Verify that the search box can take characters numbers and symbols */
    @Test(priority = 1)
    void searchBoxChars() throws InterruptedException
    {   
        driver.findElement(By.cssSelector("input#search")).sendKeys("Test478?%");
        Thread.sleep(2000);
    }
    
    /* Verify that a search can be cleared */
    @Test(priority = 2)
    void clearSearch() throws InterruptedException
    {   
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[2]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that a search occurs when the search button is clicked */
    @Test(priority = 3)
    void performSearch() throws InterruptedException
    { 
        driver.findElement(By.cssSelector("input#search")).sendKeys("Mr. Fresh Eating for 8 Minutes");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        Thread.sleep(2000);
    }
    
    /* Verify that the filters button can be clicked */
    @Test(priority = 4)
    void filtersButton() throws InterruptedException
    {   
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(2000);
    }

    /* Verify that a "Type" filter can be applied */
    @Test(priority = 5)
    void typeFilter() throws InterruptedException {
        driver.findElement(By.cssSelector("ytd-search-filter-group-renderer.style-scope:nth-child(2) > ytd-search-filter-renderer:nth-child(2) > a:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")).click();
        // ^ "Video" filter
        Thread.sleep(2000);
    }
    
    /* Verify that a "Duration" filter can be applied */
    @Test(priority = 6)
    void durationFilter() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        // ^ return to filters
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("ytd-search-filter-group-renderer.style-scope:nth-child(3) > ytd-search-filter-renderer:nth-child(4) > a:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")).click();
        // ^ "4 - 20 minutes" filter
        Thread.sleep(2000);
    }

    /* Verify that an "Upload Date" filter can be applied */
    @Test(priority = 7)
    void uploadDateFilter() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        // ^ return to filters
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("ytd-search-filter-group-renderer.style-scope:nth-child(1) > ytd-search-filter-renderer:nth-child(10) > a:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")).click();
        // ^ "This year" filter
        Thread.sleep(2000);
    }

    /* Verify that a "Sort By" filter can be applied */
    @Test(priority = 8)
    void sortByFilter() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        // ^ return to filters
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("ytd-search-filter-group-renderer.style-scope:nth-child(5) > ytd-search-filter-renderer:nth-child(6) > a:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")).click();
        // ^ "View Count" filter
        Thread.sleep(2000);
    }

    /* Verify that a "Features filter can be applied */
    @Test(priority = 9)
    void featuresFilter() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        // ^ return to filters
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("ytd-search-filter-group-renderer.style-scope:nth-child(4) > ytd-search-filter-renderer:nth-child(6) > a:nth-child(1) > div:nth-child(1) > yt-formatted-string:nth-child(1)")).click();
        // ^ "HD" filter
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/div/ytd-search-header-renderer/div[3]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        // ^ return to filters (show that all have been clicked on)
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-search-filter-options-dialog-renderer/div[1]/yt-icon-button/button/yt-icon/yt-icon-shape/icon-shape/div")).click();
        //Click off the filters screen
        Thread.sleep(2000);
    }

    /* Verify that a video can be clicked on after searching */
    @Test(priority = 10)
    void searchClickVideo() throws InterruptedException
    {  
        driver.findElement(By.partialLinkText("Mr. Fresh Eating for 8 Minutes")).click();
        Thread.sleep(6000);
    }
}
