package cu.certificados.cerme.controller.consulta.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.consulta.administrativa.ConsultaLaboratorioAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoLaboratorio;
import cu.certificados.cerme.model.movimiento.ExamenMedicoLaboratorio;
import cu.certificados.cerme.service.IConsultaExamenMedicoLaboratorioService;
import cu.certificados.cerme.service.IExamenMedicoLaboratorioService;

@RequestMapping("/consulta/laboratorio")
public @RestController class ConsultaExamenMedicoLaboratorioRestController
{
    private @Autowired IExamenMedicoLaboratorioService examenMedicoLaboratorioService;
    private @Autowired IConsultaExamenMedicoLaboratorioService consultaExamenMedicoLaboratorioService;

    @GetMapping(value = "/administrativa", params = "accion=buscarPorCriterioBusquedaAdministrativa")
    public List<ConsultaLaboratorioAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusquedaAdministrativaExamenMedicoLaboratorio)
    {
        return this.consultaExamenMedicoLaboratorioService.buscarPorCriterioBusquedaAdministrativa(
                criterioBusquedaAdministrativaExamenMedicoLaboratorio);
    }

    @GetMapping(params = { "accion=buscarResultadoPorNumeroRegistroAnio", "tipoAlumno=R" })
    public List<ExamenMedicoLaboratorio> buscarResultadoRegularPorNumeroRegistroAnio(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusqueda)
    {
        return this.examenMedicoLaboratorioService.buscarResultadoRegularPorNumeroRegistroAnio(
                criterioBusqueda.getNumeroRegistro(), criterioBusqueda.getAnio());
    }

    @GetMapping(params = { "accion=buscarResultadoPorNumeroRegistroAnio", "tipoAlumno=I" })
    public List<ExamenMedicoLaboratorio> buscarResultadoIngresantePorNumeroRegistroAnio(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusqueda)
    {
        return this.examenMedicoLaboratorioService.buscarResultadoIngresantePorNumeroRegistroAnio(
                criterioBusqueda.getNumeroRegistro(), criterioBusqueda.getAnio());
    }
}