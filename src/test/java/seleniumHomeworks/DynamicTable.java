package seleniumHomeworks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//Searching and Deleting an Employee by ID
//Navigate to `http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login`
//Search for an employee ID in the table and delete it dynamically.


public class DynamicTable {

    static WebDriver driver;

    public static void main(String[] args) {

        String employeeId = "111029A";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginToWebsite();
        WebElement employeeEntry = searchEmployeeID(employeeId);

        if (employeeEntry != null) {
            deleteEmployeeID(employeeEntry);
        } else {
            System.out.println("Employee ID not found.");
        }

        driver.quit();//close the driver
    }

    public static void loginToWebsite() {

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

    }

    public static WebElement searchEmployeeID(String employeeId) {

        //select PIM from the main menu to access table
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();

        WebElement employeeEntry = null;
        boolean notFound = true;

        while (notFound) {
            List<WebElement> tableEntries = driver.findElements(By.xpath("//table/tbody/tr"));
            for (WebElement entry : tableEntries) {
                String id = entry.findElement(By.xpath(".//td[2]")).getText(); //get the employee id
                if (id.equals(employeeId)) {
                    notFound = false; //set boolean to false if found
                    employeeEntry = entry;
                    break;
                }
            }

            if (notFound) {
                driver.findElement(By.xpath("//a[text()='Next'][1]")).click(); //click next button to go to next page
            }
        }
        return employeeEntry;
    }

    public static void deleteEmployeeID(WebElement entry) {

        entry.findElement(By.xpath(".//td[1]")).click();
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        System.out.println("Employee entry successfully deleted");

    }
}
