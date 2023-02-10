package dz_lesson_7;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage{
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    // товар найденный по наименованию
    @FindBy(xpath = "//a/span[text()='Trout Master Ridge Sbiro (12g Floating)']")
    private WebElement currentCommodity;

    // кнопка удаления товара
    @FindBy(xpath = "//span[@class='basket-item-actions-remove']")
    private WebElement deleteCommodity;

    // итоговая стоимость корзины
    @FindBy(xpath = "//div[@data-entity='basket-total-price']")
    private WebElement currentPrice;

    public CartPage(WebDriver driver){

        super(driver);
    }

    public String getCommodityText()throws InterruptedException{
        js.executeScript("window.scrollTo(0, 400)");
        Thread.sleep(1000);
        return this.currentCommodity.getText();
    }

    public CartPage pressDelCommodity() throws InterruptedException{
        this.deleteCommodity.click();
        Thread.sleep(2500);
        return this;
    }

    public String getPriceText(){

        return this.currentPrice.getText();
    }







}
