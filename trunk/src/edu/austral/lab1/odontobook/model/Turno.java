package edu.austral.lab1.odontobook.model;

public class Turno {
	
	private Fecha fecha;
	private Hora hora;
	private boolean asistido;
	
	public Turno(Fecha fecha, Hora hora){
		this.fecha = fecha;
		this.hora = hora;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public boolean isAsistido() {
		return asistido;
	}

	public void setAsistido(boolean asistido) {
		this.asistido = asistido;
	}

}
