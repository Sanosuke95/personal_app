package com.sanosuke.personal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.sanosuke.personal_app.adapter.HomeAdapter;
import com.sanosuke.personal_app.model.HomeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] menuView;
    static final String LOG_GRIDVIEW = "LOG_GRIDVIEW";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        menuView = res.getStringArray(R.array.home_menu);

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                String item = ((TextView)view.findViewById(R.id.home_card_title)).getText().toString();
                switch (item) {
                    case "music":
                        changeActivity(MusicActivity.class);
                        break;
                    case "movies":
                        changeActivity(MoviesActivity.class);
                        break;
                    case "scan":
                        changeActivity(ScanActivity.class);
                        break;
                    default:Log.i(LOG_GRIDVIEW, "NOt element selected in gridView");
                }
                Log.i(LOG_GRIDVIEW, "The first element :" + item);
            }
        });
    }

    public void changeActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivities(new Intent[]{intent});
    }
}