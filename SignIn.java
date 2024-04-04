// Necessary packages
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
/* For context, our test data is:
 *   Email   : test_person373@gmail.com
 *   Password: test_password123
 */
public class SignIn {
    public static WebDriver driver;
    @BeforeSuite
        /* Needed for getting the website setup */
    void setup() throws InterruptedException{
        System.setProperty("webdriver.firefox.driver","C:\\Users\\david\\Web Browser Drivers\\Chrome_driver\\chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://www.YouTube.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    } // setup
    /* Clicking the 'Sign in' button */
    @Test (priority = 1)
    void clickOnSignInButton() throws InterruptedException{
        WebElement sign_in_button = driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]"));
        sign_in_button.click();
        Thread.sleep(2000);
    } // clickOnSignInButton
    /* Verify that text in the email field can be entered */
    @Test (priority = 2)
    void emailFieldChars() throws InterruptedException{
        WebElement email_text_box = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email_text_box.click();
        email_text_box.sendKeys("hellothere$%~!@"); // test data
        Thread.sleep(2000);
        email_text_box.clear();
        Thread.sleep(2000);
    } // emailFieldChars
    /*  Verify that a blank email will not allow the user to proceed after entering a blank email*/
    @Test (priority = 3)
    void giveBlankEmail() throws InterruptedException{
        // Email text box
        WebElement email_text_box = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email_text_box.click();
        email_text_box.sendKeys(""); // Blank email
        // Click on the next 'Next text box"
        WebElement next_text_box = driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
        next_text_box.click();
        Thread.sleep(2000);
    } // giveBlankEmail
    @Test (priority = 4)
        /*  Verify that entering a incorrect email will not allow the user to proceed */
    void enterIncorrectEmail() throws InterruptedException{
        WebElement email_text_box = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email_text_box.click();
        email_text_box.sendKeys("incorrect_email@gmail.com"); // Incorrect email
        // Click on the next 'Next text box"
        WebElement next_text_box = driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
        next_text_box.click();
        Thread.sleep(2000);
        // Clear the keys
        email_text_box.clear();
    } // enterIncorrectEmail
    @Test (priority = 5)
        /* Verify that providing a correct email will allow the user to proceed */
    void enterCorrectEmail() throws InterruptedException{
        WebElement email_text_box = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email_text_box.click();
        email_text_box.sendKeys("testperson373@gmail.com"); // correct email (from test data)
        // Click on the next 'Next' text box
        WebElement next_text_box = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        next_text_box.click();
        Thread.sleep(2000);
    } // enterCorrectEmail
    @Test (priority = 6)
        /* Verify that text can be entered in the password field */
    void passwordFieldChars() throws InterruptedException{
        WebElement show_password_check_box = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[3]/div/div[1]/div/div/div[1]/div/div/input"));
        show_password_check_box.click();
        Thread.sleep(2000);
        WebElement password_text_box = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
        password_text_box.click();
        password_text_box.sendKeys("test123@#$~"); // Test data
        Thread.sleep(2000);
        password_text_box.clear();
    } // passwordFieldChars
    @Test (priority = 7)
        /* Verify that providing a blank password will not allow the user to proceed */
    void enterBlankPassword() throws InterruptedException{
        WebElement password_text_box = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
        password_text_box.click();
        password_text_box.sendKeys(""); // Blank
        Thread.sleep(2000);
        WebElement next_box = driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
        next_box.click();
        Thread.sleep(2000);
    }  // giveBlankPassword
    @Test (priority = 8)
        /* Verify that a incorrect password will not allow the user to proceed */
    void enterInvalidPassword() throws InterruptedException{
        WebElement password_text_box = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
        password_text_box.click();
        password_text_box.sendKeys("invalid_password123"); // Test data
        Thread.sleep(2000);
        WebElement next_box = driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
        next_box.click();
        password_text_box.clear();
        Thread.sleep(2000);
    } // enterInvalidPassword
    @Test (priority = 9)
        /*Verify that a correct password will allow the user to proceed */
    void enterValidPassword() throws InterruptedException{
        WebElement password_text_box = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
        password_text_box.click();
        password_text_box.sendKeys("test_password123"); // correct password (from test data)
        Thread.sleep(2000);
        WebElement next_box = driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
        next_box.click();
    } // enterValidPassword
    /* Verify that the user can sign out */
//    @Test (priority = 10)
//    void signOut() throws InterruptedException{
//
//        // Click on the user's account
//        WebElement sign_in_button = driver.findElement(By.id("avatar-btn"));
//        sign_in_button.click();
//        Thread.sleep(2000);
//
//        // Click the 'Sign Out' button
//        WebElement sign_out_button = driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[3]/div[1]/yt-multi-page-menu-section-renderer[1]/div[2]/ytd-compact-link-renderer[3]/a/tp-yt-paper-item/div[2]/yt-formatted-string[1]"));
//        sign_out_button.click();
//        Thread.sleep(2000);
//    } // signOut
    /* Close YouTube (we are done) */
    //@AfterClass
    // void closeBrowser(){
    //driver.close();
    //} // closeBrowser
} // SignIn
 