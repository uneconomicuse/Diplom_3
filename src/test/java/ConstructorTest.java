import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.objects.AssertsObject;
import org.example.objects.ConstructorObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    private AssertsObject assertsObject;
    private ConstructorObject constructorObject;

    @Before
    public void service() {
        constructorObject = new ConstructorObject(driver);
        assertsObject = new AssertsObject(driver);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void goToSauce() {
        constructorObject
                .clickButton(constructorObject.getSauceButton());

        boolean result = assertsObject.isDisplayed(constructorObject.getSauceTab());

        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void goToFilling() {
        constructorObject
                .clickButton(constructorObject.getFillingButton());

        boolean result = assertsObject.isDisplayed(constructorObject.getFillingTab());

        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void goToBun() {
        constructorObject
                .clickButton(constructorObject.getSauceButton())
                .clickButton(constructorObject.getBunButton());

        boolean result = assertsObject.isDisplayed(constructorObject.getBunsTab());

        assertTrue(result);
    }
}
