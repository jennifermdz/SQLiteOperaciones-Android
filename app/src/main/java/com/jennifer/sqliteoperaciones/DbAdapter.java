package com.jennifer.sqliteoperaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter {

    dBHelper helper;

    public DbAdapter(Context context){
        helper = new dBHelper(context);
    }

    public long insertarDatos(String usuario, String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contenidoValores = new ContentValues();
        contenidoValores.put(dBHelper.NAME,usuario);
        contenidoValores.put(dBHelper.MyPASSWORD, password);
        long id = db.insert(dBHelper.TABLE_NAME,null,contenidoValores);
        return id;
    }

    static class dBHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "registrosdb";//Nombre de Base de datos
        private static final String TABLE_NAME = "usuarios";//Nombre de Tabla
        private static final int DATABASE_version = 1;//Version de Base de datos
        private static final String UID = "_id";//Columna I (Primary Key - Clave Primaria)
        private static final String NAME = "Nombre";//Columna II
        private static final String MyPASSWORD = "Password";//Columna III
        private static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME +
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ NAME+ " VARCHAR(255), "+MyPASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
        private Context context;
        public dBHelper (Context contextRecibido){
            super(contextRecibido, DATABASE_NAME, null, DATABASE_version);
            this.context = contextRecibido;
        }
        //Se crea la Base de datos
        public void onCreate(SQLiteDatabase db){
            try{
            db.execSQL(CREATE_TABLE);
        }catch(Exception e){
                mensaje.aviso(context, "Error" + e);
            }
        }

        //Se actualiza la Base de datos
        @Override
        public void onUpgrade (SQLiteDatabase db, int viejaVersion, int nuevaVersion){
             try{
               db.execSQL(DROP_TABLE);
               onCreate(db);
        }catch(Exception e){
                 mensaje.aviso(context,"Error" + e);
             }

        }
     }
  }
