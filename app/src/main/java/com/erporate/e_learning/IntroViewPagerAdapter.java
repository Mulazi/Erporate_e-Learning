package com.erporate.e_learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter   {

    Context mContext;
    List<ScreenItem> mListScreen;
    TabLayout tabIndicator;

    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.image_intro);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView desc = layoutScreen.findViewById(R.id.intro_desc);

        title.setText(mListScreen.get(position).getTitle());
        desc.setText(mListScreen.get(position).getDesc());
        imgSlide.setImageResource(mListScreen.get(position).getScreenImage());

        container.addView(layoutScreen);



        return  layoutScreen;
    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }


}
