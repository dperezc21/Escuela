package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Alumno;
import com.cmc.servicios.CentroEducativo;

public class TestBuscarAlumno {

	public static void main(String[] args) {
		CentroEducativo centroEducativo=new CentroEducativo();
		Alumno a1=centroEducativo.buscarAlumno("123");
		System.out.println(a1);
		
		centroEducativo.matricular(new Alumno("1714616123", "Roberto", "Gomez"));
		centroEducativo.matricular(new Alumno("1714616109", "Teresa", "Ronquillo"));
		
		Alumno a2=centroEducativo.buscarAlumno("1714616109");
		System.out.println(a2.getNombre()+" "+a2.getApellido());

	}

}
