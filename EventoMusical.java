/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1programacion2;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
public class EventoMusical extends Evento {
    private final double seguro=0.3;
    TipoMusica tipoMusica;
    private double precio;
     private ArrayList<String> personasInvolucradas;

    public EventoMusical(int codigo, String titulo, String descripcion,
            Calendar fecha, double montoRentaEstadio,TipoMusica tipoMusica) {
        super(codigo, titulo, descripcion, fecha, montoRentaEstadio);
        precio=650;
         this.personasInvolucradas = new ArrayList<>();
    }

    public double getSeguro() {
        return seguro;
    }

    public TipoMusica getTipoMusica() {
        return tipoMusica;
    }

    public double getPrecio() {
        return precio;
    }
    
    public ArrayList<String> getPersonasInvolucradas() {
        return personasInvolucradas;
    }
    public void setPersonasInvolucradas(ArrayList<String> personasInvolucradas) {
    this.personasInvolucradas = personasInvolucradas;
}

    public void agregarPersonaInvolucrada(String persona) {
        this.personasInvolucradas.add(persona);
    }
    
    @Override
    public double CalcularCadaEvento() {
           return precio * 25000;
    }
    
}
