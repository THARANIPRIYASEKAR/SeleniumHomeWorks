package seleniumHomeworks;

//Form Submission Using Unique CSS Selectors

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS {
    public static void main(String[] args) {

        //the user navigates to `https://syntaxprojects.com/cssSelector-homework.php`
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/cssSelector-homework.php");

        /*The user should fill in all the text boxes in the form using*CSS selectors
        that are unique and return only one element (1/1)*/

        //enter user ID -> using css id
        WebElement userId = driver.findElement(By.cssSelector("input#UserID"));
        userId.sendKeys("Dusty");

        //enter userName -> using css id
        WebElement userName = driver.findElement(By.cssSelector("input#UserName"));
        userName.sendKeys("Dusty TheCool");

        //enter introToLecture - css name
        WebElement introToLecture = driver.findElement(By.cssSelector("input[name='LectureIntro']"));
        introToLecture.sendKeys("Intro to CSS");

        //enter Feedback from Ray - using css class name
        WebElement feedBackFromRay = driver.findElement(By.cssSelector("input.form-control.feedbackBox1"));
        feedBackFromRay.sendKeys("Informative");

        //enter Feedback from Ducky - using css class name
        WebElement feedBackFromDucky = driver.findElement(By.cssSelector("input.form-control.feedbackBox2"));
        feedBackFromDucky.sendKeys("Great");

        //enter Client ID - using css ends-with
        WebElement clientId = driver.findElement(By.cssSelector("input[data-ends$='conclientID']"));
        clientId.sendKeys("123456");

        //enter email - using css contains
        WebElement email = driver.findElement(By.cssSelector("input[name*='email']"));
        email.sendKeys("dusty@cool.com");

        //enter Client ID - using css starts-with
        WebElement courseTopic = driver.findElement(By.cssSelector("input[data-content^='CSS is an']"));
        courseTopic.sendKeys("CSS Selectors");

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
