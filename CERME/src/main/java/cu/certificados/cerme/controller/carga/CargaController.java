package cu.certificados.cerme.controller.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.IMultiTabDetService;
import cu.certificados.cerme.utilitario.MultiTablaUtil;

@Vista
public @Controller class CargaController
{
    private @Autowired IMultiTabDetService multiTabDetService;

    @GetMapping("/carga/alumno")
    public String irPaginaCargaAlumno(ModelMap model)
    {
        model.addAttribute("tiposAlumno",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_TIPO_ALUMNO));
        return "seguras/carga/alumno";
    }
}