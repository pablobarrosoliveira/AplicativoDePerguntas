package br.org.appdeperguntas.aplicativodeperguntas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.org.appdeperguntas.aplicativodeperguntas.fragments.FragmentAba1;
import br.org.appdeperguntas.aplicativodeperguntas.fragments.FragmentAba2;
import br.org.appdeperguntas.aplicativodeperguntas.fragments.FragmentAba3;
import br.org.appdeperguntas.aplicativodeperguntas.fragments.FragmentAba4;
import br.org.appdeperguntas.aplicativodeperguntas.fragments.FragmentAba5;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavView = findViewById(R.id.bottom_navigation);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.aba1:
                        OpenFragment(new FragmentAba1());
                        break;
                    case  R.id.aba2:
                        OpenFragment(new FragmentAba2());
                        break;
                    case R.id.aba3:
                        OpenFragment(new FragmentAba3());
                        break;
                    case  R.id.aba4:
                        OpenFragment(new FragmentAba4());
                        break;
                    case  R.id.aba5:
                        OpenFragment(new FragmentAba5());
                        break;
                }
                return true;
            }
        });
        OpenFragment(new FragmentAba1());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_bar_menu, menu);
        return true;
    }

    void OpenFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //if (nome.equals("firstRun")) {}
        //else ft.addToBackStack(nome);
        ft.replace(R.id.frameLayout, fragment);
        ft.commitAllowingStateLoss();
    }
}
