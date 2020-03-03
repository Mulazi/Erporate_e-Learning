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

public class TopCatAdapter extends RecyclerView.Adapter<TopCatAdapter.ViewHolder> {

    private static  final  String TAG = "TopCatAdapter";



    private ArrayList<String> mImageCat = new ArrayList<>();
    private ArrayList<String> mTittleCat = new ArrayList<>();
    private ArrayList<String> mDescCat = new ArrayList<>();
    private Context mContext;


    public TopCatAdapter(Context mContext , ArrayList<String> mImage, ArrayList<String> mTittle, ArrayList<String> mDesc) {
        this.mImageCat = mImage;
        this.mTittleCat = mTittle;
        this.mDescCat = mDesc;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_cat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageCat.get(position))
                .into(holder.image_cat);
        holder.title_cat.setText(mTittleCat.get(position));
        holder.desc_cat.setText(mDescCat.get(position));

        holder.top_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click on" + mTittleCat.get(position));
                Toast.makeText(mContext, mTittleCat.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageCat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_cat;
        TextView title_cat, desc_cat;
        CardView top_cat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            top_cat = itemView.findViewById(R.id.top_cat);
            image_cat = itemView.findViewById(R.id.top_categories_image);
            title_cat = itemView.findViewById(R.id.top_categories_title);
            desc_cat = itemView.findViewById(R.id.top_categories_desc);

        }
    }
}
