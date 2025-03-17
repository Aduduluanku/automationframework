package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFileSlotFromPanel(String filmName, String date){
        // Chọn Thời gian
        WebElement bookTime = driver.findElement(By.xpath("//h2[contains(text(),'"+filmName+"')]/following-sibling::div//p[text()='"+date+"']"));
        bookTime.click();
    }

    public void clickSignInButton() {
        driver.findElement(By.xpath("//a[@href=\"/sign-in\"]")).click();
    }

    public void selectHomeToolFilter(String filter, String option){
        driver.findElement(By.xpath("//select[option[@disabled and text()='"+filter+"']]")).click();
        driver.findElement(By.xpath("//option[text()='"+option+"']")).click();
    }

    public void verifyMovieIsMoana2(String movie) {
       String filmName = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(filmName, "Moana 2");
    }
}
