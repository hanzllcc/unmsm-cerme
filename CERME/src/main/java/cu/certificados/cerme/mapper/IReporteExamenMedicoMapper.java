package cu.certificados.cerme.mapper;

import java.util.List;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteExamenMedico;
import cu.certificados.cerme.model.reporte.ReporteExamenMedicoRegular;

public interface IReporteExamenMedicoMapper
{
    public List<ReporteExamenMedicoRegular> buscarReporteExamenMedicoRegular(
            CriterioBusquedaReporteExamenMedico criterioBusquedaReporteExamenMedico);
}