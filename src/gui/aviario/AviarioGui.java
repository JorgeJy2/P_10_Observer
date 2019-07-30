package gui.aviario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ave.Ave;

public class AviarioGui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final String TITLE_NAME = "Aviario";
	private static final String TEXT_NAME = "Nombre:";
	private static final String TEXT_EXTRA = "Información:";
	private static final String TEXT_ACTION = "Moverse:";
	private static final String TEXT_IMAGE = "Imagen:";
	
	private static final String TEXT_NEXT = "Siguiente";
	private static final String TEXT_BEFORE = "Anterior";
	private static final String TEXT_ACTION_VIEW = "Acción";
	
	private static final Font FONT_TEXT= new Font("Console", Font.PLAIN, 15);
	
	private JLabel lbNombre;
	private JLabel lbInfo;
	private JLabel lbTitle;
	private JLabel lbImg;
	private JLabel lbAction;

	private JLabel lbTextAction;
	private JLabel lbTextNombre;
	private JLabel lbTextInfo;
	private JLabel lbTextImage;
	
	private JPanel mPanel;
	private JPanel pContenido;

	private JButton btnNext;
	private JButton btnBefore;
	private JButton btnAction;
	
	private ControllerAviario controllerAviario;
	
	public AviarioGui() {
		controllerAviario = new ControllerAviario (this);
		createGUI();
	}
	
	private void createGUI() {
		mPanel = new JPanel();
		mPanel.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
		mPanel.setLayout(new BorderLayout());
		
		lbTitle = new JLabel(TITLE_NAME,JLabel.CENTER);
		
		mPanel.add(lbTitle,BorderLayout.NORTH);
		
		pContenido = new JPanel();
		pContenido.setLayout(new GridLayout(0,2));
		
		lbTextNombre = new JLabel(TEXT_NAME, JLabel.CENTER);
		lbTextNombre.setFont(FONT_TEXT);
		lbTextInfo	 = new JLabel(TEXT_EXTRA, JLabel.CENTER);
		lbTextInfo.setFont(FONT_TEXT);
		lbTextAction = new JLabel(TEXT_ACTION, JLabel.CENTER);
		lbTextAction.setFont(FONT_TEXT);
		lbTextImage	 = new JLabel(TEXT_IMAGE, JLabel.CENTER); 
		lbTextImage.setFont(FONT_TEXT);
		
		lbNombre = new JLabel();
		lbNombre.setFont(FONT_TEXT);
		lbAction = new JLabel();
		lbAction.setFont(FONT_TEXT);
		lbInfo	 = new JLabel();
		lbInfo.setFont(FONT_TEXT);
		lbImg 	 = new JLabel();
		
		pContenido.add(lbTextNombre);
		pContenido.add(lbNombre);
		pContenido.add(lbTextInfo);
		pContenido.add(lbInfo);
		pContenido.add(lbTextAction);
		pContenido.add(lbAction);
		pContenido.add(lbTextImage);
		pContenido.add(lbImg);
		
		mPanel.add(pContenido,BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel();
		
		btnBefore = new JButton(TEXT_BEFORE);
		btnNext = new JButton(TEXT_NEXT);
		btnAction = new JButton(TEXT_ACTION_VIEW);
		btnAction.setEnabled(false);
		btnBefore.addActionListener(controllerAviario);
		btnNext.addActionListener(controllerAviario);
		btnAction.addActionListener(controllerAviario);
		
		panelButtons.add(btnBefore);
		panelButtons.add(btnNext);
		panelButtons.add(btnAction);

		mPanel.add(panelButtons, BorderLayout.SOUTH);
		
		this.add(mPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public void polimorfismoAve(Ave ave) {
		ave.moverse();
		lbNombre.setText(ave.queSoy());
		lbInfo.setText(ave.toString());
		lbAction.setText(ave.moverse());
		lbImg.setIcon(ave.getImagenIcon());
		this.pack(); //Redimenciona la pantalla 
		this.setLocationRelativeTo(null);
	}
	
	public void mostrarNuevoPeso(String informacion) {
		lbInfo.setText(informacion);
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnBefore() {
		return btnBefore;
	}

	public JButton getBtnAction() {
		return btnAction;
	}

}
