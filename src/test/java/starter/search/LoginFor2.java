package starter.search;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static starter.search.ActorPagina.getActorPage;

public class LoginFor2 {
    public static Performable login2(String contraseña) {
        return Task.where("Se ingreso el usuario y la contraseña",
                Enter.theValue(contraseña).into(LoginForm2.LOGIN_CONTRASEÑA),
                Click.on(LoginForm2.CONTRASEÑA_SIGUIENTE)
        );
    }

}
