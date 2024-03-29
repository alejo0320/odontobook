package edu.austral.lab1.odontobook.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Turno;

public class TurnoDao extends BaseDao{


	private List<Turno> turnos;

	public List<Turno> getTurnoByDate(Date date){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.fecha = ? ")
					.setDate(0, date);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		
		return turnos;

	}

	public List<Turno> getTurnoByPaciente(long paciente_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.paciente = ?")
					.setLong(0, paciente_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		return turnos;

	}
	
	public void removeTurno(long pacienteId,Date date,int hora,int minutos, long doctorId){
//		turnos = getAll();
		List<Turno> turnos= getTurnoByDateAndPaciente(date,pacienteId);
		System.out.println("intenta");
		for(int i=0;i<turnos.size();i++){
			System.out.println("en for");
			if((( turnos.get(i)).getHora()==hora)&&(( turnos.get(i)).getMinutos()==minutos && turnos.get(i).getDoctor().getId()==doctorId )){
				System.out.println("entro");
				HibernateUtil.beginTransaction();
				HibernateUtil.getSession().delete(turnos.get(i));
				HibernateUtil.commitTransaction();
			}
		}
		
		
	}
	
	public void sacarTurno(Turno turno){
		HibernateUtil.beginTransaction();
		makePersistent(turno);
		
		HibernateUtil.commitTransaction();
		
		
	}


	
	
	
	public List<Turno> getTurnoByDateAndPaciente(Date date, long paciente_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.fecha = ? and turn.paciente = ?")
					.setDate(0, date).setLong(1, paciente_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		
		return turnos;

	}
	
	public List<Turno> getTurnoByDoctor(long doctor_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.doctor = ?")
					.setLong(0, doctor_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		return turnos;

	}

	
	public void removeTurnobyPaciente(Long pacienteId,Date date,int hora,int minutos){

		List turnos= getTurnoByDateAndPaciente(date,pacienteId);
		for(int i=0;i<turnos.size();i++){
			if((((Turno) turnos.get(i)).getHora()==hora)||(((Turno) turnos.get(i)).getMinutos()==minutos)){
				HibernateUtil.getSession().delete(turnos.get(i));
				HibernateUtil.commitTransaction();
			}
		}
		
		
	}
	
	public void removeTurnobyDoctor(long doctorId){

		List turnos= getTurnoByDoctor(doctorId);
		for(int i=0;i<turnos.size();i++){
				HibernateUtil.getSession().delete(turnos.get(i));
				HibernateUtil.commitTransaction();
			}
		}
		
		
	


	public List<Turno> getTurnoByDateAndDoctor(Date date, long doctor_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
			"from Turno as turn where turn.fecha = ? and turn.doctor = ?")
			.setDate(0, date).setLong(1, doctor_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}

		return turnos;

	}

	public List getPersonas(){
		return HibernateUtil.getSession().createCriteria(Turno.class).list();
	}

	public static List getAll(){
		return new TurnoDao().getPersonas();
	}


}
