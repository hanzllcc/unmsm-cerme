package cu.certificados.cerme.service.impl.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IReporteAtencionDiariaMapper;
import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteAtencionDiaria;
import cu.certificados.cerme.model.reporte.ReporteAtencionDiaria;
import cu.certificados.cerme.service.IReporteAtencionDiariaService;
import cu.certificados.cerme.utilitario.StringsUtils;

@Service
public class ReporteAtencionDiariaService implements IReporteAtencionDiariaService
{
    private @Autowired IReporteAtencionDiariaMapper reporteAtencionDiariaMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ReporteAtencionDiaria> buscarAtencionesDiarias(
            CriterioBusquedaReporteAtencionDiaria criterioBusquedaReporteAtencionDiaria)
    {
        String verbo = StringsUtils.concatenarCadena(
                criterioBusquedaReporteAtencionDiaria.getIdTipoExamenMedico(), "_",
                criterioBusquedaReporteAtencionDiaria.getTipoReporte());
        criterioBusquedaReporteAtencionDiaria.setVerbo(verbo);
        return reporteAtencionDiariaMapper.buscarAtencionesDiarias(criterioBusquedaReporteAtencionDiaria);
    }
}
