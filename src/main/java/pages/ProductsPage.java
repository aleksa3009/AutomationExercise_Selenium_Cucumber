package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(css = ".features_items .product-image-wrapper")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    private List<WebElement> productNames;

    @FindBy(xpath = "//a[text()='View Product']")
    private List<WebElement> viewProductLinks;

    @FindBy(css = ".panel-title a")
    private List<WebElement> categoryLinks;

    @FindBy(css = ".brands-name a")
    private List<WebElement> brandLinks;

    public void searchProduct(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public int getDisplayedProductCount() {
        return productCards.size();
    }

    public String getProductName(int index) {
        return productNames.get(index).getText();
    }

    public void clickViewProduct(int index) {
        viewProductLinks.get(index).click();
    }

    public void filterByCategory(String categoryName) {
        for (WebElement category : categoryLinks) {
            if (category.getText().trim().equalsIgnoreCase(categoryName)) {
                category.click();
                break;
            }
        }
    }

    public void filterByBrand(String brandName) {
        for (WebElement brand : brandLinks) {
            if (brand.getText().trim().contains(brandName)) {
                brand.click();
                break;
            }
        }
    }
}
