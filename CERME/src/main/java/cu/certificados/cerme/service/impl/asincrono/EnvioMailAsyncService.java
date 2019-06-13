package cu.certificados.cerme.service.impl.asincrono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.certificados.cerme.model.procesoautomatico.Correo;
import cu.certificados.cerme.service.IEnvioMailAsyncExecutor;
import cu.certificados.cerme.service.IEnvioMailAsyncService;

@Service
public class EnvioMailAsyncService implements IEnvioMailAsyncService
{
    private @Autowired IEnvioMailAsyncExecutor envioMailAsyncExecutor;

    public void enviarCorreo(List<Correo> correos)
            throws MessagingException, InterruptedException, ExecutionException
    {
        Collection<Future<Void>> futures = new ArrayList<Future<Void>>();
        for (Correo correo : correos)
        {
            futures.add(envioMailAsyncExecutor.enviarCorreo(correo));
        }

        for (Future<Void> future : futures)
        {
            future.get();
        }
    }
}