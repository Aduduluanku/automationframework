package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class invalidLoginTest extends BaseTest{

        @Test
        public void invalidBlankPasswordTest(){
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);

            homePage.clickSignInButton();
            //Nhập username
            //click login button
            loginPage.login("huydao226","");

            //Verify if there is error message displays
            loginPage.verifyErrorMessageIsDisplay();
        }

        @Test
        public void invalidUsernameTest(){
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);

                homePage.clickSignInButton();
                //Nhập username
                //click login button
                loginPage.login("dasdsadasdasdasdadsda","adasdsadasdasda");

                //Verify if there is error message displays
                loginPage.verifyErrorMessageIsDisplay();
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
