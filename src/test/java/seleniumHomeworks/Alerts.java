package seleniumHomeworks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Verifying JavaScript Alerts Functionality
// navigate to `https://syntaxprojects.com/javascript-alert-box-demo-homework.php`
//ensure the alerts functionality is working as expected

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php");

        //1. Birthday Reminder:
        //   - Click on the "Birthday Reminder" button.
        WebElement birthdayReminder = driver.findElement(By.xpath("//button[@onClick='myAlertFunction()']"));
        birthdayReminder.click();
        //   - When the alert appears, accept the alert.
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();


        //2. Delete Confirmation:
        //   - Click on the **"Delete File"** button.
        WebElement deleteFile = driver.findElement(By.xpath("//button[@onClick='myConfirmFunction()']"));
        deleteFile.click();
        Thread.sleep(2000);
        //   - When the confirmation alert appears, **dismiss** the alert.
        alert.dismiss();
        //   - Print the status of the action (e.g., "File deletion canceled") that appears on the screen, to the console.
        String cancelMessage = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        System.out.println(cancelMessage);

        //3. Name Collection:
        //   - Click on the **"Enter Your Name"** button.
        WebElement enterName = driver.findElement(By.xpath("//button[@onClick='myPromptFunction()']"));
        enterName.click();
        //   - Accept the alert and provide a name.
        alert.sendKeys("KingKong");
        alert.accept();
        //   - Retrieve the name that appears on the screen UI
        //   and print it on the console, verifying that the correct name is displayed.
        String nameConfirmation = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        if (nameConfirmation.contains("KingKong")) {
            System.out.println("Displayed name matches the entered name");
        } else {
            System.out.println("Bug Found: Displayed name doesn't match with the entered name");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
