package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void purchaseSlot(String number) {
        //Chọn ghế
        WebElement selectChair = driver.findElement(By.xpath("//span[contains(text(), '"+number+"')]"));
        selectChair.click();

        //Chọn Đặt vé:
        WebElement bookSelectedChairTicket = driver.findElement(By.xpath("//span[contains(text(), 'ĐẶT VÉ')]"));
        bookSelectedChairTicket.click();
    }
}
