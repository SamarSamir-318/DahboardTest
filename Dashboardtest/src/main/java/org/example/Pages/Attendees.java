package org.example.Pages;

import org.example.Utils.BaseClass;

public class Attendees extends BaseClass {

    private WebDriver driver;

    // Create New User webelement
    //Pesonal Info
    WebElement FirstName = driver.findElement(By.id("firstName"));
    WebElement LastName = driver.findElement(By.id("lastName"));
    WebElement title = driver.findElement(By.id("title"));
    WebElement Organization = driver.findElement(By.id("organization"));
    WebElement ContactNumber = driver.findElement(By.className("Input_root__fi0ZK"));
    WebElement Email  = driver.findElement(By.id("email"));
    WebElement Usertype = driver.findElement(By.name("userType"));

    //Credentials
    WebElement UserName = driver.findElement(By.id("username"));
    WebElement Password = driver.findElement(By.id("password"));

    // Constructor
    public Attendees(WebDriver driver) {
        this.driver = driver;
    }


    public void FillinForm() {
        // Navigate to the user creation page

        // Fill out the form fields
        AttendeesPage.firstName.sendKeys("John");
        lastNameField.sendKeys("Doe");
        titleField.sendKeys("Software Engineer");
        organizationField.sendKeys("XYZ Corp");
        emailField.sendKeys("john.doe@example.com");


        createButton.click();

        // Add assertions to verify successful user creation or any other expected behavior
    }

    public void NavigatetillCreateAtttendeePage() {
        // Click on "New Event"
        WebElement newEventButton = driver.findElement(By.className("Button_linkItem__9cKpC"));
        newEventButton.click();

        // Setup later square
        WebElement setupLaterSquare = driver.findElement(By.className("w-64 h-64 bg-secondary-accent border-2 border-secondary hover:border-white transition p-8 flex justify-center"));
        setupLaterSquare.click();

        // Click on registration
        WebElement registrationButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div[1]/aside/div/main/div[4]/div[1]/div"));
        registrationButton.click();

        // Click on attendees
        WebElement attendeesButton = driver.findElement(By.className("Text_root__M6tno"));
        attendeesButton.click();

        // Click on allurer
        WebElement CreateButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div[2]/div/div[1]/div[1]/div[1]"));
        allurerButton.click();

        // Click on "Add User"
        WebElement addUserButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div[2]/div/section/div[2]/div/div[6]/a"));
        addUserButton.click();
    }
}
