package org.example.propellerads.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage() {
        open("https://yandex.ru/");
    }

    @Step("Проверить логотип Яндекс")
    public void checkLogo() {
        $("[aria-label='Яндекс']").shouldBe(Condition.visible);
    }

    @Step("Нажать на кнопку \"Найти\"")
    public ResultPage searchButtonClick() {
        $(".button_theme_search").click();
        return page(ResultPage.class);
    }

    @Step("Ввод значения для поиска: {0}")
    public void setValueToSearch(String valueToSearch) {
        searchInput().setValue(valueToSearch);
    }

    @Step("Ввод значения {0} и поиск по enter")
    public void searchValueByEnter(String valueToSearch) {
        searchInput().setValue(valueToSearch).pressEnter();
    }

    @Step("Выбрать значение {0} из выпадающего списка")
    public void chooseValueFromList(String valueToSearch) {
        $$("[role='listbox'] [role='option']").findBy(Condition.text(valueToSearch)).click();
    }

    public SelenideElement searchInput() {
        return $("#text");
    }

}