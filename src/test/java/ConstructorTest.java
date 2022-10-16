import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.objects.ConstructorObject;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void goToSauce() {
        ConstructorObject constructorObject = new ConstructorObject(driver);
        PageFactory.initElements(driver, constructorObject);

        constructorObject
                .clickButton(constructorObject.getSauceButton());

        assertTrue(constructorObject.isSauceVisible());
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void goToFilling() {
        ConstructorObject constructorObject = new ConstructorObject(driver);
        PageFactory.initElements(driver, constructorObject);

        constructorObject
                .clickButton(constructorObject.getFillingButton());

        assertTrue(constructorObject.isFillingVisible());
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void goToBun() {
        ConstructorObject constructorObject = new ConstructorObject(driver);
        PageFactory.initElements(driver, constructorObject);

        constructorObject
                .clickButton(constructorObject.getSauceButton())
                .clickButton(constructorObject.getBunButton());

        assertTrue(constructorObject.isBunVisible());
    }
}
