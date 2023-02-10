package dz_lesson_7;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommodityPage extends MainPage {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//div[@class='col-12']//a[@href='/gruza/']")
    private WebElement mainMenuItem;

    @FindBy(xpath = "//div[@class='row']//a[@href='/gruza/bombardy/']")
    private WebElement categoryItem;

    @FindBy(xpath = "//a[@href='/gruza/bombardy/trout-master-ridge-sbiro/']")
    private WebElement commodityItem;

    @FindBy(xpath = "//td//strong[text()='12g Floating']/../..")
    private WebElement commodityVersionItem;

    @FindBy(xpath = "//input[@name='tocart[add]']")
    private WebElement addCommodityToBasket;

    @FindBy(xpath = "//li//a[@href='/cabinet/basket/']//i")
    private WebElement basketBtt;

    public CommodityPage(WebDriver driver){
        super(driver);
    }

    public CommodityPage pressMainMenuItem(){
        this.mainMenuItem.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gruza/")); // груза
        return this;
    }

    public CommodityPage pressCategoryItem(){
        this.categoryItem.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gruza/bombardy/")); // бомбарды
        return this;
    }

    public CommodityPage pressCommodityItem(){
        this.commodityItem.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/gruza/bombardy/trout-master-ridge-sbiro/")); // бомбарды trout-master-ridge-sbiro
        return this;
    }

    public CommodityPage pressCommodityVersionItem() throws InterruptedException{
        js.executeScript("window.scrollTo(0,700)");
        Thread.sleep(1000);
        this.commodityVersionItem.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("trout-master-ridge-sbiro/trout-master-ridge-sbiro-12g-floating/")); // бомбарда 12 грамм
        return this;
    }

    public CommodityPage pressAddCommodityToBasket() throws InterruptedException{
        js.executeScript("window.scrollTo(0,700)");
        Thread.sleep(1000);
        this.addCommodityToBasket.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("trout-master-ridge-sbiro/trout-master-ridge-sbiro-12g-floating/")); // бомбарда 12 грамм
        return this;
    }

    public CommodityPage pressBasketBtt(){
        getDriver().get("https://ribomaniya.ru/cabinet/basket/");
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("/cabinet/basket/")); // корзина
        return this;
    }

}
