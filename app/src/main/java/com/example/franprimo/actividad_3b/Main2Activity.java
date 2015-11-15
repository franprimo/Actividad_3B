package com.example.franprimo.actividad_3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends Activity {

    private static final String PREFS = "Mis preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recuperamos el objeto de preferencias
        SharedPreferences mySP = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

        //Recuperamos los valores guardados
        String name = mySP.getString("name", "");
        String dni = mySP.getString("dni", "");
        String fNac = mySP.getString("birthday", "");
        String sex = mySP.getString("sex", "");

        //Declaro los view
        TextView nombre = (TextView) findViewById(R.id.textName);
        TextView numero = (TextView) findViewById(R.id.textDni);
        TextView cumple = (TextView) findViewById(R.id.textFNac);
        TextView sexo = (TextView) findViewById(R.id.textSexo);

        ImageView img = (ImageView) findViewById(R.id.imageView);


        //Muestro los datos en los view
        nombre.setText(name);
        cumple.setText(fNac);
        sexo.setText(sex);
        numero.setText(dni);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
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
}
