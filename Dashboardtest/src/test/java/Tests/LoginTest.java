package Tests;

import org.example.Pages.LoginPage;
import org.example.Utils.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTest extends BaseClass {

    private LoginPage loginPage;

    @BeforeClass
    public static void setUpLoginPage() {
        // Initialize LoginPage object
        LoginTest test = new LoginTest();
        test.loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        // Enter valid username and password
        loginPage.enterUsername("Nxttester");
        loginPage.enterPassword("nxt#qA@23");
        loginPage.clickLoginButton();

        //click on skip button for test
        loginPage.clickSkipButtonforTest();

        //Assert on successful login when  MyEvent Text is displayed in homepage
        WebElement myEventsElement = driver.findElement(By.xpath("//*[contains(text(),'MyEvents')]"));
        Assert.assertTrue(myEventsElement.isDisplayed(), "MyEvents should appear after successful login");
     }

    @Test
    public void testInvalidLogin() {
        // Enter invalid username and password
        loginPage.enterUsername("invalidusername");
        loginPage.enterPassword("invalidpassword");
        loginPage.clickLoginButton();

        // Assert that the error message is displayed and has the correct text
        WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div/div/form/div/div[1]/div[2]/div[3]/p"));
        String errorMessageText = errorMessageElement.getText();
        Assert.assertEquals(errorMessageText, "Invalid login information, please check and try again.", "Error message should be displayed with the correct text for invalid login");

    }

    //Navigating to pages and validating no errors are displayed
    @Test
    public void testNoErrorsOnPages() {
        // Define a list of website pages to test this is a sample for pages
        String[] pagesToTest = {"https://qa-test-frontend-ce07bae316f3.herokuapp.com/explore", "https://qa-test-frontend-ce07bae316f3.herokuapp.com/itinerary/376",
                "https://qa-test-frontend-ce07bae316f3.herokuapp.com/updates/p/1" ,"https://qa-test-frontend-ce07bae316f3.herokuapp.com/packages",
        "https://qa-test-frontend-ce07bae316f3.herokuapp.com/applications/p/1"};


        // Loop through each page and check for errors
        for (String pageUrl : pagesToTest) {
            // Navigate to the page
            driver.get(pageUrl);

            // Check for error messages on the page
            boolean isErrorPresent = isErrorMessagePresent();

            // Assert that no errors are present
            Assert.assertFalse(isErrorPresent, "Error(s) found on page: " + pageUrl);
        }
    }

    private boolean isErrorMessagePresent() {
        // Check if any error message element is present on the page
        try {
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
            return errorMessageElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // No error message element found, return false
            return false;
        }
    }


}
