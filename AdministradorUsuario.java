/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1programacion2;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */

public class AdministradorUsuario {
    private String NombreCompleto;
    private int edad;
    private ArrayList<Usuario> usuarios; // este array me lleva la cantidad de usuarios creados
    private boolean logueado;
    
    public AdministradorUsuario(String username, String password,String NombreCompleto,int edad) {     
        this.NombreCompleto = NombreCompleto;
        this.edad = edad;
        this.usuarios = new ArrayList<>();
        this.logueado=false;
    }
    public String getNombreCompleto() {
        return NombreCompleto;
    }
    public int getEdad() {
        return edad;
    }
    
     public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
    public static AdministradorUsuario crearUsuario(String user, String password, String nombreCompleto, int edad) {
        return new AdministradorUsuario(user, password, nombreCompleto, edad);
    }
   
   public void EliminarUsuarios(String codigo){
       for(Usuario usu:usuarios){
           if (usu.getUsername().equals(codigo)){
               usuarios.remove(usu);
               return;
           }
       } 
   }
   public void crearuser(String username,String contrasena,String tipouser,int edad,String nombre ){
       System.out.println("SE CREO el user: "+username);
   usuarios.add(new Usuario( username,nombre, contrasena, tipouser, edad));
   }
   public boolean buscaruser(String code){
   for(Usuario usu:usuarios){
   if(usu.getUsername().equals(code)){
   return true; //si existe
   }
   }
   return false;//no existe
   }
   public String contra(String code){
   for(Usuario usu:usuarios){
   if(usu.getUsername().equals(code)){
   return usu.getContrasena(); //si existe
   }
   }
   return null;
   }
   public String tipouser(String code){
   for(Usuario usu:usuarios){
   if(usu.getUsername().equals(code)){
   return usu.getTipoUsuario(); //si existe
   }
   }
   return null;
   }
   public void EditarUsuario(String username,String contrasena,String tipouser,int edad,String nombre,String usernameAnti){
      for(Usuario usu:usuarios){
       if(usu.getUsername().equals(usernameAnti)){
           usu.setContrasena(contrasena);
           usu.setUsername(username);
           usu.setNombre(nombre);
           usu.setTipoUsuario(tipouser);
           usu.setEdad(edad);
       }   
      }
   }
   
}
