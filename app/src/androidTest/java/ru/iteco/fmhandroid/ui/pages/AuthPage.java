package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class AuthPage {

    //Для входа
    public ViewInteraction textAuthPage = onView(allOf(withText("Авторизация"),
            withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction loginField = onView(allOf(withHint("Логин"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction passwordField = onView(allOf(withHint("Пароль"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction authButton = onView(allOf(withId(R.id.enter_button),
            withText("Войти"), withContentDescription("Сохранить")));


    //Для выхода
    public ViewInteraction logOutButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction textLogOutButton = onView(withText("Выйти"));
}
