package com.example.pablosanjuan.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.pablosanjuan.core.adapters.AdapterLeche;
import com.example.pablosanjuan.core.db.DbLeche;
import com.example.pablosanjuan.core.vo.LecheVO;

import java.util.List;

public class MenuLeche extends Fragment implements View.OnClickListener{

    Button btn_agregar;
    ListView lista;
    DbLeche dbLeche;
    AdapterLeche adapterLeche;
    private List<LecheVO> listaleche;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu_leche, container, false);

        btn_agregar = (Button) rootView.findViewById(R.id.btn_agregar_leche);
        btn_agregar.setOnClickListener(this);

        lista = (ListView) rootView.findViewById(R.id.lista_leche);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClick(position);
            }
        });
        dbLeche = new DbLeche(getActivity());
        listaleche = dbLeche.getRegistros();
        adapterLeche = new AdapterLeche(getActivity(), listaleche);
        lista.setAdapter(adapterLeche);

        return rootView;
    }

    private void itemClick(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new MenuLeched();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_leche:
                Intent intent = new Intent(getActivity(), IngresarLeche.class);
                startActivity(intent);
                break;

        }
    }
}
