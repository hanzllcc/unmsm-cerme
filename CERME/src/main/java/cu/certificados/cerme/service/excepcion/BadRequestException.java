package cu.certificados.cerme.service.excepcion;

import java.util.List;

import cu.certificados.cerme.model.parametro.MensajeValidacion;

public class BadRequestException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    private List<MensajeValidacion> mensajesValidacion;

    public BadRequestException(List<MensajeValidacion> mensajesValidacion)
    {
        this.mensajesValidacion = mensajesValidacion;
    }

    public List<MensajeValidacion> getMensajesValidacion()
    {
        return this.mensajesValidacion;
    }
}