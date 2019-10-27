import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork2 {

    //Locators
    private final By WOMAN_TITLE = By.xpath(".//a[@class = 'sf-with-ul']");
    private final By MAIN_TITLE = By.xpath(".//a[@class = 'subcategory-name']");
    private final By LEFT_TITLE = By.xpath(".//ul[@class = 'tree dynamized']");

    @Test
    public void CheckSubCategoryTitle() {

        System.setProperty("webdriver.chrome.driver", "/Users/alenamihina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

        //get women title and click it
        driver.findElement(WOMAN_TITLE).click();

        //get main menu subcategory1
        String menuFirstSubcategory = driver.findElements(MAIN_TITLE).get(0).getText();

        //get main menu subcategory2
        String menuSecondSubcategory = driver.findElements(MAIN_TITLE).get(1).getText();

        //get left menu subcategory1
        String leftMenuFirstSubcategory = driver.findElement(LEFT_TITLE).getText();

        //get left menu subcategory2
        String leftMenuSecondSubcategory = driver.findElements(LEFT_TITLE).get(1).getText();

        //compare main menu subcategory1 with left menu subcategory1
        Assertions.assertEquals(menuFirstSubcategory, leftMenuFirstSubcategory, "Main menu subcategory name is not the same as left menu subcategory");

        //compare main menu subcategory2 with left menu subcategory2
        Assertions.assertEquals(menuSecondSubcategory, leftMenuSecondSubcategory, "Main menu subcategory is not the same as left menu subcategory");

        //close browser
        driver.close();

    }
}
