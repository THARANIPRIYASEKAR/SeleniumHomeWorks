package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


//Verifying Dynamic Table Search Functionality
//Navigate to `https://syntaxprojects.com/table-search-filter-demo-homework.php`
//Ensure the table fulfills the following criteria dynamically.

public class StaticTable {

    public static void main(String[] args) {

        //Prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/table-search-filter-demo-homework.php");

        ////calling printEntriesByCountry method to print the entries for the given country
        printEntriesByCountry(driver, "USA");
        printEntriesByCountry(driver, "Canada");

        driver.quit();//close the driver
    }

    public static ArrayList<String> tableEntries(WebDriver driver, String country) {

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        ArrayList<String> entries = new ArrayList<>();

        //   - Dynamically search the table for entries with the country given
        for (WebElement row : rows) {
            String countryText =  row.findElement(By.xpath(".//td[3]")).getText();

            if (countryText.equals(country)) {
                entries.add(row.getText());
            }

        }

        return entries; // return the matching rows as arraylist
    }

    private static void  printEntriesByCountry(WebDriver driver, String country ){


        //calling tableEntries method to retreive the entries for the given country
        ArrayList<String> entriesByCountry = tableEntries(driver, country);

        // **Print All Entries for the given country
        System.out.println("Entries for " + country + ":");
        entriesByCountry.forEach(x-> System.out.println(x));

    }
}
