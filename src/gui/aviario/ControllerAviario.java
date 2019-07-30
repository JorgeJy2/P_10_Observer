package gui.aviario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AnimalChangeObservable;
import gui.Cambiable;
import gui.actionAviario.ActionAviarioGui;

import model.ModelAviario;

public class ControllerAviario  implements ActionListener,Cambiable{

	private AviarioGui _view;
	private int _contadorVista = -1;
	private ModelAviario _ModelAviario;
	private ActionAviarioGui actionAviarioGui;
	
	private AnimalChangeObservable changeObservable;
	
	public ControllerAviario(AviarioGui aviarioGui) {
		_view = aviarioGui;
		_ModelAviario = ModelAviario.getInstance();
		changeObservable = new AnimalChangeObservable();
		changeObservable.addObserver("Animal", this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource()  == _view.getBtnAction()) {
			System.out.println("Contador  "+_contadorVista);
			actionAviarioGui =  new ActionAviarioGui(_contadorVista);
			changeObservable.addObserver(actionAviarioGui.toString(), actionAviarioGui);
			actionAviarioGui.setAnimalChangeObservable(changeObservable);
		}else if(arg0.getSource()  == _view.getBtnBefore()) {
			
			if(_contadorVista <= 0)
				_contadorVista = _ModelAviario.contadorAves() -1;
			else
				_contadorVista--;
			changeObservable.notificarCambioAnimal(_contadorVista);
			_view.polimorfismoAve(_ModelAviario.getAve(_contadorVista));
			_view.getBtnAction().setEnabled(true);
			
		}else if(arg0.getSource()  == _view.getBtnNext()) {
			if(_contadorVista >= _ModelAviario.contadorAves() -1)
				_contadorVista = 0;
			else
				_contadorVista++;
			changeObservable.notificarCambioAnimal(_contadorVista);
			_view.polimorfismoAve(_ModelAviario.getAve(_contadorVista));
			_view.getBtnAction().setEnabled(true);
		}
	}
	
	@Override
	public void changeAnimal(int  positon) {
	}

	@Override
	public void changeInfo(String info) {
		_view.mostrarNuevoPeso(info);
	}
}
