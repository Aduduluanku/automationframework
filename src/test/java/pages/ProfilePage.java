package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProfilePage {

    WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyBookingPrice(String price, String slot) {
        //Chọn avatar góc phải để xem danh sách vé đã chọn
        WebElement clickAvatar = driver.findElement(By.xpath("//a[@href='/account']"));
        clickAvatar.click();

        SoftAssert softAssert = new SoftAssert();

        String lastPurchasedPrice = driver.findElement(By.xpath("(//h3[contains(text(), 'Giá vé:')])[last()]")).getText();
//        Assert.assertTrue(lastPurchasedPrice.contains(price+" VND"),"Expected is : "+price+" but actual is "+lastPurchasedPrice);
        softAssert.assertTrue(lastPurchasedPrice.contains(price+" VND"),"Expected is : "+price+" but actual is "+lastPurchasedPrice);

        String lastBookingSlot = driver.findElement(By.xpath("(//h3[contains(text(), 'Ghế số:')])[last()]")).getText();
//        Assert.assertTrue(lastBookingSlot.contains(slot),"Expected is : "+slot+" but actual is "+lastBookingSlot);
        softAssert.assertTrue(lastBookingSlot.contains(slot),"Expected is : "+slot+" but actual is "+lastBookingSlot);
        softAssert.assertAll();
    }
}
