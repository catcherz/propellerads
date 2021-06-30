package org.example.propellerads;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.propellerads.pages.MainPage;
import org.example.propellerads.pages.ResultPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest {
    private String searchData = "propellerads";

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test()
    @Feature("Поиск с главной страницы")
    @Description("Поиск по запросу \"propellerads\"")
    public void searchTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.setValueToSearch(searchData);
        ResultPage resultPage = mainPage.searchButtonClick();
        resultPage.checkRequest(searchData);
        resultPage.checkResultsTitle(searchData);
    }

    @Test()
    @Feature("Поиск с главной страницы")
    @Description("Поиск через выпадающую подсказку по запросу \"propellerads\"")
    public void searchInListTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.setValueToSearch(searchData);
        mainPage.chooseValueFromList("propellerads.com");
        new ResultPage().checkRequest(searchData);

    }

    @Test()
    @Feature("Поиск с главной страницы")
    @Description("Проверка количества найденных результатов")
    public void  checkResultTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.setValueToSearch(searchData);
        ResultPage resultPage = mainPage.searchButtonClick();
        resultPage.checkRequest(searchData);

        Assert.assertEquals("Нашлось 6 тыс. результатов", resultPage.getNumberOfResults());
        Assert.assertTrue("", resultPage.getNumberOfShow()>500);

    }
}