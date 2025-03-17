package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String pwd){
        driver.findElement(By.xpath("//input[@id=\"taiKhoan\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id=\"matKhau\"]")).sendKeys(pwd);
        //Kiểm tra ô nhớ tài khoản đã check chưa?
        //Nếu chưa check -> Click vào
        WebElement remember = driver.findElement(By.name("remember"));
        boolean isRemember = remember.isSelected();
        if (!isRemember){
            remember.click();
        }
        driver.findElement(By.xpath("//span[text()='Đăng nhập']")).click();
    }

    public void inputUsername(String userName){
        driver.findElement(By.xpath("//input[@id=\"taiKhoan\"]")).sendKeys(userName);
    }

    public void inputPassword(String pwd){
        driver.findElement(By.xpath("//input[@id=\"matKhau\"]")).sendKeys(pwd);
    }

    public void verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//p[@id='matKhau-helper-text']"));
        Assert.assertTrue(errorMsg.equals(""));
    }
}
