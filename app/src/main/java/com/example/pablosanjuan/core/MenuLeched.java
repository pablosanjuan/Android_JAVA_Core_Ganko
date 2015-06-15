package com.example.pablosanjuan.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pablosanjuan.core.adapters.AdapterLecheD;
import com.example.pablosanjuan.core.db.DbLecheD;
import com.example.pablosanjuan.core.vo.LecheDVO;

import java.util.List;


public class MenuLeched extends Fragment implements View.OnClickListener {

    private Button btn_agregar;
    ListView lista;
    DbLecheD dbLecheD;
    AdapterLecheD adapterLecheD;
    private List<LecheDVO> listaleche;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu_leched, container, false);

        btn_agregar = (Button) rootView.findViewById(R.id.btn_agregar_leched);
        btn_agregar.setOnClickListener(this);

        lista = (ListView) rootView.findViewById(R.id.lista_leched);
        dbLecheD = new DbLecheD(getActivity());
        listaleche = dbLecheD.getRegistros();
        try {
            adapterLecheD = new AdapterLecheD(getActivity(), listaleche);
            lista.setAdapter(adapterLecheD);
        }catch (Exception e){
            Toast.makeText(getActivity(),"No hay registros",Toast.LENGTH_LONG).show();
        }
        return rootView;
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_leched:
                Intent intent = new Intent(getActivity(), IngresarLecheD.class);
                startActivity(intent);
                break;
        }
    }

}
