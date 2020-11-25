package com.example.expensemanager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpass_Activity extends AppCompatActivity {

    EditText email;
    private TextView mForgetPassword;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass_);
        email = findViewById(R.id.etemail);
        mForgetPassword = findViewById(R.id.btnforgetpassword);

        firebaseAuth = FirebaseAuth.getInstance();

        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(email.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(forgetpass_Activity.this, "Password send to your email",Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(forgetpass_Activity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();

                                }
                            }
                        });
            }
        });

    }
}