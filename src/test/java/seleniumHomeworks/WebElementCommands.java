package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Completing Actions on Form Using Selenium Commands

public class WebElementCommands {
    public static void main(String[] args) throws InterruptedException {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/selenium_commands_selector-homework.php");

        /*1. Retrieve Attribute:
        Retrieve the text "inspect me to view my custom attribute" from the element
        and print it on the console, ensuring the text is correct.*/

        WebElement attributeText = driver.findElement(By.xpath("//div[@id='textattr']"));
        String text = attributeText.getText();
        System.out.println("the text in the attribute section is : " + text);
        if (text.equals("inspect me to view my custom attribute")) {
            System.out.println("the text matches to the one mentioned in acceptance criteria");
        } else {
            System.out.println("the text doesn't match to the one mentioned in acceptance criteria");
        }

        //2. Meal Preference:

        //- Choose the checkbox for the meal preference "Musical Festival,"
        // ensuring the checkbox is enabled before clicking on it.
        WebElement musicFestival = driver.findElement(By.xpath("//input[@value='music_festival']"));
        if (musicFestival.isEnabled()) {
            musicFestival.click();
            System.out.println("Music Festival is enabled and selected");
        }else {
            System.out.println("Music Festival is disabled");
        }

        // - Ensure that the option for "Tech Talk" is disabled.
        WebElement techTalk = driver.findElement(By.xpath("//input[@value='tech_talk']"));
        if (!techTalk.isEnabled()) {
            System.out.println("Tech Talk is disabled");
        } else {
            System.out.println("Tech Talk is enabled");
        }

        // - Click on "Show More Options" and ensure the "Art Exhibition" option is displayed, then click on it
        WebElement showmoreButton = driver.findElement(By.xpath("//button[@onclick='toggleHiddenRadio(event)']"));
        showmoreButton.click();
        WebElement artExhibition = driver.findElement(By.xpath("//input[@value='art_exhibition']"));
        if (artExhibition.isDisplayed()) {
            artExhibition.click();
            System.out.println("Art Exhibition is displayed and selected");
        }else {
            System.out.println("Art Exhibition is not displayed");
        }

        //3. Mystery Message:
        //   - Retrieve the value of the attribute `title` from the element
        //   containing the text "Hover me to reveal the secret" and print it on the console.
        WebElement titleElement = driver.findElement(By.xpath("//div[@id='hidden_message']"));
        System.out.println("Hidden Message: " + titleElement.getAttribute("title"));

        //Option Box:
        //   - If "Checkbox 1" is enabled, click on it.
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='CheckboxFirst']"));
        boolean checkbox1Status = checkbox1.isEnabled();
        if(checkbox1Status){
            checkbox1.click();
            System.out.println("Checkbox 1 is enabled and selected");
        }else {
            System.out.println("Checkbox1 is disabled");
        }

        //   - Ensure that "Checkbox 2" is disabled.---
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='disabledCheckbox']"));
        boolean checkbox2Status = checkbox2.isEnabled();
        if(!checkbox2Status){
            System.out.println("Checkbox 2 is disabled");
        }else {
            System.out.println("Checkbox 2 is enabled");
        }

        //5. Input Field:
        //   - clear the text in the input box and
        //   send the text "here is the custom text entered" using selenium commands.
        WebElement textBox = driver.findElement(By.xpath("//input[@id='inputField']"));
        textBox.clear();
        textBox.sendKeys("here is the custom text entered");

        Thread.sleep(2000);
        driver.quit();
    }


}
