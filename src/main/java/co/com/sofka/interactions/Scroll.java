package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Scroll implements Interaction {

    private final Target target;
    private Scroll(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement webElement = target.resolveFor(actor).getElement();
        BrowseTheWeb.as(actor).evaluateJavascript("arguments[0].scrollIntoView();", webElement);

    }

    public static Scroll scrollTo(Target target){
        return new Scroll(target);
    }
}
