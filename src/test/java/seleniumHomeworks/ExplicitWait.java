package seleniumHomeworks;

//Verifying Synchronization Using Explicit Waits
//Navigate to `https://syntaxprojects.com/synchronization-explicit-wait-homework.php`
//Ensure the text, button, and checkbox functionalities work as expected using appropriate wait times.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/synchronization-explicit-wait-homework.php");

        //creating instance for web driver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //1. **Change Text**:
        //   - Click on the button **"Click me to change text!"**.
        WebElement clickMeToChangeTxt = driver.findElement(By.xpath("//button[@id='changetext_button']"));
        clickMeToChangeTxt.click();
        WebElement headingText = driver.findElement(By.xpath("//h2[@id='headingtext']"));
        //   - Wait until the text changes to **"Ssyntaxtechs"**
        wait.until(ExpectedConditions.textToBePresentInElement(headingText,"Ssyntaxtechs"));
        //then print the text **"Ssyntaxtechs"** on the console
        if(headingText.getText().equals("Ssyntaxtechs")) {
            System.out.println("Text changed successfully and the text is: " + headingText.getText() + "- TEST PASS" );
        }else {
            System.out.println("Couldn't change the text: TEST FAIL");
        }


        //2. **Enable Button**:
        //   - Click on the button **"Click me to enable button"**.
        WebElement clickMeToEnableBtn = driver.findElement(By.xpath("//button[@id='enable_button']"));
        clickMeToEnableBtn.click();
        WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Button']"));
        //   - Wait for the button to be enabled, and once it's enabled, click on it.
        wait.until(ExpectedConditions.elementToBeClickable(enableBtn));
        if(enableBtn.isEnabled()) {
            System.out.println("The button is enabled - TEST PASS");
        }else {
            System.out.println("The button is not enabled - TEST FAIL");
        }


        //3. **Checkbox Checked Based on Click**:
        //   - Click on the button **"Click me to check the checkbox"**.
        WebElement clickMeToCheckCB = driver.findElement(By.xpath("//button[@id='checkbox_button']"));
        clickMeToCheckCB.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkbox']"));
        //   - Wait for the checkbox to be checked,
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        //   then print the status of **isSelected** on the console to verify if the checkbox is enabled.
        if(checkbox.isSelected()){
            System.out.println("The checkbox is selected - TEST PASS");
        }else{
            System.out.println("The checkbox is not selected - TEST FAIL");
        }


        driver.quit();
    }
}
