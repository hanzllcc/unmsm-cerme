package cu.certificados.cerme.controller.reporte.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteDetalleResultadoAlumno;
import cu.certificados.cerme.model.reporte.ReporteDetalleResultadoAlumnoRegular;
import cu.certificados.cerme.service.IReporteDetalleService;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.utilitario.ValidatorUtil;

@RequestMapping("/reporte/detalle")
public @RestController class ReporteDetalleResultadoExamenMedicoRestController
{
    private @Autowired IReporteDetalleService reporteDetalleService;

    @GetMapping(value = "/resultado/examenMedico/regular", params = "accion=buscar")
    public List<ReporteDetalleResultadoAlumnoRegular> buscarResultadoExamenMedicoRegular(
            @Validated CriterioBusquedaReporteDetalleResultadoAlumno criterioBusquedaReporteDetalleResultadoAlumno,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        return reporteDetalleService
                .buscarResultadoExamenMedicoRegular(criterioBusquedaReporteDetalleResultadoAlumno);
    }
}