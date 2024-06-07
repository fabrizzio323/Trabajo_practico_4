package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Docente;

public class ListaAlumno {
   private static List<Alumno> alumnos = new ArrayList<>();
    
    public static List<Alumno> listarAlumnos() {
        if(alumnos.isEmpty()) {
        	alumnos.add(new Alumno("42548235", "Gabriel", "Palacios", "gabPalacios@gmail.com", "457-5423669", LocalDate.now(), "Italo palanca", "LU4587"));
        	alumnos.add(new Alumno("43568421", "Lucia", "Aguilar", "AguilarLuc@gmail.com", "457-4798635", LocalDate.now(), "Humahuaca", "LU2132"));
        	alumnos.add(new Alumno("44235698", "Mateo", "soliz", "solMateo@gmail.com", "457-4047896", LocalDate.now(), "Italo palanca", "LU3546"));
        	alumnos.add(new Alumno("41548789", "Romina", "armando", "armandoRomi@gmail.com", "457-3654213", LocalDate.now(), "San martin", "LU8795"));
        	alumnos.add(new Alumno("44687598", "candela", "armani", "armaniCandela@gmail.com", "457-4562102", LocalDate.now(), "Belgrano", "LU2546"));
        	alumnos.add(new Alumno("42546879", "pepe", "rodriguez", "rodriPepe@gmail.com", "457-8964257", LocalDate.now(), "Alvear", "LU3569"));
        }
    	return alumnos;
    }
    
    public static void agregarAlumno(Alumno alumno) {
    	alumnos.add(alumno);
    }
    public static Alumno buscarAlumnos(String lu) {
    	for(Alumno i: alumnos) {
    		if(i.getLu().equals(lu)) {
    			return i;
    		}
    	}
    	return null;
    }
    public static void modificarAlumno(Alumno alumno) {
   	 for(Alumno i: alumnos) {
   		 if(i.getLu().equalsIgnoreCase(alumno.getLu())) {
   			 i.setNombre(alumno.getNombre());
   			 i.setApellido(alumno.getApellido());
   			 i.setDni(alumno.getDni());
   			 i.setEmail(alumno.getEmail());
   			 i.setTelefono(alumno.getTelefono());
   			 i.setFechaNacimiento(alumno.getFechaNacimiento());
   			 i.setDomicilio(alumno.getDomicilio());
   		 }else {
   			 System.out.println("Docente no encontrado");
   		 }
   	 }
    }
    public static void borrarAlumnos(String lu) {
    	Iterator<Alumno> iterator = alumnos.iterator();
    	while(iterator.hasNext()) {
    		Alumno alumno = iterator.next();
            if (alumno.getLu().equals(lu)) {
                iterator.remove();
                break;
            }
    	}
    }
}
