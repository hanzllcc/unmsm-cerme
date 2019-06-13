package cu.certificados.cerme.service;

import cu.certificados.cerme.model.movimiento.ExamenMedicoTriaje;

public interface IExamenMedicoTriajeService extends IMantenibleService<ExamenMedicoTriaje>
{ 
	public void registrarExamenMedicoTriaje(ExamenMedicoTriaje examenMedicoTriaje);
}
