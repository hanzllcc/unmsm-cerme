package cu.certificados.cerme.service;

import cu.certificados.cerme.model.mantenimiento.ParametroCorreo;

public interface IParametroCorreoService extends IMantenibleService<ParametroCorreo>
{
    public ParametroCorreo buscarParametroCorreo();
}