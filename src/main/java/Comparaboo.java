import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.List;
//import org.testng.Assert;

public class Comparaboo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.comparaboo.com");

        WebElement element = driver.findElement(By.name("qry"));

        element.sendKeys("laptops");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //  element.submit(); click Enter
        WebElement resultSearch = driver.findElement(By.className("search-products-item")); //ищем результат поиска
        resultSearch.click(); //выбираем первый результат

        WebElement titleResult = driver.findElement(By.xpath(".//*[@id='maintitle']/span")); //находим титл на странице
        String textTitle = titleResult.getText();
        System.out.println("We have found: " + textTitle); //output the result title

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", ""); //scroll down

        //WebElement number_stores = driver.findElement(By.xpath("//a[@class='more-stores tablet-phone-hide openComprisonBox no_report']"));
        WebElement number_stores = driver.findElement(By.cssSelector("a.more-stores.tablet-phone-hide.openComprisonBox.no_report"));
        String numberstores = number_stores.getText();
        String numberOfStores = numberstores.replaceAll("^\\D*(\\d+).*", "$1");
        System.out.println(numberOfStores); //find number Of Stores

        WebElement findId = driver.findElement(By.cssSelector("ul.compare-list"));
        String resultID = findId.getAttribute("data-product-id");
        System.out.println(resultID); //get value of data-product-id

        //@Test
        List<WebElement> lst = driver.findElements(By.xpath("//*[contains(@data-click-product, '" + resultID + "') ]"));
        int size = (lst.size())-1; //get count of all ID with resultID
        System.out.println(size);
        //Assert.assertEquals(numberOfStores, size);

        WebElement stores = driver.findElement(By.cssSelector("a.more-stores.tablet-phone-hide.openComprisonBox.no_report"));
        stores.click();

        // or Xpath:// driver.findElement(By.xpath("//a[@class='more-stores tablet-phone-hide openComprisonBox no_report']")).click();

        driver.quit();
    }
}
