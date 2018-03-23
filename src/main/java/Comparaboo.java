import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class Comparaboo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.comparaboo.com");

        WebElement element = driver.findElement(By.name("qry"));

        element.sendKeys("laptops");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        element.submit(); click Enter
        WebElement resultSearch = driver.findElement(By.className("search-products-item"));
        resultSearch.click();

        WebElement titleResult = driver.findElement(By.xpath(".//*[@id='maintitle']/span"));
        String textTitle = titleResult.getText();
        System.out.println("We have found: " + textTitle);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement resultStores = driver.findElement(By.xpath(".//*[@id='list-table-responsive']/table/tbody/tr[3]/td[6]/div/div/div[1]/a[2]/span\""));

        //WebElement resultStores = driver.findElement(By.className("more-stores tablet-phone-hide openComprisonBox no_report"));
        resultStores.click();

        driver.quit();
    }
}
