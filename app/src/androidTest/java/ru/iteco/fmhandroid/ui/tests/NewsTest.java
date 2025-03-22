package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.description;
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
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();
    NewsStep newsStep = new NewsStep();
    private View decorView;

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

        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @DisplayName("ID34. Создание новости со статусом «Активна» с заполнением всех полей")
    public void addNews() {
        mainStep.toNewsPage();
        newsStep.goToTheControlPanelPage();
        newsStep.clickTheButtonToCreateNews();
        newsStep.fillCategory();
        newsStep.fillTitle();
        newsStep.clickPublicationDate();
        newsStep.clickOkButton();
        newsStep.clickPublicationTime();
        newsStep.clickOkButton();
        newsStep.fillDescription(description);
        newsStep.clickSaveButton();
    }

    @Test
    @DisplayName("ID36. Создание новости без заполнения всех полей")
    public void addNewsWithEmptyFields() {
        mainStep.toNewsPage();
        newsStep.goToTheControlPanelPage();
        newsStep.clickTheButtonToCreateNews();
        newsStep.clickSaveButton();
        newsStep.informationMessage("Заполните пустые поля", decorView);
    }

    @Test
    @DisplayName("ID37. Создание новости с будущей датой")
    public void addNewsWithFutureDate() {
        mainStep.toNewsPage();
        newsStep.goToTheControlPanelPage();
        newsStep.clickTheButtonToCreateNews();
        newsStep.fillCategory();
        newsStep.fillTitle();
        newsStep.fillPublicationDate();
        newsStep.clickPublicationTime();
        newsStep.clickOkButton();
        newsStep.fillDescription(description);
        newsStep.clickSaveButton();
        newsStep.informationMessage("Дата не может быть больше текущей", decorView);
    }
}
