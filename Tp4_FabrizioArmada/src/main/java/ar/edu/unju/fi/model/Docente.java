package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
@Component
public class Docente {
    private String lejago;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    public Docente() {
		
	}
	public Docente(String lejago, String nombre, String apellido, String email, String telefono) {
		this.lejago = lejago;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public String getLejago() {
		return lejago;
	}
	public void setLejago(String lejago) {
		this.lejago = lejago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
}