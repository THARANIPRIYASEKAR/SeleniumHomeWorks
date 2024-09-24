package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


//Verifying Dropdown and Multi-Select Functionality
//navigate to https://syntaxprojects.com/basic-select-dropdown-demo-homework.php
//verify that users can select the correct options from both single and multi-select dropdowns
public class DropDownWithSelectTag {
    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");

        //1. Select List Demo:
        //   - Use the **Select** class to select the option **"Pear"** from the dropdown.
        //   - You can use any method from the **Select** class (e.g., `selectByVisibleText`, `selectByValue`, `selectByIndex`).
        WebElement fruits = driver.findElement(By.xpath("//select[@id='fav_fruit_selector']"));
        Select selectFruit = new Select(fruits);
        selectFruit.selectByValue("Pear");
        System.out.println("Pear fruit is selected");
        //   - Use the **getOptions** method to retrieve all options from the dropdown and print them on the console.
        selectFruit.getOptions().forEach(x -> System.out.println(x.getText()));


        //2. Select Multiple Options:
        //   - First, verify that the **Select** dropdown is multi-select by checking the dropdown’s properties.
        WebElement hobbies = driver.findElement(By.xpath("//select[@id='select_multi_hobbies']"));
        Select selectHobby = new Select(hobbies);
        System.out.println("Is the Select Multi Options dropdown multi-select: "+ selectHobby.isMultiple());
        //   - Using the **Select** class, make the following selections:
        //     - **Traveling**
        selectHobby.selectByIndex(1);
        //     - **Cooking**
        selectHobby.selectByValue("Cooking");
        //     - **Gardening**
        selectHobby.selectByVisibleText("Gardening");
        System.out.println("Traveling,Cooking and Gardening options are selected");

        //   - Click the **"Get All Selected"** button and print the result on the console.
        WebElement getAllselectedBtn = driver.findElement(By.xpath("//button[@id='get_all']"));
        getAllselectedBtn.click();
        WebElement getAllSelected = driver.findElement(By.xpath("//p[@class='get_selected_values']"));
        String getAllSelectedActual = getAllSelected.getText();
        String getAllSelectedExpected ="Options selected are : Traveling,Cooking,Gardening";
        if(getAllSelectedExpected.equals(getAllSelectedActual)){
            System.out.println(getAllSelectedActual);
        }else {
            System.out.println("Bug Found: Get ALl Selected button doesn't retreive all the options selected");
        }


        //   - After a delay of 5 seconds, deselect the **Traveling** option using the **Select** class.
        Thread.sleep(5000);
        selectHobby.deselectByValue("Traveling");

        //   - Click the **"Get All Selected"** button again and print the result on the console.
        getAllselectedBtn.click();
        getAllSelectedActual = getAllSelected.getText();
        getAllSelectedExpected ="Options selected are : Cooking,Gardening";
        if(getAllSelectedExpected.equals(getAllSelectedActual)){
            System.out.println(getAllSelectedActual);
        }else {
            System.out.println("Bug Found: Get ALl Selected button doesn't retreive all the options selected");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
