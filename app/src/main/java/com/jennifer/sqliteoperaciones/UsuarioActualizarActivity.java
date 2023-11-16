package com.jennifer.sqliteoperaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioActualizarActivity extends AppCompatActivity {
    EditText nombreActual, nombreNuevo;
    DbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_actualizar);

        nombreActual = (EditText) findViewById(R.id.txtNombreActual);
        nombreNuevo = (EditText) findViewById(R.id.txtNombreNuevo);

        helper = new DbAdapter(this);
    }
    public void update(View view){
        String datoNombreActual = nombreActual.getText().toString();
        String datoNombreNuevo = nombreNuevo.getText().toString();

        if(datoNombreActual.isEmpty() || datoNombreNuevo.isEmpty()){
            mensaje.aviso(getApplicationContext(), "Introduzca los datos");
        }
        int resultado = helper.updateName(datoNombreActual, datoNombreNuevo);
        if(resultado <=0){
            mensaje.aviso(getApplicationContext(), "Actualización fallida");
            nombreActual.setText("");
            nombreNuevo.setText("");
        }else{
            mensaje.aviso(getApplicationContext(), "Actualización exitosa");
            nombreActual.setText("");
            nombreNuevo.setText("");
            startMainActivity();
        }
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
