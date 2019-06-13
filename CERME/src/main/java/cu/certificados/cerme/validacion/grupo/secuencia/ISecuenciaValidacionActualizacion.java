package cu.certificados.cerme.validacion.grupo.secuencia;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import cu.certificados.cerme.validacion.grupo.ILlave;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;

@GroupSequence({ Default.class, ILlave.class, IActualizacion.class })
public interface ISecuenciaValidacionActualizacion
{

}