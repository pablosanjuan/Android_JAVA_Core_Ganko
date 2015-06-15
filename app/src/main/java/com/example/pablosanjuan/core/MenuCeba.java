package com.example.pablosanjuan.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.pablosanjuan.core.adapters.AdapterCeba;
import com.example.pablosanjuan.core.db.DbCeba;
import com.example.pablosanjuan.core.vo.CebaVO;

import java.util.List;


public class MenuCeba extends Fragment implements View.OnClickListener {

    private Button btn_agregar;
    ListView lista;
    DbCeba dbCeba;
    AdapterCeba adapterCeba;
    private List<CebaVO> listaceba;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu_ceba, container, false);

        btn_agregar = (Button) rootView.findViewById(R.id.btn_agregar_ceba);
        btn_agregar.setOnClickListener(this);

        lista = (ListView) rootView.findViewById(R.id.lista_ceba);
        dbCeba = new DbCeba(getActivity());
        listaceba = dbCeba.getRegistros();
        adapterCeba = new AdapterCeba(getActivity(), listaceba);
        lista.setAdapter(adapterCeba);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_ceba:
                Intent intent = new Intent(getActivity(), IngresarCeba.class);
                startActivity(intent);
                break;

        }
    }
}
