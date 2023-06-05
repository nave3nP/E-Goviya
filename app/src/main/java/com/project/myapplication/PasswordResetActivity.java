package com.project.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.project.myapplication.ui.login.LoginActivity;

public class PasswordResetActivity extends AppCompatActivity {

    EditText editResetMail;
    Button resetBtn;
    TextView loginScrnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        editResetMail = findViewById(R.id.editResetMail);
        resetBtn = findViewById(R.id.resetNowButton);
        loginScrnBtn = findViewById(R.id.loginBtnReset);

        loginScrnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasswordResetActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editResetMail.getText().toString().trim();
                if(email.length()>8){
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(PasswordResetActivity.this, "Email sent.", Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(PasswordResetActivity.this, "Email not sent.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }else {
                    editResetMail.setError("Please enter your valid email!");
                }

            }
        });
    }
}