package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Handling Iframe Interactions for Form Submission
//navigate to `https://syntaxprojects.com/handle-iframe-homework.php`
//enter the username, select a city, and click on the age checkbox while correctly handling iframes

public class IFrame {
    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/handle-iframe-homework.php");

        //1. Select Age Checkbox:- Select the **Age** checkbox.

        //switch the driver focus to iframe nested inside iframe2 -> by WebElement
        WebElement iframeDD = driver.findElement(By.xpath("//iframe[@id='dropdownIframe']"));
        driver.switchTo().frame(iframeDD);
        WebElement iframeCB = driver.findElement(By.xpath("//iframe[@id='checkboxIframe']"));
        driver.switchTo().frame(iframeCB);

        //locate the age checkbox and select it
        WebElement ageCB = driver.findElement(By.xpath("//input[@class='cb1-element']"));
        ageCB.click();
        System.out.println("Age selected successfully");

        //switch the driver focus back to main content
        driver.switchTo().defaultContent();

        //2. **Select City**:- Select any city from the dropdown.

        //switch the driver focus to iframe2 - by name
        driver.switchTo().frame("dropdown-iframe");

        //locate the city dropdown and select any city
        WebElement cityDD = driver.findElement(By.xpath("//select[@id='cities']"));
        Select selectCity = new Select(cityDD);
        selectCity.selectByIndex(2); //by index
        System.out.println("City selected successfully");

        //switch the driver focus back to main content
        driver.switchTo().defaultContent();

        //3. **Enter Username**:-enter your username in the **Username** field.

        //switch the driver focus to iframe1 ->by Index
        driver.switchTo().defaultContent().switchTo().frame(0);

        //locate the username field and enter username
        WebElement userName = driver.findElement(By.xpath("//input[@name='Username']"));
        userName.sendKeys("IFRAME1");
        System.out.println("Username entered successfully");


        Thread.sleep(2000);
        driver.quit();
    }
}
