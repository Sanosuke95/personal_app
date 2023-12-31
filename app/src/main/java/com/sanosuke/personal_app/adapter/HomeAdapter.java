package com.sanosuke.personal_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sanosuke.personal_app.R;
import com.sanosuke.personal_app.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter<HomeModel> {
    View listItemView;
    public HomeAdapter(@NonNull Context context, @NonNull List<HomeModel> homeList) {
        super(context, 0,homeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_card_item, parent, false);
        }

        HomeModel homeModel = getItem(position);
        TextView title = listItemView.findViewById(R.id.home_card_title);
        ImageView image = listItemView.findViewById(R.id.home_card_image);

        if (homeModel != null) {
            title.setText(homeModel.getTitle());
        }
        if (homeModel != null) {
            image.setImageResource(homeModel.getImgId());
        }
        return listItemView;
    }
}
