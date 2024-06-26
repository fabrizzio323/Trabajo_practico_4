package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
public class Carrera {
    private int codigo;
    @NotBlank(message="Ingrese el nombre")
    @Size(min=3, max=20, message="Debe tener entre 3 y 20 caracteres")
    @Pattern(regexp="[a-z A-Z]*", message="El nombre solo deben ser letras")
    private String nombre;
    private short cantidadAnios;
    private boolean estado;
    
    public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(int codigo, String nombre, short cantidadAnios, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(short cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
}