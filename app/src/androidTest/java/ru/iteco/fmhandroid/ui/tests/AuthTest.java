package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.data.DataHelper.notRegisteredLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.notValidPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.registeredLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.validPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {
    AuthPage authPage = new AuthPage();
    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;


    @Before
    public void setUp() {
        try {
            authStep.loadAuthPage();

        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @DisplayName("ID1. Ввод данных зарегистрированного пользователя в поля «Логин» и «Пароль»")
    public void authRegisteredUser() {
        authStep.logIn(registeredLogin, validPassword);
        authStep.clickAuthButton();
        mainStep.loadMainPage();
    }

    @Test
    @DisplayName("ID2. Ввод данных незарегистрированного пользователя в поля «Логин» и «Пароль»")
    public void authNotRegisteredUser() {
        authStep.logInNotRegistered(notRegisteredLogin, notValidPassword);
        authStep.clickAuthButton();
        authStep.informationMessage("Неверный логин и/или пароль", decorView);
        authPage.textAuthPage.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("ID3. Оставить поля «Логин» и «Пароль» пустыми")
    public void authWithEmptyFields() {
        authStep.clickAuthButton();
        authStep.informationMessage("Логин и пароль не могут быть пустыми", decorView);
        authPage.textAuthPage.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("ID46. Выход из личного кабинета пользователя")
    public void logoutFromPersonalAccount() {
        authStep.logIn(registeredLogin, validPassword);
        authStep.clickAuthButton();
        mainStep.loadMainPage();
        authStep.logOut();
        authStep.loadAuthPage();
    }
}
