package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsPage {
    public ViewInteraction allNewsList = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));

    //Панель управления
    public ViewInteraction editNewsText = onView(withText("Панель \n управления"));
    public ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));

    //Создать новость
    public ViewInteraction newsItemCategory = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction newsItemTitle = onView(
            withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction publishDate = onView(
            withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction okButton = onView(withId(android.R.id.button1));
    public ViewInteraction publishTime = onView(
            withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction newsDescription = onView(
            withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
}
