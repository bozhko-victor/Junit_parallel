package guru.qa.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {

    private SelenideElement searchInput = $("#text");
    private SelenideElement searchBtn = $("button[type = 'submit']");

    public YandexResultsPage dosearch(String searchQuery) {
        searchInput.setValue(searchQuery);
        searchBtn.click();
        return new YandexResultsPage();
    }
}
