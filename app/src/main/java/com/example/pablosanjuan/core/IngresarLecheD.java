package com.example.pablosanjuan.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pablosanjuan.core.db.DbLecheD;


public class IngresarLecheD extends ActionBarActivity implements View.OnClickListener{

    private Button btn_guardar;
    private DbLecheD dbLeche;
    private EditText edt_produ_dia;
    private EditText edt_precio;
    private Spinner spi_jornada;

    private String[] jornada = {"Mañana","Tarde"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_leched);

        btn_guardar = (Button) findViewById(R.id.btn_guardar_Leche);
        dbLeche = new DbLecheD(this);
        edt_produ_dia = (EditText) findViewById(R.id.edt_produ_diaria);
        edt_precio = (EditText) findViewById(R.id.edt_precio);
        spi_jornada = (Spinner) findViewById(R.id.spi_jornada);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jornada);
        spi_jornada.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        String id = "123";
        String produ = edt_produ_dia.getText().toString();
        String precio = edt_precio.getText().toString();
        String jornada = spi_jornada.getSelectedItem().toString();
        String fecha = "07/20/2015";
        dbLeche.inserta(this, id, produ, precio, fecha, jornada);
    }
}
