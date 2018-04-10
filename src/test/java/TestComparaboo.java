import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestComparaboo {
        protected WebDriver driver;
        @BeforeClass
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:\\Temp\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-cache");
            driver = new ChromeDriver(options);
            //driver.manage().window().maximize(); перенес в настройки
        }
        @AfterClass
        public void tearDown() throws InterruptedException {
            System.out.println("After class: Tests completed.");
            //You can clean up after tests.
            driver.close();
        }

}
