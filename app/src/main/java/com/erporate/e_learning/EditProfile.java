package com.erporate.e_learning;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.erporate.e_learning.Adapter.spinnerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {
    ImageView imgposter;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseFirestore firebaseFirestore;
    DocumentReference mUserRef;
    Button btn_next;
    private Uri filePath;
    ImageButton btn_back;
    EditText etfirstName, etlastName, etSchool, etCity, mDisplayDate;
    Spinner spinner;
    String userID;
    public  String Fname, Lname, Email, Pwd, School, Gender, City, Birth;
    private static final String TAG = "EditProfile";
    private DatePickerDialog.OnDateSetListener mDateListener;
    String[] spinnervalue = {
            "Male",
            "Female"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        imgposter = findViewById(R.id.profile_image);
        etfirstName = findViewById(R.id.enter_fname);
        etlastName = findViewById(R.id.enter_lname);
        etSchool = findViewById(R.id.enter_univ);
        etCity = findViewById(R.id.enter_city);
        spinner = findViewById(R.id.spinner_gender);
        mDisplayDate =  findViewById(R.id.enter_birth);
        btn_back = findViewById(R.id.btn_back);
        btn_next =  findViewById(R.id.btn_next);
        spinnerAdapter adapter = new spinnerAdapter(EditProfile.this, R.layout.item_spinner);
        adapter.addAll(spinnervalue);
        adapter.add("-Choose your Gender-");
        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem() == "-Choose your Gender-") {
                }
                else
                {
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EditProfile.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1 ;
                Log.d(TAG, "onDateSet: date: " + day + "/" + month + "/" + year);
                String date =  day + "/" +month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname = etfirstName.getText().toString();
                final String lasttname = etlastName.getText().toString();
                final String school = etSchool.getText().toString();
                final String city = etCity.getText().toString();


                userID = mAuth.getCurrentUser().getUid();
                DocumentReference documentReference =  firebaseFirestore.collection("user").document(userID);


            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToSetting  = new Intent(EditProfile.this, Setting.class);
                startActivity(backToSetting);
            }
        });
    }

    private void editProfil () {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname = etfirstName.getText().toString();
                final String lasttname = etlastName.getText().toString();
                final String school = etSchool.getText().toString();
                final String city = etCity.getText().toString();
                final String gender = spinner.getSelectedItem().toString();
                final String birth = mDisplayDate.getText().toString();


                Map<String, Object> profile = new HashMap<>();
                profile.put("firstname", firstname);
                profile.put("lastname", lasttname);
                profile.put("school", school);
                profile.put("gender", gender);
                profile.put("city", city);
                profile.put("birth", birth);

                mUserRef.set(profile, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.w(TAG, "Succesfully");
                        Toast.makeText(EditProfile.this, "Profile Uodatte", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}
