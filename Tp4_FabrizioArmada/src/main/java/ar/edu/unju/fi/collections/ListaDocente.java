package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListaDocente {
   private static List<Docente> docentes = new ArrayList<>();
   
    public static List<Docente> listarDocentes(){
    	if(docentes.isEmpty()) {
    		docentes.add(new Docente("D1", "Gabriel", "Palacios", "GabPalacios@gmail.com", "457-8966476"));
    		docentes.add(new Docente("D2", "Paulo", "Diaz", "PDiaz@gmail.com", "457-7824563"));
    		docentes.add(new Docente("D3", "Pepe", "Castilo", "castiPepe@gmail.com", "457-2130457"));
    		docentes.add(new Docente("D4", "Homero", "Simpson", "homerSimpson@gmail.com", "457-6534157"));
    		docentes.add(new Docente("D5", "romina", "Arias", "RomArias@gmail.com", "457-4578102"));
    		docentes.add(new Docente("D6", "Luicia", "jepeto", "jepeLucia@gmail.com", "457-5760110"));
    	}
    	return docentes;
    }
    public static void agregarDocente(Docente docente) {
    	docentes.add(docente);
    }
    public static Docente buscarDocentes(String legajo) {
    	for(Docente i: docentes) {
    		if(i.getLegajo().equals(legajo)) {
    			return i;
    		}
    	}
    	return null;
    }
    
    public static void eliminarDocente(String legajo) {
      Iterator<Docente> iterator = docentes.iterator();
       while(iterator.hasNext()){
    	   Docente docente = iterator.next();
    	   if(docente.getLegajo().equals(legajo)) {
    		   iterator.remove();
    	   }
       }
    }
     public static void modificarDocente(Docente docente) {
    	 for(Docente i: docentes) {
    		 if(i.getLegajo().equalsIgnoreCase(docente.getLegajo())) {
    			 i.setNombre(docente.getNombre());
    			 i.setApellido(docente.getApellido());
    			 i.setEmail(docente.getEmail());
    			 i.setTelefono(docente.getTelefono());
    		 }else {
    			 System.out.println("Docente no encontrado");
    		 }
    	 }
     }
}
