package com.sanosuke.personal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] menuView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        menuView = res.getStringArray(R.array.home_menu);

        ImageView imageView = findViewById(R.id.home_image);
        imageView.setImageResource(R.drawable.icon_music);

        gridView = findViewById(R.id.main_view);
        ArrayList<HomeModel> homeModelArrayList = new ArrayList<>();

        for (String i : menuView) {

            if (i.equals("music")) {
                homeModelArrayList.add(new HomeModel(i, R.drawable.icon_music));
            } else if (i.equals("movies")) {
                homeModelArrayList.add(new HomeModel(i, R.drawable.icon_movies));
            } else {
                homeModelArrayList.add(new HomeModel(i, R.drawable.icon_scan));
            }
        }

        HomeAdapter homeAdapter = new HomeAdapter(this, homeModelArrayList);
        gridView.setAdapter(homeAdapter);
    }
}