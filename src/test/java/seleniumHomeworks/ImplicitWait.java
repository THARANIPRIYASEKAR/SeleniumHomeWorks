package seleniumHomeworks;


//Verifying Checkbox Selection Using Synchronization
//- I want to navigate to `https://syntaxprojects.com/synchronization-waits-homework.php`
//- So that I can verify the functionality of selecting **Option 1** in the checkbox after the appropriate wait time.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class ImplicitWait {

    public static void main(String[] args) {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/synchronization-waits-homework.php");

        //1. **Button Click and Checkbox Selection**:
        //   - Click on the button labeled **"Click me"**.
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[@id='show_text_synchronize_three']"));
        clickMeBtn.click();

        //   - Use an appropriate wait method to wait until the checkbox options appear.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for (WebElement option : checkboxes) {

                if (option.getAttribute("value").equals("Option-1")) {
                    option.click();
                    System.out.println("Option1 selected");
                    break;
                }

        }
        driver.quit();
    }
}
