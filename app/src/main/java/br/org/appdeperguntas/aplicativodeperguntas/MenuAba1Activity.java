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

import java.util.ArrayList;

public class MenuAba1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aba1);
        ViewPager vpAba1 = findViewById(R.id.menuAba1ViewPager);
        TextView titulo = findViewById(R.id.menuAba1Titulo);
        ArrayList<String> list = new ArrayList<String>();

        String opcao = getIntent().getStringExtra("opcao");
        switch (opcao){
            case "opcao1":
                titulo.setText("Opção 1");
                titulo.setBackgroundColor(getResources().getColor(R.color.orange));
                list.add("Opção 1 Item A");
                list.add("Opção 1 Item B");
                break;
            case "opcao2":
                titulo.setText("Opção 2");
                titulo.setBackgroundColor(getResources().getColor(R.color.brown));
                list.add("Opção 2 Item A");
                list.add("Opção 2 Item B");
                break;
            case "opcao3":
                titulo.setText("Opção 3");
                titulo.setBackgroundColor(getResources().getColor(R.color.lightblue));
                list.add("Opção 3 Item A");
                list.add("Opção 3 Item B");
                break;
            case "opcao4":
                titulo.setText("Opção 4");
                titulo.setBackgroundColor(getResources().getColor(R.color.green));
                list.add("Opção 4 Item A");
                list.add("Opção 4 Item B");
                break;
        }

        vpAba1.setPadding(120,0,120,0);
        vpAba1.setClipToPadding(false);
        vpAba1.setAdapter(new myAdapter(list, this));
    }

    public class myAdapter extends PagerAdapter{

        ArrayList<String> list;
        Context context;

        public myAdapter(ArrayList<String> list, Context context){
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
