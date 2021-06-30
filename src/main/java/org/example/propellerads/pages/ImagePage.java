package org.example.propellerads.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class ImagePage {

    @Step("Проверка отбражения картинок")
    public void checkImagePreview() {
        $$(".serp-item__preview").shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
    }
}
