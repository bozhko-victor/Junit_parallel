package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.page.YandexMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@Execution(value = ExecutionMode.SAME_THREAD)
public class ParallelTest {

    private YandexMainPage ymp = new YandexMainPage();

    @ValueSource(strings = {
            "QA GURU",
            "selenide",
            "qameta",
            "allure"
    })
//    @ResourceLock("1")
    @ParameterizedTest(name = "{0} test")
    void yandexSearchTest(String searchQuery, TestInfo testInfo) {
        Configuration.startMaximized = true;
        Selenide.open(YandexMainPage.URL);
        ymp.dosearch(searchQuery)
                        .checkResults(searchQuery);

        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized
        );

    }

//    @ResourceLock("1")
    @DisplayName("JDK test")
    @Test
    void minimazedWindowTest(TestInfo testInfo) {
        Configuration.startMaximized = false;
        Selenide.open(YandexMainPage.URL);
        new YandexMainPage().dosearch("JDK")
                .checkResults("JDK");

        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized
        );
    }

}
