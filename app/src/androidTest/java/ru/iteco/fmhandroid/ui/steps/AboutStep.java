package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.AboutPage;

public class AboutStep {
    AboutPage aboutPage = new AboutPage();

    @Step("Переход по ссылке Политика конфиденциальности")
    public void followTheLinkPrivacyPolicy() {
        aboutPage.privacyPolicyLink.perform(click());
    }

    @Step("Переход по ссылке Пользовательское соглашение")
    public void followTheLinkUserAgreement() {
        aboutPage.termsOfUseLink.perform(click());
    }
}
