package br.org.appdeperguntas.aplicativodeperguntas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {

    View guest, signupin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        guest = findViewById(R.id.guest);
        signupin = findViewById(R.id.signupin);

        guest.setOnClickListener(RetornaOnClickListener(guest));
        signupin.setOnClickListener(RetornaOnClickListener(signupin));
    }

    View.OnClickListener RetornaOnClickListener(final View view){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (view.getId()){
                    case R.id.guest:
                        Intent intent = new Intent(LoginScreenActivity.this, HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.signupin:
                        Toast.makeText(LoginScreenActivity.this, "Função em construção", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
    }
}