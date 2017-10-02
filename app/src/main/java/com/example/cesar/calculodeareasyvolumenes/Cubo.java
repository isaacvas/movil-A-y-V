package com.example.cesar.calculodeareasyvolumenes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cubo extends AppCompatActivity {
    private EditText arista;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        arista = (EditText) findViewById(R.id.txtArista);
        resources = this.getResources();
    }
    public void calcular(View v) {
        double ar, resultado;
        if (validar()) {
            ar = Double.parseDouble(arista.getText().toString());
            resultado = (6 *(ar*ar));

            Operacion o = new Operacion(resources.getString(R.string.v_cubo), resources.getString(R.string.arista) + ": " + ar , resultado);
            o.guardar();
            Toast.makeText(this, resources.getString(R.string.msn_resultado) + "\n" + resources.getString(R.string.volumen) + " " + resultado, Toast.LENGTH_SHORT).show();
            limpiarCampo();
        }
    }

    public boolean validar(){
        if (arista.getText().length() == 0){
            arista.setError(resources.getString(R.string.msn_error));
            return false;
        }

        return true;
    }
    public void limpiar(View v){
        arista.setText("");

    }
    public void limpiarCampo(){

        arista.setText("");
    }


}
