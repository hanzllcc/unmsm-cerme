package cu.certificados.cerme.controller.reporte.exportacion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteExamenMedico;
import cu.certificados.cerme.service.IMedicoService;
import cu.certificados.cerme.service.IReporteExamenMedicoService;
import cu.certificados.cerme.utilitario.ConstantesGenerales;

@Vista
@RequestMapping("reporte/examenMedico")
public @Controller class ReporteExamenMedicoExportacionController
{
    private @Autowired IMedicoService medicoService;
    private @Autowired IReporteExamenMedicoService reporteExamenMedicoService;

    @GetMapping(params = "accion=exportarRegular")
    public ModelAndView descargarReporteExamenMedicoRegular(ModelMap model,
            ModelAndView modelAndView,
            CriterioBusquedaReporteExamenMedico criterioBusquedaReporteExamenMedico)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("reporte", reporteExamenMedicoService
                .buscarReporteExamenMedicoRegular(criterioBusquedaReporteExamenMedico));
        params.put("medico", medicoService.buscarDirector());
        params.put("fechaGeneracion", new Date());
        model.addAttribute(ConstantesGenerales.PARAM_REPORTE_PARAMETERS, params);
        model.addAttribute(ConstantesGenerales.PARAM_TEMPLATE, "reporteCertificadoMedico");
        model.addAttribute(ConstantesGenerales.PARAM_NOMBRE_REPORTE,
                "Reporte de Certificado Médico");
        modelAndView = new ModelAndView("xdocView", model);
        return modelAndView;
    }
}