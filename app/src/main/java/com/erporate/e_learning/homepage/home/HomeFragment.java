package com.erporate.e_learning.homepage.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.erporate.e_learning.Home;
import com.erporate.e_learning.Login;
import com.erporate.e_learning.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnLogout = view.findViewById(R.id.btn_logouta);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent (getActivity(), Login.class);
                startActivity(intToMain);
            }
        });

        return view;
    }

}