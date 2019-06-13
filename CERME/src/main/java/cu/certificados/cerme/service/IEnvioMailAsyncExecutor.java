package cu.certificados.cerme.service;

import java.util.concurrent.Future;

import javax.mail.MessagingException;

import cu.certificados.cerme.model.procesoautomatico.Correo;

public interface IEnvioMailAsyncExecutor
{
    public Future<Void> enviarCorreo(Correo correo) throws MessagingException;
}