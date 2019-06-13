package cu.certificados.cerme.controller.reporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.ICampaniaService;
import cu.certificados.cerme.service.IFacultadService;

@Vista
@RequestMapping("/reporte/detalle")
public @Controller class ReporteDetalleController
{
    private @Autowired IFacultadService facultadService;
    private @Autowired ICampaniaService campaniaService;

    @GetMapping("/resultado/examenMedico/{reporte:regular}")
    public String irPaginaReporteDetalleResultadoExamenMedicoRegular(ModelMap model,
            @PathVariable String reporte)
    {
        model.addAttribute("reporte", reporte);
        model.addAttribute("campanias", campaniaService.buscarTodos());
        model.addAttribute("facultades", facultadService.buscarTodos());
        return "seguras/reporte/reporteDetalleResultadoExamenMedico";
    }
}