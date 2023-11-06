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
public class EventoDeportivo extends Evento {
    private String Equipo1;
    private String Equipo2;
    private TipoDeporte tipoDeporte;
    private double Precio;
    private ArrayList<String> jugadoresEquipo1;
    private ArrayList<String> jugadoresEquipo2;

    public EventoDeportivo(int codigo, String titulo, String descripcion, Calendar fecha,
            double montoRentaEstadio,String Equipo1,String Equipo2,
            TipoDeporte tipoDeporte) {
        super(codigo, titulo, descripcion, fecha, montoRentaEstadio);
        this.Equipo1=Equipo1;
        this.Equipo2=Equipo2;
        this.tipoDeporte=tipoDeporte;
        Precio=250;
        this.jugadoresEquipo1 = new ArrayList<>();
        this.jugadoresEquipo2 = new ArrayList<>();
    }

    public String getEquipo1() {
        return Equipo1;
    }

    public String getEquipo2() {
        return Equipo2;
    }

    public TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }

    public double getPrecio() {
        return Precio;
    }
    public ArrayList<String> getJugadoresEquipo1() {
        return jugadoresEquipo1;
    }

    public ArrayList<String> getJugadoresEquipo2() {
        return jugadoresEquipo2;
    }

    public void agregarJugadorEquipo1(String jugador) {
        this.jugadoresEquipo1.add(jugador);
    }

    public void agregarJugadorEquipo2(String jugador) {
        this.jugadoresEquipo2.add(jugador);
    }

    public double CalcularCadaEvento() {
    return Precio*20000;
    }

   
            
}


