package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    private WebElement nameInputField;

    @FindBy(name = "email")
    private WebElement emailInputField;

    @FindBy(name = "subject")
    private WebElement subjectInputField;

    @FindBy(name = "message")
    private WebElement messageTextArea;

    @FindBy(name = "upload_file")
    private WebElement uploadFileInputButton;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = ".status.alert-success")
    private WebElement successAlert;

    @FindBy(css = ".status.alert-danger")
    private WebElement errorAlert;

    @FindBy(css = ".btn-success")
    private WebElement homeButton;

    public void fillContactForm(String name, String email, String subject, String message) {
        nameInputField.sendKeys(name);
        emailInputField.sendKeys(email);
        subjectInputField.sendKeys(subject);
        messageTextArea.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        uploadFileInputButton.sendKeys(filePath);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getSuccessMessage() {
        return successAlert.getText();
    }

    public String getErrorMessage() {
        return errorAlert.getText();
    }

    public void clickHomeButton() {
        homeButton.click();
    }

    public void clearForm() {
        nameInputField.clear();
        emailInputField.clear();
        subjectInputField.clear();
        messageTextArea.clear();
    }
}
