package cu.certificados.cerme.service.impl.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IReporteExamenMedicoMapper;
import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteExamenMedico;
import cu.certificados.cerme.model.reporte.ReporteExamenMedicoRegular;
import cu.certificados.cerme.service.IReporteExamenMedicoService;
import cu.certificados.cerme.service.excepcion.ValorNoEncontradoException;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;

@Service
public class ReporteExamenMedicoService implements IReporteExamenMedicoService
{
    private @Autowired IReporteExamenMedicoMapper reporteExamenMedicoMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ReporteExamenMedicoRegular buscarReporteExamenMedicoRegular(
            CriterioBusquedaReporteExamenMedico criterioBusquedaReporteExamenMedico)
    {
        List<ReporteExamenMedicoRegular> reportesExamenMedicoRegular = reporteExamenMedicoMapper
                .buscarReporteExamenMedicoRegular(criterioBusquedaReporteExamenMedico);
        if (reportesExamenMedicoRegular.isEmpty())
        {
            throw new ValorNoEncontradoException(
                    ConstantesExcepciones.NO_EXISTE_REPORTE_EXAMEN_MEDICO_REGULAR);
        }
        return reportesExamenMedicoRegular.get(0);
    }
}