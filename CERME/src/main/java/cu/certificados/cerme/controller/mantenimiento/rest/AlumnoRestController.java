package cu.certificados.cerme.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.aspecto.anotacion.Audit;
import cu.certificados.cerme.aspecto.enumeracion.Accion;
import cu.certificados.cerme.aspecto.enumeracion.Comentario;
import cu.certificados.cerme.aspecto.enumeracion.Dato;
import cu.certificados.cerme.aspecto.enumeracion.Tipo;
import cu.certificados.cerme.model.mantenimiento.Alumno;
import cu.certificados.cerme.service.IAlumnoService;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.utilitario.ConstantesGenerales;
import cu.certificados.cerme.utilitario.ValidatorUtil;
import cu.certificados.cerme.validacion.grupo.secuencia.ISecuenciaValidacionActualizacion;
import cu.certificados.cerme.validacion.grupo.secuencia.ISecuenciaValidacionEliminacion;
import cu.certificados.cerme.validacion.grupo.secuencia.ISecuenciaValidacionRegistro;

@Audit(tipo = Tipo.Alumno, datos = Dato.Alumno)
@RequestMapping("/mantenimiento/alumno")
public @RestController class AlumnoRestController
{
    private @Autowired IAlumnoService alumnoService;

    @Audit(accion = Accion.Consulta, comentario = Comentario.ConsultaTodos)
    @GetMapping(params = "accion=buscarTodos")
    public List<Alumno> buscarTodos()
    {
        return this.alumnoService.buscarTodos();
    }

    @Audit(accion = Accion.Registro, comentario = Comentario.Registro)
    @PostMapping
    public Alumno registrarAlumno(
            @Validated(ISecuenciaValidacionRegistro.class) @RequestBody Alumno alumno, Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.alumnoService.registrarAlumno(alumno);
        return this.alumnoService.buscarPorCodigoAlumnoTipoAlumno(alumno.getCodigoAlumno(),
                alumno.getTipoAlumno());
    }

    @Audit(accion = Accion.Actualizacion, comentario = Comentario.Actualizacion)
    @PutMapping
    public Alumno actualizarAlumno(
            @Validated(ISecuenciaValidacionActualizacion.class) @RequestBody Alumno alumno,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.alumnoService.actualizarAlumno(alumno);
        return this.alumnoService.buscarPorCodigoAlumnoTipoAlumno(alumno.getCodigoAlumno(),
                alumno.getTipoAlumno());
    }

    @Audit(accion = Accion.Eliminacion, comentario = Comentario.Eliminacion)
    @DeleteMapping
    public String eliminarAlumno(
            @Validated(ISecuenciaValidacionEliminacion.class) @RequestBody Alumno alumno,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.alumnoService.eliminarAlumno(alumno);
        return ConstantesGenerales.ELIMINACION_EXITOSA;
    }
}