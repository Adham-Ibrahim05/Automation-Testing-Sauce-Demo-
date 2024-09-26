import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver;

    /*Constructor*/
    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public static void Clicking(WebElement element){
        element.click();
    }

    public static void SendText(WebElement element , String text){
        element.sendKeys(text);
    }

    public static String GetText(WebElement element){
       return element.getText();
    }
}
