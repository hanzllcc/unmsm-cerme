package cu.certificados.cerme.mapper;

import java.util.List;

import cu.certificados.cerme.model.consulta.administrativa.ConsultaLaboratorioAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoLaboratorio;

public interface IConsultaExamenMedicoLaboratorioMapper
{
    public List<ConsultaLaboratorioAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusquedaAdministrativaExamenMedicoLaboratorio);
}