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
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;

@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();

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
    }

    @Test
    @DisplayName("ID12. Переход с главной страницы на страницу «Новости» посредством гамбургер-меню " +
            "в левом верхнем углу приложения")
    public void goToNewsPage() {
        mainStep.toNewsPage();
    }

    @Test
    @DisplayName("ID13. Переход с главной страницы на страницу «О приложении» посредством " +
            "гамбургер-меню в левом верхнем углу приложения")
    public void goToAboutPage() {
        mainStep.toAboutPage();
    }

    @Test
    @DisplayName("ID14. Переход с главной страницы на страницу с тематическими цитатами")
    public void goToQuotesPage() {
        mainStep.toQuotesPage();
    }
}
