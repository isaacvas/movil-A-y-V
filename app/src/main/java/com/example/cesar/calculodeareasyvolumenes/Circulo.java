package com.example.cesar.calculodeareasyvolumenes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        radio = (EditText)findViewById(R.id.txtRadio);
        resources = this.getResources();

    }
    public void calcular(View v) {
        double ra, resultado;
        if (validar()) {
            ra = Double.parseDouble(radio.getText().toString());
            resultado = 3.14 *(ra*ra)  ;

            Operacion o = new Operacion(String.valueOf(R.string.area_del_radio), R.string.radio + ": " + ra , resultado);
            o.guardar();
            Toast.makeText(this, resources.getString(R.string.msn_resultado) + "\n" + resources.getString(R.string.area) + " " + resultado, Toast.LENGTH_SHORT).show();
            limpiarCampo();
        }
    }

    public boolean validar(){
        if (radio.getText().length() == 0){
            radio.setError(resources.getString(R.string.msn_error));
            return false;
        }

        return true;
    }
    public void limpiar(View v){
        radio.setText("");

    }
    public void limpiarCampo(){
        radio.setText("");
    }
}
