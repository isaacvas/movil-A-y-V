package com.example.cesar.calculodeareasyvolumenes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cilindro extends AppCompatActivity {
    private EditText radio, altura;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        radio = (EditText)findViewById(R.id.txtRadio);
        altura = (EditText)findViewById(R.id.txtAltura);
        resources = this.getResources();
    }
    public void calcular(View v) {
        double ra, al, resultado;
        if (validar()) {
            ra = Double.parseDouble(radio.getText().toString());
            al = Double.parseDouble(altura.getText().toString());
            resultado = 3.14 *(al * (ra*ra));

            Operacion o = new Operacion(resources.getString(R.string.volumen_del_cilindro), resources.getString(R.string.radio) + ": " + ra +"\n" +resources.getString(R.string.altura) + ": " + al, resultado);
            o.guardar();
            Toast.makeText(this, resources.getString(R.string.msn_resultado) + "\n" + resources.getString(R.string.volumen) + " " + resultado, Toast.LENGTH_SHORT).show();
            limpiarCampo();
        }
    }

    public boolean validar(){
        if (radio.getText().length() == 0){
            radio.setError(resources.getString(R.string.msn_error));
            return false;
        }
        if (altura.getText().length() == 0){
            altura.setError(resources.getString(R.string.msn_error));
            return false;
        }


        return true;
    }
    public void limpiar(View v){
        radio.setText("");
        altura.setText("");

    }
    public void limpiarCampo(){
        radio.setText("");
        altura.setText("");
    }
}
