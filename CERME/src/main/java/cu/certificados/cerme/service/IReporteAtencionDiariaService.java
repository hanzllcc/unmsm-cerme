package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteAtencionDiaria;
import cu.certificados.cerme.model.reporte.ReporteAtencionDiaria;

public interface IReporteAtencionDiariaService
{
    public List<ReporteAtencionDiaria> buscarAtencionesDiarias(
            CriterioBusquedaReporteAtencionDiaria criterioBusquedaReporteAtencionDiaria);
}