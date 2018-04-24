import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CB_Test extends TestComparaboo {

        @Test
        public void test1() throws InterruptedException {
            WebElement MainTitle = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/h1")); //находим титл на странице
            //WebElement MainTitle = driver.findElement(By.xpath("html/head/title")); //находим титл на странице ???
            String textMainTitle = MainTitle.getText();
            System.out.println("Test#1 We have found: " + textMainTitle); //output the result title
            //Assert.assertTrue(textMainTitle.contains("Search Once."));
            Assert.assertEquals("Search Once. Find The Best Reviewed Stuff", textMainTitle);
        }

        @Test
        public void test2() throws InterruptedException {
            WebElement element = driver.findElement(By.name("qry"));

            element.sendKeys("laptops");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //  element.submit(); click Enter
            WebElement resultSearch = driver.findElement(By.className("search-products-item")); //ищем результат поиска
            resultSearch.click(); //выбираем первый результат

            WebElement titleResult = driver.findElement(By.xpath(".//*[@id='maintitle']/span")); //находим титл на странице
            String textTitle = titleResult.getText();
            Assert.assertTrue(textTitle.contains("Laptops"));
            System.out.println("Test#2 We have found: " + textTitle); //output the result title
        }

        @Test
        public void test3() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", ""); //scroll down


            WebElement number_stores = driver.findElement(By.cssSelector("a.more-stores.tablet-phone-hide.openComprisonBox.no_report"));
            String numberstores = number_stores.getText();
            String numberOfStores = numberstores.replaceAll("^\\D*(\\d+).*", "$1");
            int IntNumberOfStores = Integer.parseInt(numberOfStores);

            WebElement stores = driver.findElement(By.cssSelector("a.more-stores.tablet-phone-hide.openComprisonBox.no_report"));
            stores.click();
            Thread.sleep(1000);

            WebElement findId = driver.findElement(By.cssSelector("#globalPriceBox .compare-list"));
            //WebElement findId = driver.findElement(By.xpath(""));
            String resultID = findId.getAttribute("data-product-id"); //get value of data-product-id
            //System.out.println(resultText);

            List<WebElement> lst = driver.findElements(By.xpath("//*[contains(@data-click-product, '" + resultID + "') ]"));
            //List<WebElement> lst = driver.findElements(By.xpath("//*[contains(@data-click-product, '" + resultID + "') and contains(@class, 'clickout clickout j-product-view compare-list-shop product-offer-js')]"));
            //System.out.println(lst.size()); //temp
            int size = (((lst.size()) - 1)/2); //get count of all ID with resultID
            System.out.println("Test#3 We have found: " + size + " of the " +  IntNumberOfStores + " stores"); //output the result title
            Assert.assertEquals(IntNumberOfStores, size);
        }
}



