package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AuthPage;

public class AuthStep {
    AuthPage authPage = new AuthPage();
    DataHelper dataHelper = new DataHelper();

    @Step("Загрузка страницы авторизации")
    public void loadAuthPage() {
        dataHelper.elementWaiting(withId(R.id.enter_button), 5000);
    }

    @Step("Ввод данных зарегистрированного пользователя")
    public void logIn(String login, String password) {
        authPage.textAuthPage.check(matches(isDisplayed()));
        authPage.loginField.perform(replaceText(login));
        authPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Ввод данных незарегистрированного пользователя")
    public void logInNotRegistered(String login, String password) {
        authPage.textAuthPage.check(matches(isDisplayed()));
        authPage.loginField.perform(replaceText(login));
        authPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Информационное сообщение")
    public void informationMessage(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Step("Нажать кнопку Войти")
    public void clickAuthButton() {
        authPage.authButton.perform(click());
    }

    @Step("Выход из учетной записи")
    public void logOut() {
        authPage.logOutButton.perform(click());
        authPage.textLogOutButton.perform(click());
    }
}
