package cu.certificados.cerme.service.excepcion;

public class FormatoException extends SimpException
{
    private static final long serialVersionUID = 1L;

    public FormatoException(String mensaje)
    {
        super(mensaje);
    }
}