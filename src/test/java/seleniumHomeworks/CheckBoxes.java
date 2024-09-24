package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Verifying Checkbox Functionality
// navigate to `https://syntaxprojects.com/basic-checkbox-demo-homework.php'
//ensure all the checkbox functionality is working as expected

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/basic-checkbox-demo-homework.php");

        //1. Subscribe to Newsletter:
        //   - Check if the "Subscribe to Newsletter" checkbox is enabled, and then click on it.
        WebElement newsLetter = driver.findElement(By.xpath("//input[@id='newsletter']"));
        if (newsLetter.isEnabled()) {
            newsLetter.click();
            System.out.println("Subscribe to Newsletter checkbox is enabled and selected");
        }


        //2.Select Your Hobbies:
        //   - Retrieve the list of all checkboxes in the **Select Your Hobbies** section.
        //   - Traverse through the list and select the **Reading** and **Cooking** checkboxes.
        List<WebElement> allHobbies = driver.findElements(By.xpath("//input[@class='cb-element']"));
        boolean hobbiesStatus = false;
        for (WebElement hobby : allHobbies) {
            String valueOfOption = hobby.getAttribute("id");
            if (valueOfOption.equals("cooking") || valueOfOption.equals("reading")) {
                hobby.click();
                hobbiesStatus = true;
            }
        }
        if(hobbiesStatus){System.out.println("Reading and Cooking checkboxes are selected under hobbies");}


        //3. Select Your Interests:
        //   - Verify that the **Support** and **Music** checkboxes are not displayed by default.
        //   - Click on the "Show Checkboxes" button, and then select the **Music** checkbox.
        WebElement supportCB = driver.findElement(By.xpath("//input[@value='Support' ]"));
        WebElement Music = driver.findElement(By.xpath("//input[@value='Music' ]"));
        if (!supportCB.isDisplayed() && !Music.isDisplayed()) {
            WebElement showBtn = driver.findElement(By.xpath("//button[@id='toggleCheckboxButtons']"));
            showBtn.click();
            Thread.sleep(2000);
            Music.click();
            System.out.println("Clicked on Show CheckBoxes and then selected Music option");
        }

        //4. Preferences:
        //   - Verify that the **Receive Notifications** checkbox is disabled.
        //   - Click on the "Enable Checkboxes" button, and then select the **Receive Notifications** checkbox.
        WebElement receiveNotification = driver.findElement(By.xpath("//input[@value='Receive-Notifications']"));
        if (!receiveNotification.isEnabled()) {
            WebElement enableCheckboxes = driver.findElement(By.xpath("//button[@id='enabledcheckbox']"));
            enableCheckboxes.click();
            receiveNotification.click();
            System.out.println("Receive Notifications is selected after enabling the checkboxes");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
