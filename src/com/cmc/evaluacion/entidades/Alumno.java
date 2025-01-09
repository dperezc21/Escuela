package com.cmc.evaluacion.entidades;

import java.util.ArrayList;

public class Alumno {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Materia> materias;
	private ArrayList<Nota> nota;
	
	public Alumno(){
		materias = new ArrayList<Materia>();
		nota = new ArrayList<Nota>();
	}
	public Alumno(String cedula, String nombre, String apellido) {
		nota = new ArrayList<Nota>();
		materias = new ArrayList<Materia>();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Materia buscarMateria(String codigoMateria){
		return this.materias.stream()
				.filter(t -> t.getCodigo().equals(codigoMateria)).findFirst().orElse(null);
	}
	
	
	public void agregarMateria(Materia materia){
		Materia m = buscarMateria(materia.getCodigo());
		if(m == null) this.materias.add(materia);
		
	}
    
            
    public void calificar(String codigoMateria, int calificacion){
        Materia materiaEstudiante = buscarMateria(codigoMateria);
        if(materiaEstudiante != null && materiaEstudiante.getCodigo().equals(codigoMateria)) {
            Nota n = new Nota(materiaEstudiante,calificacion);
            this.nota.add(n);
        }
        
    }

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	public ArrayList<Nota> getNotas() {
		return nota;
	}
	public void setNota(ArrayList<Nota> nota) {
		this.nota = nota;
	}
	
}
