package com.erporate.e_learning.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.erporate.e_learning.R;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder>{

    private static  final  String TAG = "BlogAdapter";

    private ArrayList<String> mImageBlog = new ArrayList<>();
    private ArrayList<String> mTittleBlog = new ArrayList<>();
    private ArrayList<String> mDescBlog = new ArrayList<>();
    private Context mContext;

    public BlogAdapter( Context mContext, ArrayList<String> mImageBlog, ArrayList<String> mTittleBlog, ArrayList<String> mDescBlog) {
        this.mImageBlog = mImageBlog;
        this.mTittleBlog = mTittleBlog;
        this.mDescBlog = mDescBlog;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_homepage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageBlog.get(position))
                .into(holder.image_blog);
        holder.title_blog.setText(mTittleBlog.get(position));
        holder.desc_blog.setText(mDescBlog.get(position));

        holder.top_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click on" + mTittleBlog.get(position));
                Toast.makeText(mContext, mTittleBlog.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageBlog.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_blog;
        TextView title_blog, desc_blog;
        CardView top_blog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            top_blog = itemView.findViewById(R.id.blog_homepage);
            image_blog = itemView.findViewById(R.id.blog_image_hp);
            title_blog = itemView.findViewById(R.id.blog_title_hp);
            desc_blog = itemView.findViewById(R.id.blog_desc_hp);

        }
    }
}
