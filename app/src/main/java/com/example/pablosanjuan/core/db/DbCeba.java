package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pablosanjuan.core.vo.CebaVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 9/06/15.
 */
public class DbCeba {

    public static final String TABLE_NAME = "CEBA";
    public static final String ID = "id";
    public static final String ID_BOVINO = "IdBovino";
    public static final String FECHA  = "FechaDestete";
    public static final String EDAD = "EdadDestete";
    public static final String PESO = "PesoDestete";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + ID + " integer primary key autoincrement,"
            + ID_BOVINO + " text not null,"
            + FECHA + " text not null,"
            + EDAD + " text not null,"
            + PESO + " text not null)";

    private DbHelper helper;
    private SQLiteDatabase db;
    private Cursor dbCursor;

    public DbCeba(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String id, String fecha, String edad, String peso) {
        ContentValues valores = new ContentValues();
        valores.put(ID_BOVINO, id);
        valores.put(FECHA, fecha);
        valores.put(EDAD, edad);
        valores.put(PESO, peso);
        return valores;
    }

    public void inserta(Context context,String id, String fecha, String edad, String peso) {
        long pos = db.insert(TABLE_NAME, null, generarContentValues(id, fecha, edad, peso));
        Toast.makeText(context, "Se inserto en la posicion " + pos, Toast.LENGTH_LONG).show();
    }

    public Cursor cargarCursorRegistro() {
        String[] columnas = new String[]{ID_BOVINO, FECHA, EDAD, PESO};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    public List<CebaVO> getRegistros() {
        List<CebaVO> listaRegistros = null;
        String[] columnas = new String[]{ID_BOVINO, FECHA, EDAD, PESO};
        dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
        if (dbCursor.getCount() > 0) {
            listaRegistros = new ArrayList<CebaVO>();
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                CebaVO registro = new CebaVO();
                registro.setId((dbCursor.getString(0)));
                registro.setFecha(dbCursor.getString(1));
                registro.setEdad(dbCursor.getString(2));
                registro.setPeso(dbCursor.getString(3));

                listaRegistros.add(registro);
                dbCursor.moveToNext();
            }
        }
        dbCursor.close();
        return listaRegistros;
    }

    public void borrarRegistros() {
        db.delete(TABLE_NAME, null, null);
    }
}
