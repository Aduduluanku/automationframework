package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class cinemaInfoTest {

    static WebDriver driver;

    @BeforeClass
    public void classSetup(){
        System.out.println("Class Setup");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Setup Test - Before Method");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 Running");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 Running");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("TearDown Test - After Method");
    }

    @AfterClass
    public void classTearDown(){
        System.out.println("Class Teardown");
    }

    //BeforeTest
    // Truy cập vào trang web
    // Đăng nhập

    //BeforeClass
    //Đặt vé

    //Test
    //Kiểm tra có vé
    //KIểm tra thông tin vé
    //Kiểm tra trạng thái vé
    //Kiểm tra tìm kiếm v1

    //BeforeClass
    //Vào trang Profile

    //Test
    //Thay đổi tên
    //Thay đổi số điện thoại

}
