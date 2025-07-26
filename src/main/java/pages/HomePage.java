package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),' Home')]")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartLink;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactUsLink;

    @FindBy(id = "slider-carousel")
    private WebElement sliderCarousel;

    @FindBy(xpath = "//h2[contains(text(),'Category')]")
    private WebElement categorySection;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement subscriptionSuccessMessage;

    public void clickProductsLink() {
        productsLink.click();
    }

    public void clickSignupLoginLink() {
        signupLoginLink.click();
    }

    public void clickCartLink() {
        cartLink.click();
    }

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    public boolean isSliderVisible() {
        return sliderCarousel.isDisplayed();
    }

    public boolean isCategorySectionVisible() {
        return categorySection.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public void enterSubscriptionEmail(String email) {
        subscribeInput.clear();
        subscribeInput.sendKeys(email);
    }

    public void clickSubscribe() {
        subscribeButton.click();
    }

    public boolean isSubscriptionSuccessVisible() {
        return subscriptionSuccessMessage.isDisplayed();
    }
}
