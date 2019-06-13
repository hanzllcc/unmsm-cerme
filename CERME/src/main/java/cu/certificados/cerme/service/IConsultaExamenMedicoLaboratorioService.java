package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.consulta.administrativa.ConsultaLaboratorioAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoLaboratorio;

public interface IConsultaExamenMedicoLaboratorioService
{
    public List<ConsultaLaboratorioAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusquedaAdministrativaExamenMedicoLaboratorio);
}