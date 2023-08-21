import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class pruebas {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        // identify element
        WebElement p=driver.findElement(By.name("q"));
        //enter text with sendKeys() then apply submit()
        p.sendKeys("Selenium Java");
        // Explicit wait condition for search results
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();

        //driver.findElement(By.xpath("//*[@id='result-stats']"));
        int size = driver.findElements(By.cssSelector("#result-stats")).size();

        if(size!= 0){
            System.out.println("La cantidad de resultados y tiempo de busqueda son "+driver.findElement(By.id("result-stats")).getText());
        }
        driver.close();
    }
}