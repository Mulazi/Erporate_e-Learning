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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText Firstname, Lastname, Email, Password, Repassword;
    TextView tvLogIn;
    Button btnRegister;
    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    String userID;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Email     = findViewById(R.id.txt_email);
        tvLogIn   = findViewById(R.id.txt_login_account);
        Password  = findViewById(R.id.txt_password);
        Repassword = findViewById(R.id.txt_re_password);
        btnRegister = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if (mAuth.getCurrentUser()!= null) {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email    = Email.getText().toString();
                final String password = Password.getText().toString();
                final String repassword = Repassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Email.setError("Please Enter Email");
                    Email.requestFocus();
                    return;
                }
                if (!email.matches(emailPattern)) {
                    Email.setError("Invalid Email Format");
                    Email.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Password.setError("Please Enter Password");
                    Password.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    Password.setError("Password must be at least 6 character");
                    Password.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(repassword)) {
                    Repassword.setError("Please Enter re-Password");
                    Repassword.requestFocus();
                    return;
                }
                else if (!password.equals(repassword)) {
                    Repassword.setError("Password does not match");
                    Repassword.requestFocus();
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