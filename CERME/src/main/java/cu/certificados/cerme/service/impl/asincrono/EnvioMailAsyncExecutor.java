package cu.certificados.cerme.service.impl.asincrono;

import java.util.concurrent.Future;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import cu.certificados.cerme.aspecto.anotacion.ControlLogEnvioCorreoDependencia;
import cu.certificados.cerme.model.procesoautomatico.Correo;
import cu.certificados.cerme.service.IEnvioMailAsyncExecutor;
import cu.certificados.cerme.service.IEnvioMailService;

@Service
public class EnvioMailAsyncExecutor implements IEnvioMailAsyncExecutor
{
    private @Autowired IEnvioMailService envioMailService;

    @Async
    @ControlLogEnvioCorreoDependencia
    public Future<Void> enviarCorreo(Correo correo) throws MessagingException
    {
        envioMailService.enviarCorreo(correo);
        try
        {
            Thread.sleep(30000);
        } catch (Exception e)
        {

        }
        return new AsyncResult<Void>(null);
    }
}