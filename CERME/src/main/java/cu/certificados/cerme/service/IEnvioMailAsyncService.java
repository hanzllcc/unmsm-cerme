package cu.certificados.cerme.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;

import cu.certificados.cerme.model.procesoautomatico.Correo;

public interface IEnvioMailAsyncService
{
    public void enviarCorreo(List<Correo> correos)
            throws MessagingException, InterruptedException, ExecutionException;
}