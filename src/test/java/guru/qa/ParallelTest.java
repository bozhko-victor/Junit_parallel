package guru.qa;

import com.codeborne.selenide.Selenide;
import guru.qa.page.YandexMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParallelTest {

    @ValueSource(strings = {
            "QA GURU",
            "selenide",
            "qameta",
            "allure"
    })
    @ParameterizedTest(name = "{0} test")
    void yandexSearchTest(String searchQuery) {
        Selenide.open("https://ya.ru/");
        new YandexMainPage().dosearch(searchQuery)
                        .checkResults(searchQuery);



    }

    @DisplayName("JDK test")
    @Test
    void minimazedWindowTest() {
        Selenide.open("https://ya.ru/");
        new YandexMainPage().dosearch("JDK")
                .checkResults("JDK");
    }

}
