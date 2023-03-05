package com.example.recattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Sign_up extends AppCompatActivity {
    TextView textView;
    EditText roll,email,name,password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textView =findViewById(R.id.loginNow);
        signup=findViewById(R.id.button4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
            }
        });


    }
    private void uploadtofirebase() {
        roll=findViewById(R.id.editText1);
        email=findViewById(R.id.editText2);
        name=findViewById(R.id.editText3);
        password=findViewById(R.id.editText4);

        FirebaseStorage storage= FirebaseStorage.getInstance();
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference("student");
        dataholder obj=new dataholder(email.getText().toString(),name.getText().toString(),password.getText().toString());
        root.child(roll.getText().toString()).setValue(obj);
        roll.setText("");
        email.setText("");
        name.setText("");
        password.setText("");
        Toast.makeText(getApplicationContext(),"Account Generated Please Login",Toast.LENGTH_LONG).show();

    }
}