package com.cmc.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Alumno;
import com.cmc.evaluacion.entidades.Materia;
import com.cmc.evaluacion.entidades.Nota;

public class CentroEducativo {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;

	public CentroEducativo() {
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
	}

	public int obtenerCantidadAlumnos() {
		return this.alumnos.size();
	}

	public Alumno buscarAlumno(String cedulaAlumno) {
		if (this.alumnos.size() == 0) return null;
		return this.alumnos.stream().filter(alumno -> alumno.getCedula().equals(cedulaAlumno)).findFirst().orElse(null);
	}

	public boolean matricular(Alumno alumno) {
		Alumno alumnoEncontrado = buscarAlumno(alumno.getCedula());
		if(alumnoEncontrado != null) return false;
		
		this.alumnos.add(alumno);
		return true;
	}

	public void actualizarInformacion(Alumno alumno) {
		Alumno buscarAlumno = buscarAlumno(alumno.getCedula());

		if (buscarAlumno != null) {
			buscarAlumno.setNombre(alumno.getNombre());
			buscarAlumno.setApellido(alumno.getApellido());
		}
	}

	public void imprimirMatriculados() {
		Alumno a;
		for (int i = 0; i < this.alumnos.size(); i++) {
			a = this.alumnos.get(i);
			System.out.println(a.getCedula() + " " + a.getNombre() + " " + a.getApellido());
		}
	}

	public String generarCodigo(String nombreMateria) {
		String codigo = "";
		if(nombreMateria.length() < 2) return null;
		
		if (nombreMateria.length() >= 5) {
			codigo = nombreMateria.substring(0, 1) + nombreMateria.substring(2, 3) + nombreMateria.substring(4, 5);
		} else codigo = nombreMateria.substring(0, 3);
		
		return codigo;

	}

	public void agregarMateria(String nombreMateria, int minimoEstudiantes) {

		Materia m = new Materia(nombreMateria, generarCodigo(nombreMateria), minimoEstudiantes * 3, minimoEstudiantes);

		this.materias.add(m);

	}

	public Materia buscarMateria(String codigoMateria) {
		Materia m;
		for (int i = 0; i < this.materias.size(); i++) {
			m = this.materias.get(i);
			if (m.getCodigo().equals(codigoMateria)) {
				return m;
			}
		}
		return null;
	}

	public void asignarMateria(String codigoMateria, String cedulaAlumno) {

		Alumno alumnoEncontrado = buscarAlumno(cedulaAlumno);
		Materia materia = buscarMateria(codigoMateria);

		if (alumnoEncontrado != null && materia != null) {
			if (materia.getNumeroAlumnos() < materia.getMaximoAlumnos()) {
				materia.setNumeroAlumnos(1);
				alumnoEncontrado.agregarMateria(materia);
				// System.out.println("total de alumnos permitidos
				// "+materia.getMaximoAlumnos()+" en "+materia.getNombre());
			}

		}

	}

	public void calificar(String codigoMateria, String cedulaAlumno, int calificacion) {

		if (calificacion >= 0 && calificacion <= 10) {
			Alumno alumno = buscarAlumno(cedulaAlumno);
			alumno.calificar(codigoMateria, calificacion);
		} else {
			System.out.println("Nota fuera de rango.");
		}

	}

	public ArrayList<Nota> obtenerNotasMateria(String cedulaAlumno, String codigoMateria) {
		ArrayList<Nota> notas = new ArrayList<Nota>();
		Alumno alumno = buscarAlumno(cedulaAlumno);
		// Materia materia = alumno.buscarMateria(codigoMateria);

		for (int i = 0; i < alumno.getNotas().size(); i++) {
			if (alumno.getNotas().get(i).getMateria().getCodigo().equals(codigoMateria)) {
				notas.add(alumno.getNotas().get(i));
			}
		}
		return notas;

	}

	public double obtenerPromedio(String cedulaAlumno, String codigoMateria) {
		ArrayList<Nota> notas = obtenerNotasMateria(cedulaAlumno, codigoMateria);
		double promedio = 0;
		double suma = 0;
		for (int i = 0; i < notas.size(); i++) {
			suma += notas.get(i).getValor();
		}
		promedio = suma / notas.size();

		return promedio;
	}

	public ArrayList<Materia> reporteIncompletos() {
		ArrayList<Materia> listMaterias = new ArrayList<Materia>();
		Materia materia;
		for (int i = 0; i < this.materias.size(); i++) {
			materia = this.materias.get(i);
			if (materia.getNumeroAlumnos() < materia.getMinimoAlumnos()) {
				listMaterias.add(materia);
			}
		}
		return listMaterias;
	}

	public void listarMaterias() {
		Materia m;
		for (int i = 0; i < this.materias.size(); i++) {
			m = this.materias.get(i);
			System.out.println("*** " + m.getCodigo() + " " + m.getNombre() + " ***" + "\nalumnos: max>>"
					+ m.getMaximoAlumnos() + " min>>" + m.getMinimoAlumnos() + " Actual: " + m.getNumeroAlumnos());
		}
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	/*
	 * public static void main(String[] args) { CentroEducativo
	 * centroEducativo=new CentroEducativo();
	 * centroEducativo.agregarMateria("MATE", 6);
	 * centroEducativo.agregarMateria("CIENCIAS", 4);
	 * centroEducativo.agregarMateria("HISTORIA", 5);
	 * 
	 * centroEducativo.matricular(new Alumno("1714616123", "Roberto", "Gomez"));
	 * centroEducativo.matricular(new Alumno("1714616108", "Martina",
	 * "Rosales")); centroEducativo.matricular(new Alumno("1714616147",
	 * "Bertha", "Cabral")); centroEducativo.imprimirMatriculados();
	 * centroEducativo.listarMaterias();
	 * 
	 * ArrayList<String> n = new ArrayList<String>(); n.add("d");
	 * System.out.println(n.size()); }
	 */

}
