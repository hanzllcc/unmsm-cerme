package cu.certificados.cerme.model.parametro;

import lombok.Value;

@Value
public class MensajeValidacion
{
    private String campoError;
    private String mensajeError;
}