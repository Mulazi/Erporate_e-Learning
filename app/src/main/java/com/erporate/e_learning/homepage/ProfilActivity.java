package com.erporate.e_learning.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.erporate.e_learning.R;
import com.erporate.e_learning.Setting;
import com.erporate.e_learning.homepage.ProfilActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfilActivity extends Fragment {
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    TextView tv_logout, nameTv, univTv, cityTv;
    ImageView imgProfile, btn_setting, btn_back;

    String userID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profil, container, false);


        btn_back = view.findViewById(R.id.btn_back);
        btn_setting = view.findViewById(R.id.setting_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        userID = firebaseAuth.getCurrentUser().getUid();
        DocumentReference documentReference =  firebaseFirestore.collection("user").document(userID);

        nameTv = view.findViewById(R.id.name_tv);
        univTv = view.findViewById(R.id.school_tv);
        cityTv = view.findViewById(R.id.city_tv);
        imgProfile = view.findViewById(R.id.profileimage_tv);

        setting();


        return view;
    }

    private void setting() {
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToEdit= new Intent(getActivity(), Setting.class);
                startActivity (intToEdit);
            }
        });
    }


    }

