package com.jennifer.sqliteoperaciones;

import android.content.Context;
import android.widget.Toast;

public class mensaje {
    public static void aviso(Context context, String aviso){
        Toast.makeText(context, aviso, Toast.LENGTH_LONG).show();
    }
}
