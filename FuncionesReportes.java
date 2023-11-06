/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1programacion2;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
public class FuncionesReportes {
    
    public void listarEventos(List<Evento> eventos, int index) {
        if (index >= eventos.size()) {
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Evento evento = eventos.get(index);
        String tipoEvento = "";
        if (evento instanceof EventoDeportivo) {
            tipoEvento = "DEPORTIVO";
        } else if (evento instanceof EventoMusical) {
            tipoEvento = "MUSICAL";
        } else if (evento instanceof EventoReligioso) {
            tipoEvento = "RELIGIOSO";
        }
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaEvento = evento.getFecha();
        long diferencia = fechaEvento.getTimeInMillis() - fechaActual.getTimeInMillis();
        long diferenciaEnDias = diferencia / (24 * 60 * 60 * 1000); // Convertir a días
        System.out.println(evento.getCodigo() + " - " + tipoEvento + " - " 
        + evento.getTitulo() + " - " + 
        dateFormat.format(evento.getFecha().getTime()) + " - " 
        + evento.getMontoRentaEstadio() + " - Diferencia en días: " + diferenciaEnDias);
        listarEventos(eventos, index + 1);
    }
    // aqui se llama lo que se creo de la funcion listareventosfuturos 
    public void listarEventosFuturos(List<Evento> eventos) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fechaActual = Calendar.getInstance();
        listarEventosFuturosRecursivo(eventos, 0, dateFormat, fechaActual);
    }
    // aqui con recursividad los eventos Futuros
    private void listarEventosFuturosRecursivo(List<Evento> eventos, int index, SimpleDateFormat dateFormat, Calendar fechaActual) {
        if (index >= eventos.size()) {
            return;
        }
        Evento evento = eventos.get(index);
        if (evento.getFecha().after(fechaActual)) {
            String tipoEvento = "";
            if (evento instanceof EventoDeportivo) {
                tipoEvento = "DEPORTIVO";
            } else if (evento instanceof EventoMusical) {
                tipoEvento = "MUSICAL";
            } else if (evento instanceof EventoReligioso) {
                tipoEvento = "RELIGIOSO";
            }
            System.out.println(evento.getCodigo() + " - " + tipoEvento + " - "
                    + evento.getTitulo() + " - "
                    + dateFormat.format(evento.getFecha().getTime()) + " - "
                    + evento.getMontoRentaEstadio());
        }
        listarEventosFuturosRecursivo(eventos, index + 1, dateFormat, fechaActual);
    }   
    public void ListarEventosCancelados(List<Evento> eventos){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fechaCancelada = Calendar.getInstance();
        ListarEventosMetodoRecursivo(eventos, 0, dateFormat, fechaCancelada);
    }
    private void ListarEventosMetodoRecursivo(List<Evento>eventos,int index,SimpleDateFormat dateFormat,Calendar fechaCancelada){
          if (index >= eventos.size()) {
            return;
        }
        Evento evento = eventos.get(index);
        if (evento.isCancelado()) {
            String tipoEvento = "";
            if (evento instanceof EventoDeportivo) {
                tipoEvento = "DEPORTIVO";
            } else if (evento instanceof EventoMusical) {
                tipoEvento = "MUSICAL";
            } else if (evento instanceof EventoReligioso) {
                tipoEvento = "RELIGIOSO";
            }
            System.out.println(evento.getCodigo() + " - " + tipoEvento + " - "
                    + evento.getTitulo() + " - "
                    + dateFormat.format(evento.getFecha().getTime()) + " - "
                    + evento.getMontoRentaEstadio());
        }
        ListarEventosMetodoRecursivo(eventos, index + 1, dateFormat, fechaCancelada);
    }
     // metodo de ver pefil Usuario
    public void verperfil(){
    
}
}