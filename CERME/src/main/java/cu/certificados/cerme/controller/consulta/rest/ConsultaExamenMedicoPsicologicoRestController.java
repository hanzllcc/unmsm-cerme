package cu.certificados.cerme.controller.consulta.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.consulta.administrativa.ConsultaPsicologicoAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoPsicologico;
import cu.certificados.cerme.model.movimiento.ExamenMedicoPsicologico;
import cu.certificados.cerme.service.IConsultaExamenMedicoPsicologicoService;
import cu.certificados.cerme.service.IExamenMedicoPsicologicoService;

@RequestMapping("/consulta/psicologico")
public @RestController class ConsultaExamenMedicoPsicologicoRestController
{
    private @Autowired IExamenMedicoPsicologicoService examenMedicoPsicologicoService;
    private @Autowired IConsultaExamenMedicoPsicologicoService consultaExamenMedicoPsicologicoService;

    @GetMapping(value = "/administrativa", params = "accion=buscarPorCriterioBusquedaAdministrativa")
    public List<ConsultaPsicologicoAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoPsicologico criterioBusqueda)
    {
        return consultaExamenMedicoPsicologicoService
                .buscarPorCriterioBusquedaAdministrativa(criterioBusqueda);
    }

    @GetMapping(params = "accion=buscarResultadoRegularPorNumeroRegistro")
    public List<ExamenMedicoPsicologico> buscarResultadoRegularPorNumeroRegistro(
            CriterioBusquedaAdministrativaExamenMedicoPsicologico criterioBusqueda)
    {
        return examenMedicoPsicologicoService
                .buscarResultadoRegularPorNumeroRegistro(criterioBusqueda.getNumeroRegistro());
    }
}