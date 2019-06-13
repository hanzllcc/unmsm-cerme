package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.mantenimiento.Cie10;

public interface ICie10Service extends IMantenibleService<Cie10>
{
    public List<Cie10> buscarPorDescripcion(String descripcion);
    
    public boolean existeCie10(String idCie10);
}