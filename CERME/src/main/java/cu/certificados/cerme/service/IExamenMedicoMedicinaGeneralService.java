package cu.certificados.cerme.service;

import cu.certificados.cerme.model.movimiento.ExamenMedicoMedicinaGeneral;

public interface IExamenMedicoMedicinaGeneralService
        extends IMantenibleService<ExamenMedicoMedicinaGeneral>
{
    public void registrarExamenMedicoMedicinaGeneral(
            ExamenMedicoMedicinaGeneral examenMedicoMedicinaGeneral);

    public boolean existeExamenMedicoMedicinaGeneral(Integer numeroRegistro, String anio);
}