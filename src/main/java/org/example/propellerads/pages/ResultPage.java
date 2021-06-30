package org.example.propellerads.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    public ImagePage goToImageSearch() {
        $(".service_name_images").click();
        Selenide.switchTo().window(1);
        return page(ImagePage.class);
    }

    @Step("Проверить отображение поискового запроса: {0}")
    public void checkRequest(String requestValue) {
        $(".input__control").shouldHave(Condition.value(requestValue));
    }

    @Step("Проверить заголовки результатов поиска: {0}")
    public void checkResultsTitle(String title) {
        $$("#search-result .OrganicTitle-LinkText").filter(Condition.text(title)).
                shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @Step("Вернуть количество результатов поиска")
    public String getNumberOfResults() {
        return $(".serp-adv__found").getText();
    }

    @Step("Вернуть количество показов")
    public int getNumberOfShow() {
        String text = $(".serp-adv__displayed").getText().replaceAll("\\W", "");
        return Integer.parseInt(text);
    }

}
