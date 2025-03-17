package scripts;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

@Listeners(SimpleListener.class)
public class cinemaBookingFromHomeToolTest extends BaseTest {

    @Test
    public void verifyBookingByHomeTool(){

        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        Actions actions = new Actions(driver);

        homePage.clickSignInButton();
        loginPage.login("huydao226", "asdEDZ12#");

        logger.info("Test Info");
        logger.warn("Test Warn");
        logger.debug("Test Debug");
        logger.error("Test Error");
        logger.fatal("Test Fatal");

//        homePage.selectFileSlotFromPanel("Raya","07-03-2022");
        homePage.verifyMovieIsMoana2("HÀNH TRÌNH CỦA MOANA 2");

        WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        actions.scrollToElement(homeTool);
        WebElement filmPlayButton = driver
                .findElement(By.xpath("//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')]"));
        actions.moveToElement(filmPlayButton).perform();

        //select Film
        homePage.selectHomeToolFilter("Phim", "HÀNH TRÌNH CỦA MOANA 2");
        homePage.selectHomeToolFilter("Rạp", "CGV - Aeon Bình Tân");
    }

    @Test
    public void verifyLoginWithInvalidPassword() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignInButton();
        //Nhập username
        //click login button
        loginPage.login("huydao226","");

        loginPage.inputUsername("huydao226");
        loginPage.inputPassword("sajdhaksjhd");

        //Verify if there is error message displays
        loginPage.verifyErrorMessageIsDisplay();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}