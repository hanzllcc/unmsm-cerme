package cu.certificados.cerme.service.impl.mantenimiento;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IAlumnoMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.Alumno;
import cu.certificados.cerme.service.IAlumnoService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class AlumnoService extends MantenibleService<Alumno> implements IAlumnoService
{
    @SuppressWarnings("unused")
    private IAlumnoMapper alumnoMapper;

    private static final String CARGAR = "CARGAR";

    public AlumnoService(@Qualifier("IAlumnoMapper") IMantenibleMapper<Alumno> mapper)
    {
        super(mapper);
        this.alumnoMapper = (IAlumnoMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Alumno> buscarTodos()
    {
        return this.buscar(new Alumno(), Verbo.GETS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Alumno buscarPorCodigoAlumnoTipoAlumno(String codigoAlumno, String tipoAlumno)
    {
        Alumno alumno = Alumno.builder().codigoAlumno(codigoAlumno).tipoAlumno(tipoAlumno).build();
        List<Alumno> alumnos = this.buscar(alumno, Verbo.GET);
        Validate.notEmpty(alumnos, ConstantesExcepciones.ALUMNO_NO_ENCONTRADO, codigoAlumno, tipoAlumno);
        return alumnos.get(0);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean existeAlumno(String codigoAlumno, String tipoAlumno)
    {
        Alumno alumno = Alumno.builder().codigoAlumno(codigoAlumno).tipoAlumno(tipoAlumno).build();
        return this.existe(alumno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarAlumno(Alumno alumno)
    {
        this.registrar(alumno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarAlumnos(List<Alumno> alumnos)
    {
        alumnos.stream().forEach(alumno -> this.registrar(alumno, CARGAR));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void actualizarAlumno(Alumno alumno)
    {
        this.actualizar(alumno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void eliminarAlumno(Alumno alumno)
    {
        this.eliminar(alumno);
    }
}