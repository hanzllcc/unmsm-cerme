package cu.certificados.cerme.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;

import cu.certificados.cerme.model.criterio.CriterioBusquedaEnvioCorreo;

public interface IEjecucionProcesoManualService
{
    public void ejecutarProcesoManual(CriterioBusquedaEnvioCorreo criterioBusquedaEnvioCorreo)
            throws IOException, MessagingException, InterruptedException, ExecutionException;
}