package com.erporate.e_learning.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.erporate.e_learning.Adapter.BlogAdapter;
import com.erporate.e_learning.Adapter.CourseRecAdapter;
import com.erporate.e_learning.Adapter.TopCatAdapter;
import com.erporate.e_learning.Login;
import com.erporate.e_learning.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends Fragment {
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;
    private static  final  String TAG = "HomeActivity";

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTittle = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private ArrayList<String> mImageCat = new ArrayList<>();
    private ArrayList<String> mTittleCat = new ArrayList<>();
    private ArrayList<String> mDescCat = new ArrayList<>();
    private ArrayList<String> mImageBlog = new ArrayList<>();
    private ArrayList<String> mTittleBlog = new ArrayList<>();
    private ArrayList<String> mDescBlog = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.course_rec_recyclerview);
        RecyclerView.LayoutManager CourseRec = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(CourseRec);
        CourseRecAdapter adapter = new CourseRecAdapter(getActivity(), mImage, mTittle, mDesc);
        recyclerView.setAdapter(adapter);


        RecyclerView recyclerView1 = view.findViewById(R.id.top_cat_recyclerview);
        RecyclerView.LayoutManager TopCategories = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(TopCategories);
        TopCatAdapter adapter1 = new TopCatAdapter(getActivity(), mImageCat, mTittleCat, mDescCat);
        recyclerView1.setAdapter(adapter1);

        RecyclerView recyclerView2 = view.findViewById(R.id.blog_recyclerview);
        RecyclerView.LayoutManager BlogHomepage = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(BlogHomepage);
        BlogAdapter adapter2 = new BlogAdapter(getActivity(), mImageBlog, mTittleBlog, mDescBlog);
        recyclerView2.setAdapter(adapter2);


        getCourseRec();
        getTopCategories();
        BlogHomepage();

        return view;
    }

    private void getCourseRec(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImage.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffavpng.com%2Fpng_view%2Fcircle-with-line-through-it-internet-icon-internet-access-web-browser-png%2FuRC55eSE&psig=AOvVaw0nFGYNqnMx7oBbMF3lXIu2&ust=1582611652215000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiBi_7F6ecCFQAAAAAdAAAAABAD");
        mTittle.add("Web Programming Lv 1");
        mDesc.add("Learn the technical for building a new website");

        mImage.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffavpng.com%2Fpng_view%2Fcircle-with-line-through-it-internet-icon-internet-access-web-browser-png%2FuRC55eSE&psig=AOvVaw0nFGYNqnMx7oBbMF3lXIu2&ust=1582611652215000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiBi_7F6ecCFQAAAAAdAAAAABAD");
        mTittle.add("Web Programming Lv 2");
        mDesc.add("Learn the technical for building a new website");

        mImage.add("Learn the technical for building android apps");
        mTittle.add("Basic Android Programming lv 1");
        mDesc.add("Learn the technical for building android apps");


    }

    private void getTopCategories() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageCat.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffavpng.com%2Fpng_view%2Fcircle-with-line-through-it-internet-icon-internet-access-web-browser-png%2FuRC55eSE&psig=AOvVaw0nFGYNqnMx7oBbMF3lXIu2&ust=1582611652215000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiBi_7F6ecCFQAAAAAdAAAAABAD");
        mTittleCat.add("HMTL");
        mDescCat.add("223   ");
    }


    private void BlogHomepage() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageBlog.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffavpng.com%2Fpng_view%2Fcircle-with-line-through-it-internet-icon-internet-access-web-browser-png%2FuRC55eSE&psig=AOvVaw0nFGYNqnMx7oBbMF3lXIu2&ust=1582611652215000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiBi_7F6ecCFQAAAAAdAAAAABAD");
        mTittleBlog.add("Coffee for Programming");
        mDescBlog.add("Make cafein to become a great program");
    }


}
