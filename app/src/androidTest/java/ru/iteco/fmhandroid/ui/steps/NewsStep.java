package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class NewsStep {
    NewsPage newsPage = new NewsPage();

    @Step("Перейти на страницу Панель управления")
    public void goToTheControlPanelPage() {
        newsPage.editNewsButton.perform(click());
        newsPage.editNewsText.check(matches(isDisplayed()));
    }

    @Step("Нажать кнопку создать новость")
    public void clickTheButtonToCreateNews() {
        newsPage.addNewsButton.perform(click());
    }

    @Step("Заполнить поле категория")
    public void fillCategory() {
        newsPage.newsItemCategory.perform(replaceText(DataHelper.randomCategory()));
    }

    @Step("Заполнить поле заголовок")
    public void fillTitle() {
        newsPage.newsItemTitle.perform(replaceText(DataHelper.titleName));
    }

    @Step("Нажать на поле дата публикации")
    public void clickPublicationDate() {
        newsPage.publishDate.perform(click());
    }

    @Step("Нажать на поле время публикации")
    public void clickPublicationTime() {
        newsPage.publishTime.perform(click());
    }

    @Step("Нажать кнопку ОК")
    public void clickOkButton() {
        newsPage.okButton.perform(click());
    }

    @Step("Заполнить поле дата")
    public void fillPublicationDate() {
        newsPage.publishDate.perform(replaceText(DataHelper.generateDate(1)));
    }

    @Step("Заполнить поле с описанием")
    public void fillDescription(String text) {
        newsPage.newsDescription.perform(replaceText(text));
    }

    @Step("Нажать кнопку сохранить")
    public void clickSaveButton() {
        newsPage.saveButton.perform(click());
    }

    @Step("Информационное сообщение")
    public void informationMessage(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
}
