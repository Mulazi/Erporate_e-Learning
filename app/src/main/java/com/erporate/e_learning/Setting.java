package com.erporate.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.erporate.e_learning.homepage.SearchActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Setting extends AppCompatActivity {
    Button btn_logout;
    LinearLayout information, change_password, help, feedback, term, privacy;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        btn_logout = findViewById(R.id.btn_logout);
        information = findViewById(R.id.information);
        change_password = findViewById(R.id.cpass);
        help = findViewById(R.id.help);
        feedback = findViewById(R.id.feedback);
        term = findViewById(R.id.term);
        privacy = findViewById(R.id.privacy);

        Logout();
        Info();

    }

    private  void Logout () {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent (Setting.this, Login.class);
                startActivity(intToMain);
            }
        });
    }

    private  void Info () {
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToEdit = new Intent(Setting.this, EditProfile.class);
                startActivity(intToEdit);
            }
        });
    }
}
