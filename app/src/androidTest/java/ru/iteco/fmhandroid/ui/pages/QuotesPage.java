package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public ViewInteraction ourMissionTitle = onView(withId(R.id.our_mission_title_text_view));
}
