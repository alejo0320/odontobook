package edu.austral.lab1.odontobook.graphicInterface;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import edu.austral.lab1.odontobook.controler.ActionManager;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;;
public class MenuBar {
	private JMenuBar menuBar;

	public MenuBar(ActionManager am,GraphicInterface graphicInteface){
		menuBar = new JMenuBar();
		// Creo los Menus el cual contiene varios submenues que a su vez van a
		// contener varios mas.
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu newFile = new JMenu("New");
		JMenu patient = new JMenu("Paciente");
		JMenu doctor = new JMenu("Doctor");
		JMenuItem exit = new JMenuItem("exit");
		



		// Creo los items que van a ir debajo del Menu Editar.
		JMenuItem editCut = new JMenuItem(/*LanguageProperties.getProperty*/("cut"));
		JMenuItem editCopy = new JMenuItem(/*LanguageProperties.getProperty*/("copy"));
		JMenuItem editPaste = new JMenuItem(/*LanguageProperties.getProperty*/("paste"));


		// Agrego los elementos que van debajo en el Menu de Archivo.
		
		file.add(newFile);
		file.add(exit);


		//mnuArchivo.add(mnuGuardarComo);
		// Agrego los elementos que van debajo en el Menu de Editar.
		edit.add(editCut);
		edit.add(editCopy);
		edit.add(editPaste);


		// Agrego los elementos que van a ir a la derecha del Menu Nuevo.
		
		
		doctor.add(am.getNewDoctor());
		doctor.add(am.getModificarDoctor());
		doctor.add(am.getDeleteDoctorAction());
		
		patient.add(am.getNewPaciente());
		patient.add(am.getModificarPacienteAction());
		patient.add(am.getNewHistograma());
		patient.add(am.getOdontogramaAction());


		// Agrego los menues principales a la Barra de Menu
      
		menuBar.add(file); // Toma un tipo JMenu.
		menuBar.add(edit); // Tomah un tipo JMenu.
		menuBar.add(doctor);
		menuBar.add(patient); // Tomah un tipo JMenu.



		graphicInteface.getFrame().setJMenuBar(menuBar);
	}
}

