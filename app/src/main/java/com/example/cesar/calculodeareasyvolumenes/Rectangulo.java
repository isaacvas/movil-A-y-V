package com.example.cesar.calculodeareasyvolumenes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rectangulo extends AppCompatActivity {
    private EditText base, altura;
    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        base = (EditText)findViewById(R.id.txtBase);
        altura = (EditText)findViewById(R.id.txtAltura);
        resources = this.getResources();
    }
    public void calcular(View v) {
        double ba, al, resultado;
        if (validar()) {
            ba = Double.parseDouble(base.getText().toString());
            al = Double.parseDouble(altura.getText().toString());
            resultado = (ba * al);

            Operacion o = new Operacion(String.valueOf(R.string.area_del_rectangulo), R.string.base + ": " + ba +"\n" +R.string.altura + ": " + al, resultado);
            o.guardar();
            Toast.makeText(this, resources.getString(R.string.msn_resultado) + "\n" + resources.getString(R.string.area) + " " + resultado, Toast.LENGTH_SHORT).show();
            limpiarCampo();
        }
    }

    public boolean validar(){
        if (base.getText().length() == 0){
            base.setError(resources.getString(R.string.msn_error));
            return false;
        }
        if (altura.getText().length() == 0){
            altura.setError(resources.getString(R.string.msn_error));
            return false;
        }


        return true;
    }
    public void limpiar(View v){
        base.setText("");
        altura.setText("");

    }
    public void limpiarCampo(){
        base.setText("");
        altura.setText("");
    }

}
