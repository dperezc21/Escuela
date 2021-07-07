package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Alumno;
import com.cmc.servicios.CentroEducativo;

public class TestCalificar {

	public static void main(String[] args) {
		CentroEducativo centroEducativo=new CentroEducativo();
		centroEducativo.agregarMateria("MATE", 6);
		centroEducativo.agregarMateria("CIENCIAS", 4);
		centroEducativo.agregarMateria("HISTORIA", 5);

		centroEducativo.matricular(new Alumno("1714616123", "Roberto", "Gomez"));
		centroEducativo.matricular(new Alumno("1714616108", "Martina", "Rosales"));
		centroEducativo.matricular(new Alumno("1714616147", "Bertha", "Cabral"));
		

		centroEducativo.asignarMateria("CEC", "1714616147");
		centroEducativo.asignarMateria("CEC", "1714616123");
		centroEducativo.asignarMateria("CEC", "1714616333");
		
		centroEducativo.asignarMateria("HSO", "1714616147");
		
		centroEducativo.asignarMateria("MAT", "1714616147");
		
		centroEducativo.calificar("CEC", "1714616147", 8);
		centroEducativo.calificar("CEC", "1714616147", 12);
		centroEducativo.calificar("CEC", "1714616147", 10);
		centroEducativo.calificar("CEC", "1714616147", 0);
		
		
		Alumno alumno=centroEducativo.buscar("1714616147");
		System.out.println("Notas ingresadas al alumno:"+alumno.getNotas().size());

	}

}
