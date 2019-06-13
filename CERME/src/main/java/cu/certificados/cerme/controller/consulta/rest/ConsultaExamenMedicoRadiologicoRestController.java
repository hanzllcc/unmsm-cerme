package cu.certificados.cerme.controller.consulta.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.consulta.administrativa.ConsultaRadiologicoAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoLaboratorio;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoRadiologico;
import cu.certificados.cerme.model.movimiento.ExamenMedicoRadiologico;
import cu.certificados.cerme.service.IConsultaExamenMedicoRadiologicoService;
import cu.certificados.cerme.service.IExamenMedicoRadiologicoService;

@RequestMapping("/consulta/radiologico")
public @RestController class ConsultaExamenMedicoRadiologicoRestController
{
    private @Autowired IExamenMedicoRadiologicoService examenMedicoRadiologicoService;
    private @Autowired IConsultaExamenMedicoRadiologicoService consultaExamenMedicoRadiologicoService;

    @GetMapping(value = "/administrativa", params = "accion=buscarPorCriterioBusquedaAdministrativa")
    public List<ConsultaRadiologicoAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoRadiologico criterioBusquedaAdministrativaExamenMedicoRadiologico)
    {
        return consultaExamenMedicoRadiologicoService.buscarPorCriterioBusquedaAdministrativa(
                criterioBusquedaAdministrativaExamenMedicoRadiologico);
    }

    @GetMapping(params = "accion=buscarResultadoRegularPorNumeroRegistroAnio")
    public List<ExamenMedicoRadiologico> buscarResultadoRegularPorNumeroRegistroAnio(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusqueda)
    {
        return examenMedicoRadiologicoService.buscarResultadoRegularPorNumeroRegistroAnio(
                criterioBusqueda.getNumeroRegistro(), criterioBusqueda.getAnio());
    }
}