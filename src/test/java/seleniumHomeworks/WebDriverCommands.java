package seleniumHomeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Browser Navigation and Window Management

public class WebDriverCommands {
    public static void main(String[] args) {

        //Create object instance for Chrome Driver
        WebDriver driver = new ChromeDriver();

        //The user successfully opens Chrome and maximizes the window using `window().maximize()`
        driver.manage().window().maximize();

        //The user navigates to `www.google.com`, and the page title is printed correctly
        driver.get("https://www.google.com");
        String pageTitle1 = driver.getTitle();
        System.out.println(pageTitle1);

        //The user navigates to `https://www.syntaxprojects.com/`, and the page title is printed correctly.
        driver.navigate().to("https://www.syntaxprojects.com/");
        String pageTitle2 = driver.getTitle();
        System.out.println(pageTitle2);

        //The user successfully navigates back to `www.google.com` using `navigate().back()`
        driver.navigate().back();

        // The page at `www.google.com` is refreshed using `navigate().refresh()`
        driver.navigate().refresh();

        //The browser closes after completing all the navigation steps
        driver.close();

    }
}
