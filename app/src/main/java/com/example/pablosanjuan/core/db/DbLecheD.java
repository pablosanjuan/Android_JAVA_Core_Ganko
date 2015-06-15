package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pablosanjuan.core.vo.LecheDVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 4/06/15.
 */
public class DbLecheD {

    public static final String TABLE_NAME = "LECHED";
    public static final String ID = "id";
    public static final String ID_PRODUCTION = "IdProducto";
    public static final String FECHA  = "Fecha";
    public static final String HORA = "Hora";
    public static final String PRODUDIARIA = "ProduDiaria";
    public static final String PRECIOL = "PrecioL";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + ID + " integer primary key autoincrement,"
            + ID_PRODUCTION + " integer not null,"
            + PRODUDIARIA + " real not null,"
            + PRECIOL + " text not null,"
            + FECHA + " text not null,"
            + HORA + " text not null)";

    private DbHelper helper;
    private SQLiteDatabase db;
    private Cursor dbCursor;

    public DbLecheD(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String id, String produdiaria, String preciol, String fecha, String hora) {
        ContentValues valores = new ContentValues();
        valores.put(ID_PRODUCTION, id);
        valores.put(PRODUDIARIA, produdiaria);
        valores.put(PRECIOL, preciol);
        valores.put(FECHA, fecha);
        valores.put(HORA, hora);
        return valores;
    }

    public void inserta(Context context, String id, String produdiaria, String preciol, String fecha, String hora) {
        long pos = db.insert(TABLE_NAME, null, generarContentValues(id, produdiaria, preciol, fecha, hora));
        Toast.makeText(context, "Se inserto en la posicion " + pos, Toast.LENGTH_LONG).show();
    }

    public Cursor cargarCursorRegistro() {
        String[] columnas = new String[]{ID_PRODUCTION, PRODUDIARIA, PRECIOL, FECHA, HORA};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    public List<LecheDVO> getRegistros() {
        List<LecheDVO> listaRegistros = null;
        String[] columnas = new String[]{ID_PRODUCTION, PRODUDIARIA, PRECIOL, FECHA, HORA};
        dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
        if (dbCursor.getCount() > 0) {
            listaRegistros = new ArrayList<LecheDVO>();
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                LecheDVO registro = new LecheDVO();
                registro.setId((dbCursor.getString(0)));
                registro.setProduDiaria(dbCursor.getString(1));
                registro.setPrecioL(dbCursor.getString(2));
                registro.setFecha(dbCursor.getString(3));
                registro.setHora(dbCursor.getString(4));

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
