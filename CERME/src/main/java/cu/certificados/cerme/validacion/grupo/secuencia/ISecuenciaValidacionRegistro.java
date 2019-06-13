package cu.certificados.cerme.validacion.grupo.secuencia;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import cu.certificados.cerme.validacion.grupo.ILlave;
import cu.certificados.cerme.validacion.grupo.accion.IRegistro;

@GroupSequence({ Default.class, ILlave.class, IRegistro.class })
public interface ISecuenciaValidacionRegistro
{

}
