package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    // Top navigation Register link
    private final By registerLink = By.linkText("Register");

    // Registration form elements
    private By genderMale = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Waits up to 10 seconds
    }

    public void clickRegisterLink() {
        WebElement registerElement = wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerElement.click();
    }

    public void register(String fName, String lName, String userEmail, String pwd) {
        clickRegisterLink(); // Click the Register link first

        wait.until(ExpectedConditions.urlContains("/register")); // Ensure we are on the correct page

        driver.findElement(genderMale).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
        driver.findElement(registerButton).click();
    }
}
