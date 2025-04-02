package tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test
    public void testUserRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Tembisa", "Manene", "tembisa@example.com", "Password123");
    }
}
