package pages;

import org.openqa.selenium.By;

public class HomePage {

    private BaseFunc baseFunc; // sozdali pustuju peremennuju tipa BaseFunc (dlja konstruktora) NA UROVNE KLASSA

    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    } // konstruktor dlja poluchenija tekushego okna brauzera

    public void openFirstArticle() {
        //Find Element
        baseFunc.getElement(TITLE).click();
        //Click Element

    } // dostupen iz vne, chotbi drugie pages mogli ispoljzovatj
}
