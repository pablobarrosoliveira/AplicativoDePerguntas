package br.org.appdeperguntas.aplicativodeperguntas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuAba1Activity extends AppCompatActivity {

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aba1);
        final ViewPager vpAba1 = findViewById(R.id.menuAba1ViewPager);
        final TextView titulo = findViewById(R.id.menuAba1Titulo);

        final String opcao = getIntent().getStringExtra("opcao");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                switch (opcao){
                    case "m1": titulo.setBackgroundColor(getResources().getColor(R.color.orange)); break;
                    case "m2": titulo.setBackgroundColor(getResources().getColor(R.color.brown)); break;
                    case "m3": titulo.setBackgroundColor(getResources().getColor(R.color.lightblue)); break;
                    case "m4": titulo.setBackgroundColor(getResources().getColor(R.color.green)); break;
                }

                Map<String,String> td = (HashMap<String, String>) dataSnapshot.child("consoles").child(opcao).getValue();
                titulo.setText(dataSnapshot.child("menus").child(opcao).getValue().toString());


                ArrayList<String> list = new ArrayList<>();
                list.addAll(new ArrayList<>(td.values()));
                vpAba1.setAdapter(new myAdapter(list, MenuAba1Activity.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        vpAba1.setPadding(120,0,120,0);
        vpAba1.setClipToPadding(false);
    }

    public class myAdapter extends PagerAdapter{

        ArrayList<String> list;
        Context context;

        private myAdapter(ArrayList<String> list, Context context){
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater lInflater = LayoutInflater.from(context);
            View view = lInflater.inflate(R.layout.item_viewpager, container, false);

            //preencher o conteudo do card conforme o position e a list recebida list.get(position).
            TextView textView = view.findViewById(R.id.text);
            textView.setText(list.get(position));

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }
    }

}
