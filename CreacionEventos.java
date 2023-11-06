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
public class CreacionEventos {

     private ArrayList<Evento> eventosCreados;// este array me lleva la cantidad de eventos creados 
     
     public CreacionEventos(){   
       this.eventosCreados = new ArrayList<>();

     }
    public ArrayList<Evento> getEventosCreados() {
        return eventosCreados;
    }  
      
    // metodo para crear eventos
   public void crearEvento(int codigo, String titulo, String descripcion, Calendar fecha, double montoRentaEstadio,
        String equipo1, String equipo2, TipoDeporte tipoDeporte, TipoEvento tipo, TipoMusica tipoMusica, int cantidadConvertidos) {
    switch (tipo) {
        case DEPORTIVO:
            crearEventoDeportivo(codigo, titulo, descripcion, fecha, montoRentaEstadio, equipo1, equipo2, tipoDeporte);
            break;
        case MUSICAL:
            crearEventoMusical(codigo, titulo, descripcion, fecha, montoRentaEstadio, tipoMusica);
            break;
        case RELIGIOSO:
            crearEventoReligioso(codigo, titulo, descripcion, fecha, montoRentaEstadio, cantidadConvertidos);
            break;
        default:
            System.out.println("Tipo de evento no válido");
            break;
    }
}
private void crearEventoDeportivo(int codigo, String titulo, String descripcion, Calendar fecha, double montoRentaEstadio,
        String equipo1, String equipo2, TipoDeporte tipoDeporte) {
    Evento eventoDeportivo = new EventoDeportivo(codigo, titulo, descripcion, fecha, montoRentaEstadio,
            equipo1, equipo2, tipoDeporte);
    this.eventosCreados.add(eventoDeportivo);
}
public void crearEventoMusical(int codigo, String titulo, String descripcion, Calendar fecha, double montoRentaEstadio,
        TipoMusica tipoMusica) {
    Evento eventoMusical = new EventoMusical(codigo, titulo, descripcion, fecha, montoRentaEstadio, tipoMusica);
    this.eventosCreados.add(eventoMusical);
}
public void crearEventoReligioso(int codigo, String titulo, String descripcion, Calendar fecha, double montoRentaEstadio,
        int cantidadConvertidos) {
    Evento eventoReligioso = new EventoReligioso(codigo, titulo, descripcion, fecha, montoRentaEstadio, cantidadConvertidos);
    this.eventosCreados.add(eventoReligioso);
}  
    public void editarEvento(int codigoEvento, String jugador, int equipo,TipoEvento tipoevento,
            int codigo, String nuevoTitulo, String nuevaDescripcion, 
            ArrayList<String>personasInvolucradas,int nuevaCantidad){
      switch(tipoevento){
          case DEPORTIVO:
            registrarJugador( codigoEvento,jugador, equipo);
          break;
          case MUSICAL:
            editarEventoMusical( codigo, nuevoTitulo, nuevaDescripcion,personasInvolucradas);
          break;
          case RELIGIOSO:
           editarCantidadConvertidos( codigo,  nuevaCantidad);   
          break; 
          default: 
          System.out.println("El codigo no existe ");
          break;
      }
    }
  public void registrarJugador(int codigoEvento, String jugador, int equipo) {
    for (Evento evento : eventosCreados) {
        if (evento.getCodigo() == codigoEvento && evento instanceof EventoDeportivo) {
            EventoDeportivo eventoDeportivo = (EventoDeportivo) evento;
            if (equipo == 1) {
                eventoDeportivo.agregarJugadorEquipo1(jugador);
            } else if (equipo == 2) {
                eventoDeportivo.agregarJugadorEquipo2(jugador);
            }
            System.out.println("Jugador registrado con éxito.");
            return;
        }
    }
    System.out.println("No se encontró ningún evento deportivo con el código proporcionado.");
}
   public void editarEventoMusical(int codigo, String nuevoTitulo, String nuevaDescripcion, ArrayList<String>personasInvolucradas) {
        for (Evento evento : eventosCreados) {
        if (evento.getCodigo() == codigo && evento instanceof EventoMusical) {
            EventoMusical eventoMusical = (EventoMusical) evento;
            eventoMusical.setPersonasInvolucradas(personasInvolucradas);
            System.out.println("Personas involucradas actualizadas con éxito.");
            return;
        }
    }
    System.out.println("No se encontró ningún evento musical con el código proporcionado.");
    }
   public void editarCantidadConvertidos(int codigo, int nuevaCantidad) {
    for (Evento evento : eventosCreados) {
        if (evento.getCodigo() == codigo && evento instanceof EventoReligioso) {
            EventoReligioso eventoReligioso = (EventoReligioso) evento;
            eventoReligioso.setCantidadConvertidos(nuevaCantidad);
            System.out.println("Cantidad de personas convertidas actualizada con éxito.");
            return;
        }
    }
    System.out.println("No se encontró ningún evento religioso con el código proporcionado.");
}
    public void EliminarEvento(int codigo){
    for (Evento evento : eventosCreados) {
        if (evento.getCodigo() == codigo) {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaEvento = evento.getFecha();
            long diferencia = fechaEvento.getTimeInMillis() - fechaActual.getTimeInMillis();
            long diferenciaEnDias = diferencia / 86400000;
            if (diferenciaEnDias == 1) {
                if (evento instanceof EventoReligioso) {
                    System.out.println("El evento religioso no paga nada como indemnización.");
                } else {
                    double montoRenta = evento.getMontoRentaEstadio();
                    double indemnizacion = montoRenta * 0.5;
                    System.out.println("Se cobrará el 50% del monto como indemnización: " + indemnizacion);
                }
            }
            evento.setCancelado(true);
            System.out.println("El evento ha sido marcado como cancelado.");
            return;
        }
    }
    System.out.println("No se encontró ningún evento con el código proporcionado.");
}   
 public int verEvento(int codigoEvento) {
    for (Evento evento : eventosCreados) {
       if (evento.getCodigo() == codigoEvento) {
            StringBuilder detalles = new StringBuilder();
            detalles.append("Código del evento: ").append(evento.getCodigo()).append("\n");
            detalles.append("Título: ").append(evento.getTitulo()).append("\n");
            detalles.append("Descripción: ").append(evento.getDescripcion()).append("\n");
            detalles.append("Fecha: ").append(evento.getFecha().getTime()).append("\n");
            detalles.append("Monto de Renta de Estadio: ").append(evento.getMontoRentaEstadio()).append("\n");
            if (evento.isCancelado()) {
                detalles.append("Este evento ha sido cancelado.\n");
                if (evento.isMultaPagada()) {
                    detalles.append("La multa ha sido pagada.\n");
                } else {
                    detalles.append("La multa NO ha sido pagada.\n");
                }
            } else {
                detalles.append("Este evento NO ha sido cancelado.\n");
            }
            if (evento instanceof EventoDeportivo) {
                detalles.append("Tipo de Evento: Deportivo\n"); 
            } else if (evento instanceof EventoMusical) {
                detalles.append("Tipo de Evento: Musical\n");               
            } else if (evento instanceof EventoReligioso) {
                detalles.append("Tipo de Evento: Religioso\n");
                detalles.append("Cantidad de Personas Convertidas: ").append(((EventoReligioso) evento).getCantidadConvertidos()).append("\n");
            }
            System.out.println(detalles.toString());
            return 0; // Se encontro el evento y se obtuvieron los detalles correctamente.           
     }     
    }    
    // Si no se encontró el evento
   System.out.println("No se encontró ningún evento con el código proporcionado.");
    return -1; // No se encontró el evento
}   
}
