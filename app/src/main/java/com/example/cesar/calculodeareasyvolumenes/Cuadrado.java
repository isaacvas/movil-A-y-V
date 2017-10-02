package com.example.cesar.calculodeareasyvolumenes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cuadrado extends AppCompatActivity {
    private EditText v_lado;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
         v_lado = (EditText)findViewById(R.id.txtLado);
        resources = this.getResources();
    }
    public void calcular(View v) {
        double lado, resultado;
        if (validar()) {
            lado = Double.parseDouble(v_lado.getText().toString());
            resultado = lado * lado;

            Operacion o = new Operacion(resources.getString(R.string.area_del_cuadrado),resources.getString(R.string.v_lado)  + ": " + lado, resultado);
            o.guardar();
            Toast.makeText(this, resources.getString(R.string.msn_resultado) + "\n" + resources.getString(R.string.area) + " " + resultado, Toast.LENGTH_SHORT).show();
            limpiarCampo();
        }
    }

    public boolean validar(){
        if (v_lado.getText().length() == 0){
            v_lado.setError(resources.getString(R.string.msn_error));
            return false;
        }

        return true;
    }
    public void limpiar(View v){
        v_lado.setText("");

    }
    public void limpiarCampo(){
        v_lado.setText("");
    }
}
