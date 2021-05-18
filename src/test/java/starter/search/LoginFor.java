package starter.search;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import static starter.search.ActorPagina.getActorPage;

public class LoginFor {
    public static Performable login(String usuario) {
        Actor actor = getActorPage();
        String currentWindowHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();

        String newWindow = getNewWindowHandle(actor, currentWindowHandle);

        return Task.where("Se ingreso el usuario y la contraseña",
                Switch.toWindow(newWindow),
                Enter.theValue(usuario).into(LoginForm.LOGIN_USUARIO),
                Click.on(LoginForm.BOTON_SIGUIENTE)
        );
    }

    private static String getNewWindowHandle(Actor actor, String currentWindowHandle){
        for (String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                return windowHandle;
            }
        }
        return null;
    }
}
