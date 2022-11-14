package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @Test
    void shouldFindSelenideRepositoryPage(){
        //открыть страницу github.com
        open("https://github.com");
        //ввести в поле поиска Selenide
        //нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на линк от первого результата поиска
        $$(".repo-list li").first().$("a").click();
        //check: в заголовке встречается selenide/selenide
        $("a").should(text("selenide"));





    }
}