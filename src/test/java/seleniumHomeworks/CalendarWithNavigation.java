package seleniumHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Month;
import java.util.List;

// ### User Story
//Verifying Dynamic Date Selection in the jQuery Date Picker
//Navigate to `https://syntaxprojects.com/jquery-date-picker-demo-homework.php`
//Ensure the correct "To" and "From" dates are selected from the calendar.

//#### Acceptance Criteria
//
//1. **Select "From" and "To" Dates**:
//   - Select the **From** date and the **To** date in the jQuery date picker.
//   - The code logic should be **dynamic**, meaning it should work with any selected dates without requiring any changes to the core logic.
//   - The selection should not rely on hard-coded date values and should be adaptable if the date range changes.

public class CalendarWithNavigation {

    WebDriver driver;
    String date;
    String month;
    String year;

    //open the browser
    public void openBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //implicit/global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    //store the inputted date values to instance variables
    public void getDate(String month, String date, String year) {
        this.month = month;
        this.date = date;
        this.year = year;
    }

    //set fromdate
    public void fromDate(String month, String date, String year) {
        getDate(month, date, year);
        WebElement fromDateInputBox = driver.findElement(By.xpath("//input[@id='from_date']"));
        fromDateInputBox.click();
        selectYear();
    }

    //set todate
    public void toDate(String month, String date, String year) {
        getDate(month, date, year);
        WebElement toDateInputBox = driver.findElement(By.xpath("//input[@id='to_date']"));
        toDateInputBox.click();
        selectYear();
    }

    //compare the current year with inputted year
    public void selectYear() {

        boolean notFound = true;

        while (notFound) {
            WebElement year = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']"));

            if (Integer.parseInt(this.year) > Integer.parseInt(year.getText())) {
                navigateToNext();
            } else if (Integer.parseInt(this.year) < Integer.parseInt(year.getText())) {
                navigateToPrevious();
            } else {
                notFound = false;
                selectMonth();
            }
        }
    }

    //compare the current month with inputted month
    public void selectMonth() {

        boolean notFound = true;
        while (notFound) {
            WebElement month = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']"));
            int currentMonth = Month.valueOf(month.getText().toUpperCase()).getValue();
            int monthToBeSelected = Month.valueOf(this.month.toUpperCase()).getValue();

            if (monthToBeSelected < currentMonth) {
                navigateToPrevious();
            } else if (monthToBeSelected > currentMonth) {
                navigateToNext();
            } else {
                notFound = false;
                selectDate();
            }
        }
    }

    //compare the current date with inputted date
    public void selectDate() {
        List<WebElement> dates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
        for (WebElement date : dates) {
            String currentDate = date.getText();
            if (currentDate.equals(this.date)) {
                date.click();
                break;
            }
        }
    }

    //navigate to next
    public void navigateToNext() {
        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
        nextBtn.click();
    }

    //navigate to previous
    public void navigateToPrevious() {
        WebElement previousBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
        previousBtn.click();
    }

    public static void main(String[] args) {

        CalendarWithNavigation c = new CalendarWithNavigation();

        try {
            c.openBrowser("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");
            c.fromDate("December", "2", "2023");
            c.toDate("June", "10", "2027");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            c.closeBrowser();
        }

    }

}
