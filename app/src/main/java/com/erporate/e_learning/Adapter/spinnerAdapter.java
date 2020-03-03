package com.erporate.e_learning.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class spinnerAdapter extends ArrayAdapter<String> {
    public spinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    @Override
    public int getCount(){
        int count = super.getCount();

        return count>0 ? count-1 : count;
    }
}
