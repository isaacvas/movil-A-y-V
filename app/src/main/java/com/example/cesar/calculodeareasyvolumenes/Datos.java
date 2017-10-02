package com.example.cesar.calculodeareasyvolumenes;

import java.util.ArrayList;

/**
 * Created by cesar on 1/10/2017.
 */

public class Datos {
    private static ArrayList<Operacion> operciones = new ArrayList<>();
     public static void guardar (Operacion o){
         operciones .add(o);}
    public static ArrayList<Operacion> getArray(){
        return operciones;
    }
}
