package com.cmc.evaluacion.test;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Alumno;
import com.cmc.evaluacion.entidades.Materia;
import com.cmc.servicios.CentroEducativo;

public class TestAsignarMateria {

	public static void main(String[] args) {
		CentroEducativo centroEducativo=new CentroEducativo();
		centroEducativo.agregarMateria("MATE", 6);
		centroEducativo.agregarMateria("CIENCIAS", 4);
		centroEducativo.agregarMateria("HISTORIA", 5);

		centroEducativo.matricular(new Alumno("1714616123", "Roberto", "Gomez"));
		centroEducativo.matricular(new Alumno("1714616108", "Martina", "Rosales"));
		centroEducativo.matricular(new Alumno("1714616147", "Bertha", "Cabral"));
		centroEducativo.matricular(new Alumno("1714616100", "Bertha", "Cabral"));
		

		centroEducativo.asignarMateria("CEC", "1714616147");
		centroEducativo.asignarMateria("CEC", "1714616123");
		centroEducativo.asignarMateria("CEC", "1714616108");
		centroEducativo.asignarMateria("CEC", "1714616100");
		
		centroEducativo.asignarMateria("HSO", "1714616147");
		
		centroEducativo.asignarMateria("MAT", "1714616");
		
		centroEducativo.listarMaterias();
		
		Alumno alumno=centroEducativo.buscarAlumno("1714616147");
		ArrayList<Materia> materias=alumno.getMaterias();
		System.out.println("Materias del alumno 1714616147:"+materias.size());

	}

}
