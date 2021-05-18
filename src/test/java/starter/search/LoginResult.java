package starter.search;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.Collection;

public class LoginResult {
    public static Question<Collection<String>> nombre() {
        return actor -> TextContent.of(LoginResultText.RESULT_NAME).viewedBy(actor).asList();
    }
}
