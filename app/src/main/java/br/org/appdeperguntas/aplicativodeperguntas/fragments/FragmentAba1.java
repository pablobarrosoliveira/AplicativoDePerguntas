package br.org.appdeperguntas.aplicativodeperguntas.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.org.appdeperguntas.aplicativodeperguntas.MenuAba1;
import br.org.appdeperguntas.aplicativodeperguntas.R;

public class FragmentAba1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aba1, container, false);
        View option1 = view.findViewById(R.id.frag1_option1);
        View option2 = view.findViewById(R.id.frag1_option2);
        View option3 = view.findViewById(R.id.frag1_option3);
        View option4 = view.findViewById(R.id.frag1_option4);

        option1.setOnClickListener(clickListener(option1));
        option2.setOnClickListener(clickListener(option2));
        option3.setOnClickListener(clickListener(option3));
        option4.setOnClickListener(clickListener(option4));
        return view;
    }

    private View.OnClickListener clickListener(final View view){

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.frag1_option1:
                        Intent intent = new Intent(getActivity(), MenuAba1.class);
                        intent.putExtra("opcao1", "opcao1");
                        startActivity(intent);
                        break;
                    case R.id.frag1_option2:
                        Toast.makeText(getActivity(), "Clicado em " + v.getTag(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.frag1_option3:
                        Toast.makeText(getActivity(), "Clicado em " + v.getTag(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.frag1_option4:
                        Toast.makeText(getActivity(), "Clicado em " + v.getTag(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
    }
}
