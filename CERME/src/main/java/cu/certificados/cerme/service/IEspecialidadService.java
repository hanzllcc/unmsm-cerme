package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.mantenimiento.Especialidad;

public interface IEspecialidadService extends IMantenibleService<Especialidad>
{
    public List<Especialidad> buscarTodos();

    public List<Especialidad> buscarPorId(int idEspecialidad);

    public boolean existeEspecialidad(int idEspecialidad);

    public int registrarEspecialidad(Especialidad especialidad);

    public void actualizarEspecialidad(Especialidad especialidad);

    public void eliminarEspecialidad(Especialidad especialidad);
}