package ar.edu.unju.fi.collections;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public class ListaCarrera {

  private static List<Carrera> carreras = new ArrayList<Carrera>();
	
     public static List<Carrera> listarCarreras(){
    	 if(carreras.isEmpty()) {
    		 carreras.add(new Carrera(1, "APU.2008", (byte)3, true));
    		 carreras.add(new Carrera(2, "Ing.Informatica", (byte)5, true));
    		 carreras.add(new Carrera(3, "Ing.quimica", (byte)5, true));
    		 carreras.add(new Carrera(4, "Ing.industrial", (byte)5, true));
    		 carreras.add(new Carrera(5, "Ing.Minas", (byte)5, true));
    		 carreras.add(new Carrera(6, "Lic.Sistemas", (byte)5, true));
    	 }
    		 return carreras;
    	 
     }
     
     public static void agregarCarrera(Carrera carrera) {
    	 carreras.add(carrera);
     }
     
     public static Carrera buscarCarreras(int codigo) {
    	 for(Carrera i: carreras) {
    		 if(i.getCodigo()==codigo) {
    			 return i;
    		 }
    	 }
    	 return null;
     }
     
     public static void eliminarCarrera(int codigo) {
    	 Iterator<Carrera> iterator = carreras.iterator();
    	 while(iterator.hasNext()) {
    		 Carrera carrera = iterator.next();
    		 if(carrera.getCodigo()==codigo) {
    			 iterator.remove();
    		 }
    	 }
     }
     
     public static void modificarCarrera(Carrera carrera) {
    	 for(Carrera i: carreras) {
    		 if(i.getCodigo()==carrera.getCodigo()) {
    			 i.setNombre(carrera.getNombre());
    			 i.setCantidadAnios(carrera.getCantidadAnios());
    			 i.setEstado(carrera.isEstado());
    		 }else {
    			 System.out.println("Carrera no encontrada");
    		 }
    	 }
     }
}
