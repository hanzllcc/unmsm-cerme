package cu.certificados.cerme.mapper;

import java.util.List;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteDetalleResultadoAlumno;
import cu.certificados.cerme.model.reporte.ReporteDetalleResultadoAlumnoRegular;

public interface IReporteDetalleMapper
{
    public List<ReporteDetalleResultadoAlumnoRegular> buscarResultadoExamenMedicoRegular(
            CriterioBusquedaReporteDetalleResultadoAlumno criterioBusquedaReporteDetalleResultadoAlumno);
}