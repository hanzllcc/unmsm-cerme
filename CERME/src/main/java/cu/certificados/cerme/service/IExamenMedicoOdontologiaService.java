package cu.certificados.cerme.service;

import cu.certificados.cerme.model.movimiento.ExamenMedicoOdontologico;

public interface IExamenMedicoOdontologiaService extends IMantenibleService<ExamenMedicoOdontologico>
{
	public void registrarExamenMedicoOdontologico (ExamenMedicoOdontologico examenMedicoOdontologico);
}
