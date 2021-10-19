package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParallelTest {

    @ValueSource(strings = {
            "QA GURU",
            "selenide",
            "qameta",
            "allure"
    })
    @ParameterizedTest
    void yandexSearchTest(String searchQuery) {
        Selenide.open("https://ya.ru/");
        Selenide.$("#text").setValue(searchQuery);
        Selenide.$("button[type = 'submit']").click();
        Selenide.$$(".serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(Condition.text(searchQuery));
    }

}
