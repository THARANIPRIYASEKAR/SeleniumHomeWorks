package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

//Verifying Window Popup Modal Functionality for Buttons B1 and B2
//navigate to `https://syntaxprojects.com/window-popup-modal-demo-homework.php`
//verify the functionality of Buttons B1 and B2.

public class WindowHandles {
    public static void main(String[] args) {

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");

        //1. Click on Button B1: Ensure that clicking on the **B1** button opens a new window
        WebElement B1PageBtn = driver.findElement(By.xpath("//a[text()='Open B1 Page ']"));
        B1PageBtn.click();
        System.out.println("B1 page successfully opened on a new window");

        // Get all window handles
        Set<String> allHandles = driver.getWindowHandles();
        String mainWindowHandle = driver.getWindowHandle();
        String welcomeMsg = null;

        for (String handle : allHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);

                //1- Verify that the text in the window opened by the **B1** button is **"Welcome to B1 page"**.
                if (driver.getCurrentUrl().equals("https://syntaxprojects.com/b1-page.php")) {
                    welcomeMsg = driver.findElement(By.tagName("h2")).getText();

                    if (welcomeMsg.equals("Welcome to B1 page")) {
                        System.out.println("The text on the B1 page aligns with the expected text");
                    } else {
                        System.out.println("Bug Found: The text on the B1 page doesn't align with the expected text");
                    }

                    driver.close(); // Close B1 window
                }
                driver.switchTo().window(mainWindowHandle); // Switch back to main window
            }
        }

        // Click on Button B2
        WebElement B2PageBtn = driver.findElement(By.xpath("//a[text()=' Open B2 Page ']"));
        B2PageBtn.click();
        System.out.println("B2 page successfully opened on a new tab");

        // Get all window handles
        allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);

                //2- Verify that the text in the window opened by the **B2** button is **"Welcome to B2 page"**.
                if (driver.getCurrentUrl().equals("https://syntaxprojects.com/b2-page.php")) {
                    welcomeMsg = driver.findElement(By.tagName("h2")).getText();

                    if (welcomeMsg.equals("Welcome to B2 page")) {
                        System.out.println("The text on the B2 page aligns with the expected text");
                    } else {
                        System.out.println("Bug Found: The text on the B2 page doesn't align with the expected text");
                    }

                    driver.close(); // Close B2 window
                }
            }
        }

        // Switch back to main window and quit the driver
        driver.switchTo().window(mainWindowHandle);
        driver.quit(); // Close all windows and end the session
    }
}

