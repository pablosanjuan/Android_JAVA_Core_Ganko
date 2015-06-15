package com.example.pablosanjuan.core.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.vo.CebaVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 9/06/15.
 */
public class AdapterCeba extends BaseAdapter{

    private List<CebaVO> listaleched;
    private LayoutInflater layoutInflater;
    public AdapterCeba(Activity a, List<CebaVO> listaleched) {

        super();
        this.listaleched = new ArrayList<CebaVO>();
        if (listaleched != null) {
            this.listaleched = listaleched;
        }
        layoutInflater = a.getLayoutInflater();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaleched.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listaleched.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        view = layoutInflater.inflate(R.layout.elemento_registro, null);

        String id = listaleched.get(position).getId();
        String fecha = listaleched.get(position).getFecha();
        String edad = listaleched.get(position).getEdad();
        String peso = listaleched.get(position).getPeso();

        ImageView foto_bov = (ImageView) view.findViewById(R.id.foto_perfil_bovino);
        TextView tv_registro1 = (TextView) view.findViewById(R.id.registro1);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.registro2);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.registro3);
        TextView tv_registro4 = (TextView) view.findViewById(R.id.registro4);

        //foto_bov.setImageURI(Uri.parse(foto));
        tv_registro1.setText("Id: " + id);
        tv_registro2.setText("Fecha Destete: " + fecha);
        tv_registro3.setText("Edad Destete: " + edad);
        tv_registro4.setText("Peso Destete: " + peso);

        return view;
    }
}
