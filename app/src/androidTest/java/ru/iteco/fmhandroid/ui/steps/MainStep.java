package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.QuotesPage;

public class MainStep {
    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();
    NewsPage newsPage = new NewsPage();
    QuotesPage quotesPage = new QuotesPage();
    DataHelper dataHelper = new DataHelper();

    @Step("Загрузка главной страницы")
    public void loadMainPage() {
        dataHelper.elementWaiting(withId(R.id.all_news_text_view), 5000);
    }

    @Step("Переход с главной страницы на страницу Новости")
    public void toNewsPage() {
        mainPage.burgerButton.perform(click());
        mainPage.burgerNewsPage.perform(click());
        newsPage.allNewsList.check(matches(isDisplayed()));
    }

    @Step("Переход на страницу О приложении")
    public void toAboutPage() {
        mainPage.burgerButton.perform(click());
        mainPage.burgerAboutPage.perform(click());
        aboutPage.aboutVersionTitle.check(matches(isDisplayed()));
    }

    @Step("Переход на страницу с цитатами")
    public void toQuotesPage() {
        mainPage.quotesPageButton.perform(click());
        quotesPage.ourMissionTitle.check(matches(isDisplayed()));
    }
}
