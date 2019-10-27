import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiArticleTest {

    //Locators always on top (before Test)!! These can be changed
    //Only in this class used - private. Const - "final" (never changed)
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");
    // /a in the end means going to the next element from the one found by xpath (goes to "a" element)
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']");
    private final By COMMENT_PAGE_COMMENTS = By.xpath(".//span[@class = 'type-cnt']");

    @Test
    public void titleAndCommentsTest() {


        //Open Browser
        System.setProperty("webdriver.chrome.driver", "/Users/alenamihina/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Home page - delfi
        driver.get("http://rus.delfi.lv");

        //Find 1st article
        WebElement article = driver.findElements(ARTICLE).get(0);

        //Find first article title
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE); //changed driver to article

        //Save to String
        String titleToCompare = homePageTitle.getText();

        //Find comments count
        Integer commentsToCompare = 0;

        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty()) {

            WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS); //changed driver to article

            //Save to Integer
            String commentsToParse = homePageComments.getText(); //(1)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
            commentsToCompare = Integer.valueOf(commentsToParse);
        }
        //******************* when we have no comments? ********************

        //Open Article page
        homePageTitle.click();

        //Find title
        String apTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleToCompare, apTitle, "Wrong title on Article Page!");

        //Find comment count
        Integer apComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1, driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length() - 1));

        //check comment count
        Assertions.assertEquals(commentsToCompare, apComments, "Comments count is not the same as in Home Page!");

        //Open Comments page
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        //Find title (comment page title)
        String cpTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleToCompare, cpTitle, "Title on comment page is not the same as in Home Page!");

        //Get comment count
        if (!article.findElements(COMMENT_PAGE_COMMENTS).isEmpty()) {

            Integer cpComments = 0;

            for (Integer i = 1; i < 2; i++) {
                WebElement commentsPageComments = article.findElements(COMMENT_PAGE_COMMENTS).get(i);
                String commentsToParse = commentsPageComments.getText();
                commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
                cpComments = cpComments + Integer.valueOf(commentsToParse);
            }


            //Check comment count
            Assertions.assertEquals(commentsToCompare, cpComments, "Incorrect comment count on comments page!");
        }
        //Close browser
        driver.close();

    }
}
