package com.example.franprimo.actividad_3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String PREFS = "Mis preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.editName);
        final EditText dni = (EditText) findViewById(R.id.editText);
        final EditText fnac = (EditText) findViewById(R.id.editText2);
        final RadioGroup rGrupo = (RadioGroup) findViewById(R.id.grupoSexo);
        final RadioButton radioMan = (RadioButton) findViewById(R.id.radioHombre);
        final RadioButton radioWom = (RadioButton) findViewById(R.id.radioMujer);



        Button resumenBtn = (Button) findViewById(R.id.button);
        resumenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos o recuperamos el objeto de preferencias compartidas
                SharedPreferences mySP = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                //Obtenemos un editor para modificarlas
                SharedPreferences.Editor editor = mySP.edit();

                //Guardamos los valores introducidos por el usuario
                editor.putString("name", name.getText().toString());
                editor.putString("dni", dni.getText().toString());
                editor.putString("birthday", fnac.getText().toString());

                //Mediante el switch seleccionamos uno de los dos radioButtons
                String str = null;
                switch (rGrupo.getCheckedRadioButtonId()){
                    case R.id.radioHombre:
                        str = "Hombre";
                        break;
                    case R.id.radioMujer:
                        str = "Mujer";
                        break;
                }

                editor.putString("sex", str);

                //Guardamos los cambios
                editor.commit();

                //Mediante un intent pasamos a la siguiente pantalla
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
