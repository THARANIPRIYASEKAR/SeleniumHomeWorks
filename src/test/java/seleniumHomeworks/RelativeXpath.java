package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.xpath.XPath;

//Fill Out Form Using XPath
public class RelativeXpath {

    public static void main(String[] args) {

        // the user navigates to `https://www.syntaxprojects.com/Xpath-homework.php`
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.syntaxprojects.com/Xpath-homework.php");

        //the user enters the necessary information in the form
        //enter hobbies using XPath -> attribute
        WebElement hobbies = driver.findElement(By.xpath("//input[@id='yourHobbiesId']"));
        hobbies.sendKeys("Dance");

        //"Button clicked:"` should be displayed on the screen upon clicking "Click here" button
        //using Xpath -> text
        WebElement clickHereButton = driver.findElement(By.xpath("//button[text()='Click Here']"));
        clickHereButton.click();

        //The user successfully enters their favorite movie using XPath to find the text boxes
        //using Xpath -> attribute
        WebElement favouriteMovies = driver.findElement(By.xpath("//input[@id='favoriteMoviesId']"));
        favouriteMovies.sendKeys("Vaazhai");

        /*The user uses the `contains()` method of XPath to locate a specific text element on the page
         and prints it to the console*/
        //using Xpath -> text
        WebElement paragraph = driver.findElement(By.xpath("//label[contains(text(),'consectetur adipisicing elit.')]"));
        System.out.println(paragraph.getText());

        //The user is able to enter the city in the designated field
        //using Xpath -> contains method
        WebElement city = driver.findElement(By.xpath("//input[contains(@name,'yourCity')]"));
        city.sendKeys("London");

        //The user must use the **indexing technique** learned in class to enter  email addresses
        //Enter personal email using Xpath -> indexing
        WebElement personalEmail = driver.findElement(By.xpath("(//input[@class='form-control backup'])[1]"));
        personalEmail.sendKeys("itispersonal@gmail.com");

        //Enter office email using Xpath -> indexing
        WebElement officeEmail = driver.findElement(By.xpath("(//input[@class='form-control backup'])[2]"));
        officeEmail.sendKeys("itisofficial@gmail.com");

        //Enter professional email using Xpath -> indexing
        WebElement professionalEmail = driver.findElement(By.xpath("(//input[@class='form-control backup'])[3]"));
        professionalEmail.sendKeys("itisprofressional@gmail.com");

        //The user must use the **operators technique** (e.g., `and`, `or`) to enter both the client name and client ID
        //using Xpath -> and operator
        WebElement clientName = driver.findElement(By.xpath("//input[@data-detail = 'one' and @name= 'clientName']"));
        clientName.sendKeys("Samantha");

        //using Xpath -> or operator
        WebElement clientId = driver.findElement(By.xpath("//input[@id = 'clientId' or @name= 'clientId']"));
        clientId.sendKeys("123456");

        //The user can use **any XPath technique** to enter the street number and house number
        //enter street number using Xpath -> starts-with
        WebElement streetNo = driver.findElement(By.xpath("//input[starts-with(@name,'Street')]"));
        streetNo.sendKeys("1919");

        //enetr house number using Xpath -> starts-with
        WebElement houseNo = driver.findElement(By.xpath("//input[starts-with(@name,'House')]"));
        houseNo.sendKeys("91");

        //wait time
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the browser
        driver.close();

    }
}
