package cu.certificados.cerme.service;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteExamenMedico;
import cu.certificados.cerme.model.reporte.ReporteExamenMedicoRegular;

public interface IReporteExamenMedicoService
{
    public ReporteExamenMedicoRegular buscarReporteExamenMedicoRegular(
            CriterioBusquedaReporteExamenMedico criterioBusquedaReporteExamenMedico);
}