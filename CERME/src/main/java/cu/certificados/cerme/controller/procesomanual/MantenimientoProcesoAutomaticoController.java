package cu.certificados.cerme.controller.procesomanual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.certificados.cerme.service.ICampaniaService;
import cu.certificados.cerme.service.IFacultadService;
import cu.certificados.cerme.service.IMultiTabDetService;
import cu.certificados.cerme.utilitario.MultiTablaUtil;

@RequestMapping("/mantenimiento")
public @Controller class MantenimientoProcesoAutomaticoController
{
    private @Autowired ICampaniaService campaniaService;
    private @Autowired IFacultadService facultadService;
    private @Autowired IMultiTabDetService multiTabDetService;

    @GetMapping("/{mantenimiento:procesoAutomatico}")
    public String irPaginaMantenimientoProcesoAutomatico(@PathVariable String mantenimiento,
            ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("campanias", campaniaService.buscarTodos());
        model.addAttribute("destinosEnvio",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_DESTINO_ENVIO));
        model.addAttribute("facultades", facultadService.buscarTodos());
        return "seguras/mantenimiento/mantenimiento";
    }
}