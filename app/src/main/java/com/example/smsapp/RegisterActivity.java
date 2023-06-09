package com.example.smsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, pass;
    Button signup;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.editTextTextPersonName);
        email = (EditText) findViewById(R.id.EmailAddress);
        pass = (EditText) findViewById(R.id.Password);
        signup = (Button) findViewById(R.id.Signup);

        firebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupClick();
            }
        });
    }

    private void signupClick() {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Password = pass.getText().toString();

        if (Name.isEmpty()) {
            Toast.makeText(this, "Lütfen isminizi yazınız.", Toast.LENGTH_SHORT).show();
        }
        if (Email.isEmpty()) {
            Toast.makeText(this, "Lütfen e-mail adresinizi yazınız.", Toast.LENGTH_SHORT).show();
        }
        if (Password.isEmpty()) {
            Toast.makeText(this, "Lütfen şifrenizi yazınız.", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Başarıyla kaydoldunuz.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, SplashScreen.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Kayıt edilemediniz.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void LoginClick(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}
