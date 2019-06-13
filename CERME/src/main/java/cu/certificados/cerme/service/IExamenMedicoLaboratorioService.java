package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.movimiento.ExamenMedicoLaboratorio;

public interface IExamenMedicoLaboratorioService extends IMantenibleService<ExamenMedicoLaboratorio>
{
    public int generarNumeroRegistro(ExamenMedicoLaboratorio examenMedicoLaboratorio);

    public List<ExamenMedicoLaboratorio> buscarPorEstadoExamenMedico(String idEstadoExamenMedico);

    public List<ExamenMedicoLaboratorio> buscarResultadoRegularPorNumeroRegistroAnio(
            Integer numeroRegistro, String anio);
    
    public List<ExamenMedicoLaboratorio> buscarResultadoIngresantePorNumeroRegistroAnio(
            Integer numeroRegistro, String anio);

    public void registrarExamenMedicoRegularLaboratorio(
            ExamenMedicoLaboratorio examenMedicoLaboratorio);

    public void registrarExamenMedicoIngresanteLaboratorio(
            ExamenMedicoLaboratorio examenMedicoLaboratorio);

    public boolean existeExamenMedicoLaboratorio(Integer numeroRegistro, String anio);
}