package com.erporate.e_learning.homepage.profil;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.erporate.e_learning.R;

import org.w3c.dom.Text;

public class ProfilFragment extends Fragment {
    TextView tv_logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil_fragment, container, false);

        tv_logout = view.findViewById(R.id.tv_logout);
        tv_logout.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
