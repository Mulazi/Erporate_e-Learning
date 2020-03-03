package com.erporate.e_learning.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.erporate.e_learning.R;

import java.util.ArrayList;

public class CourseRecAdapter extends RecyclerView.Adapter<CourseRecAdapter.ViewHolder> {

    private static  final  String TAG = "CourseRecAdapter";

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTittle = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private Context mContext;

    public CourseRecAdapter(Context context, ArrayList<String> mImage, ArrayList<String> mTittle, ArrayList<String> mDesc ) {
        this.mImage = mImage;
        this.mTittle = mTittle;
        this.mDesc = mDesc;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course_rec, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.image_course);
        holder.title_course.setText(mTittle.get(position));
        holder.desc_course.setText(mDesc.get(position));

        holder.course_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click on" + mTittle.get(position));
                Toast.makeText(mContext, mTittle.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_course;
        TextView title_course, desc_course;
        CardView course_rec;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            course_rec = itemView.findViewById(R.id.course_rec);
            image_course = itemView.findViewById(R.id.course_image);
            title_course = itemView.findViewById(R.id.course_title);
            desc_course = itemView.findViewById(R.id.course_desc);
        }
    }
}
