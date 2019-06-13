package cu.certificados.cerme.controller.consulta;

import static cu.certificados.cerme.utilitario.ConstantesGenerales.PAGINA_CONSULTA_ATENCION_INICIAL;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_CAMPANIAS;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_CONSULTA;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_FACULTADES;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_REGISTRO_EN_ATENCION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.ICampaniaService;
import cu.certificados.cerme.service.IEspecialidadService;
import cu.certificados.cerme.service.IFacultadService;
import cu.certificados.cerme.service.IMultiTabDetService;
import cu.certificados.cerme.utilitario.MultiTablaUtil;

@Vista
@RequestMapping("/consulta/atencion")
public @Controller class ConsultaAtencionInicialController
{
    private @Autowired IFacultadService facultadService;
    private @Autowired ICampaniaService campaniaService;
    private @Autowired IMultiTabDetService multiTabDetService;
    private @Autowired IEspecialidadService especialidadService;

    @GetMapping("/{consulta:psicologia}")
    public String irPaginaConsultaAtencionInicialPsicologia(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_REGISTRO_EN_ATENCION, true);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        model.addAttribute("resultadosPsicologico",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_RESULTADO_PSICOLOGICO));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }

    @GetMapping("/{consulta:laboratorio}")
    public String irPaginaConsultaAtencionInicialLaboratorio(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }

    @GetMapping("/{consulta:radiologia}")
    public String irPaginaConsultaAtencionInicialRadiologia(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }

    @GetMapping("/{consulta:triaje}")
    public String irPaginaConsultaAtencionInicialTriaje(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_REGISTRO_EN_ATENCION, true);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }

    @GetMapping("/{consulta:odontologia}")
    public String irPaginaConsultaAtencionInicialOdontologia(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_REGISTRO_EN_ATENCION, true);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        model.addAttribute("higienes",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_HIGIENE));
        model.addAttribute("protesis",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_PROTESIS));
        model.addAttribute("maloclusiones",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_MALOCLUSION));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }

    @GetMapping("/{consulta:medicinaGeneral}")
    public String irPaginaConsultaAtencionInicialMedicinaGeneral(@PathVariable String consulta,
            ModelMap model)
    {
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute(P_REGISTRO_EN_ATENCION, true);
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute("especialidades", especialidadService.buscarTodos());
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarPorEstadoActivo(true));
        model.addAttribute("parentescos",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_TIPO_ANTECEDENTE));
        return PAGINA_CONSULTA_ATENCION_INICIAL;
    }
}