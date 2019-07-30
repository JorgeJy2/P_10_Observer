package gui.actionAviario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ave.Ave;
import gui.AnimalChangeObservable;
import gui.Cambiable;

public class ActionAviarioGui extends JFrame implements Cambiable{

	private static final long serialVersionUID = 1L;
	
	private JPanel jpMain;
	
	private static final String TITTLE ="Acci�n para una ave";

	private static final String TEXT_NAME = "Nombre:";
	private static final String TEXT_EXTRA = "Información:";
	private static final String TEXT_ALIMENTAR = "Alimentar ave";
	
	
	private static final Font FONT_TEXT= new Font("Console", Font.PLAIN, 15);
	
	private JLabel lbNombre;
	private JLabel lbInfo;

	private JLabel lbTextNombre;
	private JLabel lbTextInfo;
	private JLabel jlTittle;
	
	private JButton btnAlimentar;
	private ControllActionAviario _controller;
	
	private AnimalChangeObservable changeObserver;
	
	public ActionAviarioGui(int position) {
		_controller = new ControllActionAviario(this);
		createGui();
		_controller.loadInfoAve(position);
	}
	
	private void createGui() {
		this.setLayout(new BorderLayout());
		
		jlTittle  = new JLabel (TITTLE);
		
		this.add(jlTittle, BorderLayout.NORTH);
		
		jpMain = new JPanel();
		
		jpMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		jpMain.setLayout(new GridLayout(0,2));
		
		lbTextNombre = new JLabel(TEXT_NAME, JLabel.CENTER);
		lbTextNombre.setFont(FONT_TEXT);
		lbTextInfo	 = new JLabel(TEXT_EXTRA, JLabel.CENTER);
		lbTextInfo.setFont(FONT_TEXT);
		
		
		lbNombre = new JLabel();
		lbNombre.setFont(FONT_TEXT);
		lbInfo	 = new JLabel();
		lbInfo.setFont(FONT_TEXT);
		
		btnAlimentar = new JButton(TEXT_ALIMENTAR);
		btnAlimentar.addActionListener(_controller);
		jpMain.add(lbTextNombre);
		jpMain.add(lbNombre);
		jpMain.add(lbTextInfo);
		jpMain.add(lbInfo);
		jpMain.add(btnAlimentar);
		
		
		this.add(jpMain, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void polimorfismoAve(Ave ave) {
		lbNombre.setText(ave.queSoy());
		lbInfo.setText(ave.toString());
		this.pack();
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	@Override
	public void changeAnimal(int position) {
		_controller.loadInfoAve(position);
	}

	@Override
	public void changeInfo(String informacion) {
		lbInfo.setText(informacion);
		this.pack();
	}
	
	public void setAnimalChangeObservable(AnimalChangeObservable animalChangeObservable) {
		this.changeObserver = animalChangeObservable;
	}
	
	public void  notificarCambioInformacion(String info) {
		changeObserver.notificarCambioInfo(info);
	}
	
	
}
