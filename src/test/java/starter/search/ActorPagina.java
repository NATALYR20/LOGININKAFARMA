package starter.search;
import net.serenitybdd.screenplay.Actor;

public class ActorPagina {
    private static  Actor actorPage;

    public static Actor getActorPage() {
        return actorPage;
    }

    public static void setActorPage(Actor actorName) {
        actorPage = actorName;
    }
}
