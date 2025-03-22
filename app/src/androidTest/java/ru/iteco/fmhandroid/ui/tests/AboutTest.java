package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.registeredLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.validPassword;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();
    AboutStep aboutStep = new AboutStep();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            authStep.loadAuthPage();
        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        authStep.logIn(registeredLogin, validPassword);
        authStep.clickAuthButton();
        mainStep.loadMainPage();
        mainStep.toAboutPage();
    }

    @Test
    @DisplayName("ID44. Переход по ссылке «Политика конфиденциальности» на странице «О приложении»")
    public void checkLinkPrivacyPolicy() {
        aboutStep.followTheLinkPrivacyPolicy();
    }

    @Test
    @DisplayName("ID45. Переход по ссылке «Пользовательское соглашение» на странице «О приложении»")
    public void checkLinkUserAgreement() {
        aboutStep.followTheLinkUserAgreement();
    }
}
