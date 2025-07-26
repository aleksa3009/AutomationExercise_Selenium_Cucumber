package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {

    private WebDriver driver;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginHeader;

    @FindBy(name = "email")
    private WebElement loginEmailInput;

    @FindBy(name = "password")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupHeader;

    @FindBy(name = "name")
    private WebElement signupNameInput;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement signupEmailInput;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement signupErrorMessage;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;

    public void login(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public void signup(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
    }

    public boolean isLoginErrorVisible() {
        return loginErrorMessage.isDisplayed();
    }

    public boolean isSignupErrorVisible() {
        return signupErrorMessage.isDisplayed();
    }

    public boolean isLoginHeaderVisible() {
        return loginHeader.isDisplayed();
    }

    public boolean isSignupHeaderVisible() {
        return signupHeader.isDisplayed();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public boolean isLoggedOut() {
        return loginHeader.isDisplayed();
    }
}
