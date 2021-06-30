package org.example.propellerads;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.propellerads.pages.ImagePage;
import org.example.propellerads.pages.MainPage;
import org.example.propellerads.pages.ResultPage;
import org.junit.Before;
import org.junit.Test;

public class ImagePageTest {
    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test()
    @Feature("Поиск по изображениям")
    @Description("Поиск изображений по запросу \"propellerads\"")
    public void searchImagesTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.searchValueByEnter("propellerads");
        ImagePage imagePage = new ResultPage().goToImageSearch();
        imagePage.checkImagePreview();
    }
}
