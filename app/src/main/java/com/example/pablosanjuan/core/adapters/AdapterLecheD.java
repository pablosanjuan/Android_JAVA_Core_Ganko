package com.example.pablosanjuan.core.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.vo.LecheDVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 9/06/15.
 */
public class AdapterLecheD extends BaseAdapter {


    private List<LecheDVO> listaleched;
    private LayoutInflater layoutInflater;
    public AdapterLecheD(Activity a, List<LecheDVO> listaleched) {

        super();
        this.listaleched = new ArrayList<LecheDVO>();
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
        String produ = listaleched.get(position).getProduDiaria();
        String precio = listaleched.get(position).getPrecioL();
        String fecha = listaleched.get(position).getFecha();
        String hora = listaleched.get(position).getHora();

        ImageView foto_bov = (ImageView) view.findViewById(R.id.foto_perfil_bovino);
        TextView tv_registro1 = (TextView) view.findViewById(R.id.registro1);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.registro2);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.registro3);
        TextView tv_registro4 = (TextView) view.findViewById(R.id.registro4);
        TextView tv_registro5 = (TextView) view.findViewById(R.id.registro5);

        //foto_bov.setImageURI(Uri.parse(foto));
        tv_registro1.setText("Id: " + id);
        tv_registro2.setText("Produccion: " + produ);
        tv_registro3.setText("Fecha: " + fecha);
        tv_registro4.setText("Precio: " + precio);
        tv_registro5.setText("Jornada: " + hora);

        return view;
    }
}