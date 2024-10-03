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

    //open the browser
    public void openBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    //set date
    public void setDate(String dateType, String month, String date, String year) {

        if(dateType.equals("from")){
            WebElement fromDateInputBox = driver.findElement(By.xpath("//input[@id='from_date']"));
            fromDateInputBox.click();
        }
        else if(dateType.equals("to")){
            WebElement toDateInputBox = driver.findElement(By.xpath("//input[@id='to_date']"));
            toDateInputBox.click();
        }else{
            System.out.println("Invalid date type");
        }

        selectYear(year);
        selectMonth(month);
        selectDate(date);
    }

    // Navigate to the specified year
    public void selectYear(String targetYear) {

        boolean notFound = true;

        while (notFound) {
            WebElement currentYear = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']"));

            if (Integer.parseInt(targetYear) > Integer.parseInt(currentYear.getText())) {
                navigateToNext();
            } else if (Integer.parseInt(targetYear) < Integer.parseInt(currentYear.getText())) {
                navigateToPrevious();
            } else {
                notFound=false;
                break;
            }
        }
    }

    // Navigate to the specified month
    public void selectMonth(String targetMonth) {

        boolean notFound = true;
        while (notFound) {
            WebElement month = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']"));
            int currentMonthValue = Month.valueOf(month.getText().toUpperCase()).getValue();
            int targetMonthValue = Month.valueOf(targetMonth.toUpperCase()).getValue();

            if (targetMonthValue < currentMonthValue) {
                navigateToPrevious();
            } else if (targetMonthValue > currentMonthValue) {
                navigateToNext();
            } else {
                notFound=false;
                break;
            }
        }
    }

    // Select the specified date
    public void selectDate(String targetDate) {
        List<WebElement> dates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
        for (WebElement date : dates) {
            String currentDate = date.getText();
            if (currentDate.equals(targetDate)) {
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
            c.setDate("from","December", "2", "2023");
            c.setDate("to","December", "2", "2023");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            c.closeBrowser();
        }

    }

}
