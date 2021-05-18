package starter.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import static starter.search.ActorPagina.getActorPage;

public class HomeFor {
    public static Performable Home() {
        getActorPage().attemptsTo(Wait.until(
                WebElementQuestion.the(HomeForm.LOGIN_BUTTON) , WebElementStateMatchers.isClickable()
        ).forNoLongerThan(60).seconds());

        return Task.where("Se seleccionó el método de inicio con google",
                Click.on(HomeForm.CANCEL_BUTTON),
                Click.on(HomeForm.LOGIN_BUTTON),
                Click.on(HomeForm.GOOGLE_BUTTON)
        );
    }

}
