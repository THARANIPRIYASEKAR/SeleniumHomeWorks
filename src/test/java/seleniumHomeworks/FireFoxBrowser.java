package seleniumHomeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Verify page title and URL of Syntax Projects

public class FireFoxBrowser {

    public static void main(String[] args) {

        //Create object instance for Firefox Driver
        WebDriver driver = new FirefoxDriver();

        /*The user should be able to launch a web browser and
          navigate to the URL `https://www.syntaxprojects.com/`*/
        driver.get("https://www.syntaxprojects.com");

        //The user should be able to maximize the browser window
        driver.manage().window().maximize();

        //The current URL should be printed on the console and match `https://www.syntaxprojects.com/`
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        /* The page title retrieved should be printed on the console
           and match `Syntax - Website to practice Syntax Automation Platform`*/
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //The browser should close automatically after retrieving both the URL and title
        driver.close();


    }
}
