package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#address_delivery li")
    private List<WebElement> deliveryAddressItems;

    @FindBy(css = "#address_invoice li")
    private List<WebElement> billingAddressItems;

    @FindBy(css = ".table.table-condensed")
    private WebElement orderSummaryTable;

    @FindBy(name = "message")
    private WebElement commentTextArea;

    @FindBy(css = "a.check_out")
    private WebElement placeOrderButton;

    public List<String> getDeliveryAddressLines() {
        return deliveryAddressItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getBillingAddressLines() {
        return billingAddressItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isOrderSummaryVisible() {
        return orderSummaryTable.isDisplayed();
    }

    public void enterComment(String comment) {
        commentTextArea.sendKeys(comment);
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public boolean verifyAddressMatch() {
        if (deliveryAddressItems.size() != billingAddressItems.size()) {
            return false;
        }

        for (int i = 0; i < deliveryAddressItems.size(); i++) {
            if (!deliveryAddressItems.get(i).getText().equals(billingAddressItems.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

}
