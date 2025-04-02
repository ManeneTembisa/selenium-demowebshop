/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.xpath("//input[@value='Log in']");

    public void loginUser(String userEmail, String userPassword) {
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(loginButton).click();
    }
}*/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By loginLink = By.linkText("Log in");  // Top navigation "Log in" link
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//input[@value='Log in']"); // Login button

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
    }

    // Click on the Login link in the navigation bar
    public void clickLoginLink() {
        WebElement loginElement = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginElement.click();
        wait.until(ExpectedConditions.urlContains("/login")); // Ensure URL is correct
    }

    // Perform login
    public void login(String email, String password) {
        clickLoginLink();  // Ensure login page is opened

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

