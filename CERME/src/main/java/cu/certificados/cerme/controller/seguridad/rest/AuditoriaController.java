package cu.certificados.cerme.controller.seguridad.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.criterio.CriterioBusquedaAuditoria;
import cu.certificados.cerme.model.seguridad.Auditoria;
import cu.certificados.cerme.service.IAuditoriaService;

public @RestController class AuditoriaController
{
    private @Autowired IAuditoriaService auditoriaService;

    @GetMapping(value = "seguridad/auditoria", params = "accion=buscar")
    public List<Auditoria> buscarPistasAuditoriaPorCriterio(
            CriterioBusquedaAuditoria criterioBusquedaAuditoria)
    {
        return auditoriaService.buscarPistasAuditoriaPorCriterio(criterioBusquedaAuditoria);
    }
}