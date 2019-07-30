package gui.actionAviario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelAviario;

public class ControllActionAviario implements ActionListener {

	ActionAviarioGui _view;
	ModelAviario _model;
	
	private int position = -1;
	
	public ControllActionAviario(ActionAviarioGui actionAviarioGui) {
		_view = actionAviarioGui;
		_model = ModelAviario.getInstance();
	}
	
	public void loadInfoAve(int position) {
		this.position = position;
		_view.polimorfismoAve(_model.getAve(position));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		_model.getAve(position).alimentar();
		//_view.polimorfismoAve(_model.getAve(position));
		//changeObserver.notificarCambioAnimal(position);
		_view.notificarCambioInformacion(_model.getAve(position).toString());
		_view.showMessage("La ave "+ _model.getAve(position).queSoy() + " se ha alimentado al animal.");	
	}

	
}
