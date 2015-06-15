package com.example.pablosanjuan.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pablosanjuan.core.db.DbLeche;


public class IngresarLeche extends ActionBarActivity implements View.OnClickListener {

    EditText edt_lote;
    EditText edt_parto;
    EditText edt_id;
    Button btn_guardar;
    DbLeche dbLeche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_leche);

        edt_lote = (EditText) findViewById(R.id.edt_lote);
        edt_parto = (EditText) findViewById(R.id.edt_parto);
        edt_id = (EditText) findViewById(R.id.edt_id_bovinol);
        btn_guardar = (Button) findViewById(R.id.btn_guardar_Leche);
        btn_guardar.setOnClickListener(this);
        dbLeche = new DbLeche(this);

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
    public void onClick(View v) {

        String id = edt_id.getText().toString();
        String parto = edt_parto.getText().toString();
        String lote = edt_lote.getText().toString();
        String total = "";
        dbLeche.inserta(this, id, lote, parto, total);

    }

}
