package cu.certificados.cerme.validacion.grupo.secuencia;

import javax.validation.GroupSequence;

import cu.certificados.cerme.validacion.grupo.IMetodo;
import cu.certificados.cerme.validacion.grupo.IParametro;

@GroupSequence({ IParametro.class, IMetodo.class })
public interface ISecuenciaValidacionController
{

}
