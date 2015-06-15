package com.example.pablosanjuan.core;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.pablosanjuan.core.db.DbCeba;

import java.util.Calendar;
import java.util.Date;


public class IngresarCeba extends ActionBarActivity implements View.OnClickListener{

    EditText edt_id;
    EditText edt_edad;
    EditText edt_peso;
    Button btn_fecha;
    Button btn_guardar;
    DbCeba dbCeba;
    private int year, month, day;
    private Calendar calendar;
    String var_fecha = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_ceba);
        edt_id = (EditText) findViewById(R.id.edt_id_bovinoc);
        edt_edad = (EditText) findViewById(R.id.edt_edad_destete);
        edt_peso = (EditText) findViewById(R.id.edt_peso_destete);
        btn_fecha = (Button) findViewById(R.id.btn_fecha_destete);
        btn_fecha.setOnClickListener(this);
        btn_guardar = (Button) findViewById(R.id.btn_guardar_ceba);
        btn_guardar.setOnClickListener(this);
        dbCeba = new DbCeba(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

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
        switch (v.getId()){
            case R.id.btn_guardar_ceba:
                String id = edt_id.getText().toString();
                String fecha = btn_fecha.getText().toString();
                String edad = edt_edad.getText().toString();
                String peso = edt_peso.getText().toString();
                dbCeba.inserta(this, id, fecha, edad, peso);
                break;

            case R.id.btn_fecha_destete:
                showDialog(999);
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            DatePickerDialog dialogDate = new DatePickerDialog(this, myDateListener, year, month, day);
            dialogDate.getDatePicker().setMaxDate(new Date().getTime());
            return dialogDate;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        var_fecha = (new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year)).toString();
        btn_fecha.setText(var_fecha);
    }
}
