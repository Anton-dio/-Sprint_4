package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class WishOrder {
    private WebDriver driver;
    //Кнопка Да в окне Хотите оформить заказ?
    private By okButton = By.xpath(".//*[text()='Да']");

    public WishOrder(WebDriver driver) {

        this.driver = driver;
    }

    //метод нажатия на кнопку Да
    public WishOrder clickOkButton() {

        driver.findElement(okButton).click();
        return this;
    }

}
