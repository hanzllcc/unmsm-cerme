package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.mantenimiento.Alumno;

public interface IAlumnoService extends IMantenibleService<Alumno>
{
    public List<Alumno> buscarTodos();

    public Alumno buscarPorCodigoAlumnoTipoAlumno(String codigoAlumno, String tipoAlumno);

    public boolean existeAlumno(String codigoAlumno, String tipoAlumno);

    public void registrarAlumno(Alumno alumno);
    
    public void registrarAlumnos(List<Alumno> alumnos);

    public void actualizarAlumno(Alumno alumno);

    public void eliminarAlumno(Alumno alumno);
}