import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void ClickOnBurgerMenu(){
        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        Clicking(BurgerMenu);
    }

    public void ClickOnLogout(){
        WebElement Logout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        Clicking(Logout);
    }

    public void AddFirstProductToCart(){
        WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        Clicking(AddToCartButton);
    }

    public void AddSecondProductToCart(){
        WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
        Clicking(AddToCartButton);
    }

    public CartPage ClickOnCartBadge(){
        WebElement CartBadge = driver.findElement(By.xpath("//*[@fill=\"currentColor\"]"));
        Clicking(CartBadge);
        return new CartPage(driver);
    }

    public String GetHomeTitle(){
        WebElement ProductLabel = driver.findElement(By.className("product_label"));
        return GetText(ProductLabel);
    }

    public String GetTotalItem(){
        WebElement TotalItem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        return GetText(TotalItem);
    }
}
