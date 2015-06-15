package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pablosanjuan.core.vo.LecheVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 10/06/15.
 */
public class DbLeche {
    public static final String TABLE_NAME = "LECHE";
    public static final String ID = "id";
    public static final String ID_BOVINO = "IdBovino";
    public static final String LOTE  = "Lote";
    public static final String PARTO = "NumParto";
    public static final String TOTAL = "Total";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + ID + " integer primary key autoincrement,"
            + ID_BOVINO + " text not null,"
            + LOTE + " text not null,"
            + PARTO + " text not null,"
            + TOTAL + " text not null)";

    private DbHelper helper;
    private SQLiteDatabase db;
    private Cursor dbCursor;

    public DbLeche(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String id, String lote, String parto, String total) {
        ContentValues valores = new ContentValues();
        valores.put(ID_BOVINO, id);
        valores.put(LOTE, lote);
        valores.put(PARTO, parto);
        valores.put(TOTAL, total);
        return valores;
    }

    public void inserta(Context context, String id, String lote, String parto, String total) {
        long pos = db.insert(TABLE_NAME, null, generarContentValues(id, lote, parto, total));
        Toast.makeText(context, "Se inserto en la posicion " + pos, Toast.LENGTH_LONG).show();
    }

    public Cursor cargarCursorRegistro() {
        String[] columnas = new String[]{ID_BOVINO, LOTE, PARTO, TOTAL};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    public List<LecheVO> getRegistros() {
        List<LecheVO> listaRegistros = null;
        String[] columnas = new String[]{ID_BOVINO, LOTE, PARTO, TOTAL};
        dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
        if (dbCursor.getCount() > 0) {
            listaRegistros = new ArrayList<LecheVO>();
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                LecheVO registro = new LecheVO();
                registro.setId((dbCursor.getString(0)));
                registro.setLote(dbCursor.getString(1));
                registro.setParto(dbCursor.getString(2));
                registro.setTotal(dbCursor.getString(3));

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
