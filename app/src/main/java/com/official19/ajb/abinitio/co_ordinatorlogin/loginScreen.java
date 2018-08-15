package com.official19.ajb.abinitio.co_ordinatorlogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.event;

public class loginScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private EditText Email,Password;
    private ImageView Logo;
    private TextView SignUp,Login;
    private CardView Card;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setUIView();
        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user =firebaseAuth.getCurrentUser();
        if (user!=null)
        {
            finish();

            startActivity(new Intent(loginScreen.this,Co_OrdinatorProfileActivity.class));
        }

        /*SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginScreen.this,RegistrationActivity.class));
            }
        });*/

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(),Password.getText().toString());

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        MainActivity.navigation(this ,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUIView()
    {
        Email=findViewById(R.id.etEmail);
        Password=findViewById(R.id.etPassword);
        Logo=findViewById(R.id.ivLogo);
        Card=findViewById(R.id.card);
        Login=findViewById(R.id.tvLogin);


    }

    private void validate(final String userEmail, final String userPassword) {

        if (userEmail.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(loginScreen.this, "Please Enter the data", Toast.LENGTH_SHORT).show();
        } else
        {
            firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(loginScreen.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(loginScreen.this, Co_OrdinatorProfileActivity.class));
                    } else {
                        Toast.makeText(loginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}
