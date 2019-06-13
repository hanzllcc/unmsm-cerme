package cu.certificados.cerme.validacion.grupo.secuencia;

import javax.validation.GroupSequence;

import cu.certificados.cerme.validacion.grupo.ILlave;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;

@GroupSequence({ ILlave.class, IActualizacion.class })
public interface ISecuenciaValidacionEliminacion
{

}