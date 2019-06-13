package cu.certificados.cerme.service.impl.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IReporteDetalleMapper;
import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteDetalleResultadoAlumno;
import cu.certificados.cerme.model.reporte.ReporteDetalleResultadoAlumnoRegular;
import cu.certificados.cerme.service.IReporteDetalleService;

@Service
public class ReporteDetalleService implements IReporteDetalleService
{
    private @Autowired IReporteDetalleMapper reporteDetalleMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ReporteDetalleResultadoAlumnoRegular> buscarResultadoExamenMedicoRegular(
            CriterioBusquedaReporteDetalleResultadoAlumno criterioBusquedaReporteDetalleResultadoAlumno)
    {
        return reporteDetalleMapper
                .buscarResultadoExamenMedicoRegular(criterioBusquedaReporteDetalleResultadoAlumno);
    }
}