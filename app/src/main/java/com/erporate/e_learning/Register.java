package com.erporate.e_learning;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.erporate.e_learning.homepage.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText input_Email, input_Password, input_Repassword;
    TextView tvLogIn;
    Button btnRegister;
    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    String userID;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String Fname, Lname, Email, School, Gender, City, Birth;
    public static String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        input_Email     = findViewById(R.id.txt_email);
        tvLogIn   = findViewById(R.id.txt_login_account);
        input_Password  = findViewById(R.id.txt_password);
        input_Repassword = findViewById(R.id.txt_re_password);
        btnRegister = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if (mAuth.getCurrentUser()!= null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email    = input_Email.getText().toString();
                final String password = input_Password.getText().toString();
                final String repassword = input_Repassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    input_Email.setError("Please Enter Email");
                    input_Email.requestFocus();
                    return;
                }
                if (!email.matches(emailPattern)) {
                    input_Email.setError("Invalid Email Format");
                    input_Email.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    input_Password.setError("Please Enter Password");
                    input_Password.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    input_Repassword.setError("Password must be at least 6 character");
                    input_Repassword.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(repassword)) {
                    input_Repassword.setError("Please Enter re-Password");
                    input_Repassword.requestFocus();
                    return;
                }
                else if (!password.equals(repassword)) {
                    input_Repassword.setError("Password does not match");
                    input_Repassword.requestFocus();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference =  firebaseFirestore.collection("user").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("firstname", null);
                            user.put("lastname", null);
                            user.put("school", null);
                            user.put("gender", null);
                            user.put("city", null);
                            user.put("birth", null);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        tvLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignIn = new Intent(Register.this, Login.class);
                startActivity(intSignIn);
            }
        });


    }

}