package com.official19.ajb.abinitio.co_ordinatorlogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.official19.ajb.abinitio.R;

public class changepasswordActivity extends AppCompatActivity  {

    EditText changePasswordEdit;
    Button changePassword;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_screen);

            setUIView();

            firebaseAuth = FirebaseAuth.getInstance();
            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

            changePassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String newpassword = changePasswordEdit.getText().toString();
                    firebaseUser.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Password Successfully changed", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(getApplicationContext(), "Password is not CHanged", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
        }




        private void setUIView()
        {
           changePassword = (Button)findViewById(R.id.btnchangePassword);
           changePasswordEdit = (EditText)findViewById(R.id.etchangePassword);
        }

}
