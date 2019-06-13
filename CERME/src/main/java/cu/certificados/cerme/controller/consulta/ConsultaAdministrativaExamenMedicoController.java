package cu.certificados.cerme.controller.consulta;

import static cu.certificados.cerme.utilitario.ConstantesGenerales.PAGINA_CONSULTA_ADMINISTRATIVA_EXAMEN_MEDICO;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_CAMPANIAS;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_CONSULTA;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_ESTADOS_EXAMEN_MEDICO;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_FACULTADES;
import static cu.certificados.cerme.utilitario.ConstantesGenerales.P_TIPOS_ALUMNO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.ICampaniaService;
import cu.certificados.cerme.service.IFacultadService;
import cu.certificados.cerme.service.IMultiTabDetService;
import cu.certificados.cerme.service.IParametroGeneralService;
import cu.certificados.cerme.utilitario.DatesUtils;
import cu.certificados.cerme.utilitario.MultiTablaUtil;

@Vista
@RequestMapping("/consulta/administrativa")
public @Controller class ConsultaAdministrativaExamenMedicoController
{
    private @Autowired IFacultadService facultadService;
    private @Autowired ICampaniaService campaniaService;
    private @Autowired IMultiTabDetService multiTabDetService;
    private @Autowired IParametroGeneralService parametroGeneralService;

    @GetMapping("/{consulta:laboratorio}")
    public String irPaginaConsultaAdministrativaExamenMedicoLaboratorio(
            @PathVariable String consulta, ModelMap model)
    {
        model.addAttribute(P_TIPOS_ALUMNO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_TIPO_ALUMNO));
        model.addAttribute(P_ESTADOS_EXAMEN_MEDICO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_ESTADO_EXAMEN_MEDICO));
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarTodos());
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute("anios",
                DatesUtils.obtenerAnios(parametroGeneralService.buscarAnioInicio()));
        model.addAttribute(P_CONSULTA, consulta);
        model.addAttribute("indicadoresRPR",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_RPR));
        model.addAttribute("indicadoresHemograma",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_HEMOGRAMA));
        model.addAttribute("diluciones",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_DILUCION));
        model.addAttribute("gruposSanguineo",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_GRUPO_SANGUINEO));
        model.addAttribute("factoresRh",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_FACTOR_RH));
        return PAGINA_CONSULTA_ADMINISTRATIVA_EXAMEN_MEDICO;
    }

    @GetMapping("/{consulta:radiologico}")
    public String irPaginaConsultaAdministrativaExamenMedicoRadiologico(
            @PathVariable String consulta, ModelMap model)
    {
        model.addAttribute(P_TIPOS_ALUMNO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_TIPO_ALUMNO));
        model.addAttribute(P_ESTADOS_EXAMEN_MEDICO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_ESTADO_EXAMEN_MEDICO));
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarTodos());
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute("anios",
                DatesUtils.obtenerAnios(parametroGeneralService.buscarAnioInicio()));
        model.addAttribute("resultadosRadiologico",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_RESULTADO_RADIOLOGICO));
        model.addAttribute(P_CONSULTA, consulta);
        return PAGINA_CONSULTA_ADMINISTRATIVA_EXAMEN_MEDICO;
    }

    @GetMapping("/{consulta:psicologia}")
    public String irPaginaConsultaAdministrativaExamenMedicoPsicologico(
            @PathVariable String consulta, ModelMap model)
    {
        model.addAttribute(P_TIPOS_ALUMNO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_TIPO_ALUMNO));
        model.addAttribute(P_ESTADOS_EXAMEN_MEDICO,
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_ESTADO_EXAMEN_MEDICO));
        model.addAttribute(P_CAMPANIAS, campaniaService.buscarTodos());
        model.addAttribute(P_FACULTADES, facultadService.buscarTodos());
        model.addAttribute("resultadosPsicologico",
                multiTabDetService.buscarPorIdTabla(MultiTablaUtil.TABLA_RESULTADO_PSICOLOGICO));
        model.addAttribute(P_CONSULTA, consulta);
        return PAGINA_CONSULTA_ADMINISTRATIVA_EXAMEN_MEDICO;
    }
}