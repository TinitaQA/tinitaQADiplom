package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {

    public ViewInteraction burgerNewsPage = onView(withText("Новости"));
    public ViewInteraction burgerButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction burgerAboutPage = onView(withText("О приложении"));
    public ViewInteraction quotesPageButton = onView(withId(R.id.our_mission_image_button));
}

