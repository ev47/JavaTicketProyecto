/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1programacion2;

/**
 *
 * @author LENOVO
 */
public class Usuario {
    private String Username;
    private String nombre;
    private String contrasena;
    private String tipoUsuario;
    private int edad;
    
    
    
    
    public Usuario(String username,String nombre,String contrasena,String tipouser,int edad){
    this.Username=username;
    this.contrasena=contrasena;
    this.tipoUsuario=tipouser;
    this.edad=edad;
    }
    public void cambiardatos(String newusername,String newname,String nombre,String contrasena,String tipouser, int edad){
    this.Username=newusername;
    this.contrasena=contrasena;
    this.tipoUsuario=tipouser;
    this.edad=edad;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
