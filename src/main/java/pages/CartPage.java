package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tr.cart_product")
    private List<WebElement> productRows;

    @FindBy(css = "td.cart_description h4 a")
    private List<WebElement> productNames;

    @FindBy(css = "td.cart_price p")
    private List<WebElement> productPrices;

    @FindBy(css = "td.cart_quantity input")
    private List<WebElement> quantityInputs;

    @FindBy(css = "td.cart_total p")
    private List<WebElement> totalPrices;

    @FindBy(css = "a.cart_quantity_delete")
    private List<WebElement> deleteButtons;

    @FindBy(css = ".cart_quantity_up")
    private List<WebElement> increaseButtons;

    @FindBy(css = ".cart_quantity_down")
    private List<WebElement> decreaseButtons;

    @FindBy(css = ".check_out")
    private WebElement proceedToCheckoutButton;

    public int getCartItemCount() {
        return productRows.size();
    }

    public String getProductName(int index) {
        return productNames.get(index).getText();
    }

    public String getUnitPrice(int index) {
        return productPrices.get(index).getText();
    }

    public String getQuantity(int index) {
        return quantityInputs.get(index).getAttribute("value");
    }

    public String getTotalPrice(int index) {
        return totalPrices.get(index).getText();
    }

    public void deleteProduct(int index) {
        deleteButtons.get(index).click();
    }

    public void increaseQuantity(int index) {
        increaseButtons.get(index).click();
    }

    public void decreaseQuantity(int index) {
        decreaseButtons.get(index).click();
    }

    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
