/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1programacion2;

import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
   public class EventoReligioso extends Evento{
     private int cantidadConvertidos;
     private double precio;
     private final int grama= 2000;
    public EventoReligioso(int codigo, String titulo, String descripcion, Calendar fecha, 
            double montoRentaEstadio,int cantidadConvertidos) {
        super(codigo, titulo, descripcion, fecha, montoRentaEstadio);
    }
    public int getCantidadConvertidos() {
        return cantidadConvertidos;
    }
    public double getPrecio() {
        return precio;
    }
    public int getGrama() {
        return grama;
    }
    public void setCantidadConvertidos(int cantidadConvertidos) {
        this.cantidadConvertidos = cantidadConvertidos;
    }
   
    @Override
    public double CalcularCadaEvento() {
     return precio *30000;      
    }
    
}
