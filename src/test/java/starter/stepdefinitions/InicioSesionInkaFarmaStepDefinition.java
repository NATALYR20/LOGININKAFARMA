package starter.stepdefinitions;

import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.navigation.NavigateTo;
import starter.search.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class InicioSesionInkaFarmaStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) Entra a la página de inkafarma")
    public void entramos_a_la_página_de_inkafarma(String actor) {
        ActorPagina.setActorPage(theActorCalled(actor));

        theActorCalled(actor).attemptsTo(NavigateTo.theInkafarmaGoHomePage());


    }

    @When("selecciona el inicio de sesión con Google")
    public void seleccionamos_el_inicio_de_sesión_con_Google()  {
        withCurrentActor(
                HomeFor.Home()
        );
    }

    @When("ingresamos con el correo {string} y presionamos el botón siguiente")
    public void ingresamos_con_el_correo(String string) {
        withCurrentActor(
                LoginFor.login(string)
        );
    }


    @When("ingresamos la contraseña {string} y presionamos el botón siguiente")
    public void ingresamos_la_contraseña(String string) {
        withCurrentActor(
                LoginFor2.login2(string)
        );
    }

    @Then("podemos acceder al aplicativo y se muestra nuestro nombre {string}")
    public void podemos_acceder_al_aplicativo(String string) {
        withCurrentActor(
                Ensure.thatTheAnswersTo(LoginResult.nombre())
                        .allMatch("a title containing '" + string + "'",
                                title -> title.toLowerCase().contains(string.toLowerCase()))

        );
    }



}
