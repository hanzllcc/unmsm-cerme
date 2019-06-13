package cu.certificados.cerme.controller.procesomanual.rest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.criterio.CriterioBusquedaEnvioCorreo;
import cu.certificados.cerme.service.IEjecucionProcesoManualService;

@RequestMapping("/procesoManual/ejecucion")
public @RestController class EjecucionProcesoManualRestController
{
    private @Autowired IEjecucionProcesoManualService ejecucionProcesoManualService;

    @PostMapping(params = "accion=ejecutar")
    public void ejecutarProcesoManual(
            @RequestBody CriterioBusquedaEnvioCorreo criterioBusquedaEnvioCorreo)
            throws IOException, MessagingException, InterruptedException, ExecutionException
    {
        ejecucionProcesoManualService.ejecutarProcesoManual(criterioBusquedaEnvioCorreo);
    }
}