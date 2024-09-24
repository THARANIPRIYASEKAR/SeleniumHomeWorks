package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Verifying Dropdown Without Select Tag Functionality
//Navigate to `https://syntaxprojects.com/no-select-tag-dropdown-demo-homework.php`
//ensure that the dropdown works as expected even without a `select` tag.
public class DropDownWithoutSelectTag {
    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/no-select-tag-dropdown-demo-homework.php");

        //click on the Choose your Dream Fruit button
        WebElement fruitDD = driver.findElement(By.xpath("//div[@id='dream_fruits']"));
        fruitDD.click();

        //1. Choose Your Dream Fruit:
        //   - Retrieve all options from the "Choose your Dream Fruit" dropdown.
        List<WebElement> dreamFruitsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu single-dropdown-menu']/li/a"));

        //   - Traverse through the list of options, and select **Mango**.
        //   - Ensure that the selection process is done by iterating through the options
        //   and not by directly clicking on the option using Xpath or any direct locator to the item.
        for (WebElement dreamFruit: dreamFruitsList){
            if(dreamFruit.getText().equals("Mango")){
                dreamFruit.click();
                System.out.println("Dream Fruit Mango selected");
            }

        }

        //click on the Choose your Favorite Hobbies
        WebElement hobbiesDD = driver.findElement(By.xpath("//div[@id='favorite_hobbies']"));
        hobbiesDD.click();

        //2. Choose Your Favorite Hobby:
        //   - Retrieve all options from the "Choose your Favorite Hobby" dropdown.
        List<WebElement> favouriteHobbiesList = driver.findElements(By.xpath("//ul[@class='dropdown-menu multi-dropdown-menu']/li/a"));

        //   - Traverse through the list and select **Reading**.
        //   - Ensure that the desired option is selected by iterating through the options,
        //   not by directly clicking on it using Xpath or any other direct locator to the item.
        for (WebElement favouriteHobby: favouriteHobbiesList){
            if(favouriteHobby.getText().equals("Reading")){
                favouriteHobby.click();
                System.out.println("Favourite Hobby Reading selected");
            }

        }

        Thread.sleep(2000);
        driver.quit();
    }
}
