package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.seguridad.Perfil;

public interface IPerfilService extends IMantenibleService<Perfil>
{
    public List<Perfil> buscarTodos();
}