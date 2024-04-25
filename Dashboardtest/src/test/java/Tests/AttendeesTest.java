package Tests;
import org.example.Pages.Attendees;
import org.example.Pages.LoginPage;
import org.example.Utils.BaseClass;
import org.junit.Test;

public class AttendeesTest extends BaseClass {

    private Attendees AttendeesPage;
    private LoginPage loginPage;

    @Test
    public void testCreateatttendee() {
        //login to app
        LoginPage.CompleteLogin();
        // Navigate to the user attendee creation page
        AttendeesPage.NavigatetillCreateAtttendeePage();
        // Fill out the form fields
        AttendeesPage.firstName.sendKeys("John");
        lastNameField.sendKeys("Doe");
        titleField.sendKeys("Software Engineer");
        organizationField.sendKeys("XYZ Corp");
        emailField.sendKeys("john.doe@example.com");
        createButton.click();

        // Step to Add assertions to verify successful user creation or any other expected behavior
    }
}
