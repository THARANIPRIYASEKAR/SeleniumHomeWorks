package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Verifying Radio Button Functionality
// navigate to `https://syntaxprojects.com/basic-radiobutton-demo-homework.php`
// check if all radio buttons are working as expected.
public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo-homework.php");

        //1. Choose Your Favorite Beverage:
        //   - Select the Juice radio button from the list of favorite beverages.
        List<WebElement> favouriteBeverage = driver.findElements(By.xpath("//input[@name='beverage']"));
        for (WebElement beverage : favouriteBeverage) {
            if (beverage.getAttribute("value").equals("Juice")) {
                beverage.click();
                System.out.println("Juice radio button is selected");
            }
        }

        //2. Preferred Working Environment:
        //   - Retrieve all radio buttons in the Preferred Working Environment section.
        //   - Traverse through the list of radio buttons in code and select the Hybrid option.
        List<WebElement> preferredWorkingEnv = driver.findElements(By.xpath("//input[@name='working_enviroment']"));
        for (WebElement workingEnv : preferredWorkingEnv) {
            if (workingEnv.getAttribute("value").equals("hybrid")) {
                workingEnv.click();
                System.out.println("Hybrid option is selected");
            }
        }
        //3. Choose Your Favorite Season:
        //   - If the Spring radio button is disabled, click on the "Enable Buttons" button.
        //   - Ensure that the Spring option is now enabled, then select it.
        List<WebElement> favouriteSeason = driver.findElements(By.xpath("//input[@name='season']"));
        for (WebElement season : favouriteSeason) {
            if (season.getAttribute("value").equals("spring")) {
                if (season.isEnabled()) {
                    System.out.println("Spring option is already enabled and is available for selection");
                } else {
                    WebElement enableButton = driver.findElement(By.xpath("//button[@id='enabledFruitradio']"));
                    enableButton.click();
                    season.click();
                    System.out.println("Spring option is enabled after clicking on enable button and then selected");
                }
            }
        }
        Thread.sleep(2000);
        //   - By default, the Winter radio button is hidden.
        //   Ensure, through code, that it is not displayed initially. Then click on the "Show Buttons" button.
        //   - Verify that the Winter option is displayed after clicking and is available for selection.
        for (WebElement season : favouriteSeason) {
            if (season.getAttribute("value").equals("winter")) {
                if (season.isDisplayed()) {
                    System.out.println("Winter option is already displayed and is available for selection");
                } else {
                    WebElement showButton = driver.findElement(By.xpath("//button[@id='showRadioButtons']"));
                    showButton.click();
                    season.click();
                    System.out.println("Winter option is displayed after clicking on show button and then selected");
                }
            }
        }

        //4. Choose Your Favorite Meal:
        //   - Select the Lunch radio button from the list of favorite meals.
        List<WebElement> favouriteMeal = driver.findElements(By.xpath("//input[@name='meal']"));
        for (WebElement meal : favouriteMeal) {
            if (meal.getAttribute("value").equals("lunch")) {
                meal.click();
                System.out.println("Lunch radio button is selected");
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}

