import pages.BaseFunc;
import org.junit.jupiter.api.Test;

public class PageObjectTest {

    private BaseFunc baseFunc = new BaseFunc(); //neljzja naprjamuju obratitjsja k BaseFunc (ne original, a kopija)

    @Test
    public void poTest() {
        baseFunc.goToUrl("http://rus.delfi.lv");
    }
}
