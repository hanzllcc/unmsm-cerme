package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteDetalleResultadoAlumno;
import cu.certificados.cerme.model.reporte.ReporteDetalleResultadoAlumnoRegular;

public interface IReporteDetalleService
{
    public List<ReporteDetalleResultadoAlumnoRegular> buscarResultadoExamenMedicoRegular(
            CriterioBusquedaReporteDetalleResultadoAlumno criterioBusquedaReporteDetalleResultadoAlumno);
}