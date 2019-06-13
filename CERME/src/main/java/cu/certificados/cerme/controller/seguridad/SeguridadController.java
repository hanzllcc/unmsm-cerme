package cu.certificados.cerme.controller.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.certificados.cerme.aspecto.anotacion.Audit;
import cu.certificados.cerme.aspecto.enumeracion.Accion;
import cu.certificados.cerme.aspecto.enumeracion.Comentario;
import cu.certificados.cerme.aspecto.enumeracion.Tipo;
import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.IMultiTabDetService;
import cu.certificados.cerme.service.IPerfilService;
import cu.certificados.cerme.service.IPersonaService;
import cu.certificados.cerme.service.ITipoAuditoriaService;
import cu.certificados.cerme.service.IUsuarioService;
import cu.certificados.cerme.utilitario.MultiTablaUtil;

@Vista
@Audit(accion = Accion.Visita, comentario = Comentario.Visita)
@RequestMapping("/seguridad")
public @Controller class SeguridadController
{
    private @Autowired IPerfilService perfilService;
    private @Autowired IPersonaService personaService;
    private @Autowired IUsuarioService usuarioService;
    private @Autowired IMultiTabDetService multiTabDetService;
    private @Autowired ITipoAuditoriaService tipoAuditoriaService;

    @Audit(tipo = Tipo.Usu)
    @GetMapping(value = "/{mantenimiento:usuario}")
    public String irPaginaMantenimientoUsuario(@PathVariable String mantenimiento, Model model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("perfiles", perfilService.buscarTodos());
        model.addAttribute("personas", personaService.buscarTodos());
        return "seguras/seguridad/mantenimiento";
    }

    @GetMapping(value = "/auditoria")
    public String irPaginaConsultaAuditoria(Model model)
    {
        model.addAttribute("usuarios", usuarioService.buscarTodos());
        model.addAttribute("tiposAuditoria", tipoAuditoriaService.buscarTodos());
        model.addAttribute("accionesAuditoria",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_ACCION_AUDITORIA));
        return "seguras/auditoria/auditoria";
    }
}