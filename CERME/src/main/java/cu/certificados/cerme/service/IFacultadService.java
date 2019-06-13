package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.mantenimiento.Facultad;

public interface IFacultadService extends IMantenibleService<Facultad>
{
    public List<Facultad> buscarTodos();
    
    public List<Facultad> buscarTodosT();
    
    public void registrarFacultad(Facultad facultad);
    
    public void actualizarFacultad(Facultad facultad);
    
    public void eliminarFacultad(Facultad facultad);
}