package cu.certificados.cerme.service.impl.movimiento;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IExamenMedicoMedicinaGeneralMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.Alumno;
import cu.certificados.cerme.model.movimiento.ExamenMedicoMedicinaGeneral;
import cu.certificados.cerme.service.IAlumnoService;
import cu.certificados.cerme.service.IAntecedenteService;
import cu.certificados.cerme.service.IExamenMedicoMedicinaGeneralService;
import cu.certificados.cerme.service.IInterconsultaService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;

@Service
public class ExamenMedicoMedicinaGeneralService
        extends MantenibleService<ExamenMedicoMedicinaGeneral>
        implements IExamenMedicoMedicinaGeneralService
{
    @SuppressWarnings("unused")
    private IExamenMedicoMedicinaGeneralMapper examenMedicoMedicinaGeneralMapper;

    private @Autowired IAlumnoService alumnoService;
    private @Autowired IAntecedenteService antecedenteService;
    private @Autowired IInterconsultaService interconsultaService;

    public ExamenMedicoMedicinaGeneralService(
            @Qualifier("IExamenMedicoMedicinaGeneralMapper") IMantenibleMapper<ExamenMedicoMedicinaGeneral> mapper)
    {
        super(mapper);
        this.examenMedicoMedicinaGeneralMapper = (IExamenMedicoMedicinaGeneralMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarExamenMedicoMedicinaGeneral(
            ExamenMedicoMedicinaGeneral examenMedicoMedicinaGeneral)
    {
        String anio = "";
        int numeroRegistro = 0;
        List<ExamenMedicoMedicinaGeneral> examenes = this
                .registrarAutoIncrementable(examenMedicoMedicinaGeneral);
        Validate.notEmpty(examenes, ConstantesExcepciones.ERROR_REGISTRO);
        Validate.notNull(examenes.get(0).getNumeroRegistro(), ConstantesExcepciones.ERROR_REGISTRO);
        Validate.notNull(examenes.get(0).getAnio(), ConstantesExcepciones.ERROR_REGISTRO);
        ExamenMedicoMedicinaGeneral examenMedicoMedicinaGeneralResultado = examenes.get(0);
        anio = examenMedicoMedicinaGeneralResultado.getAnio();
        numeroRegistro = examenMedicoMedicinaGeneralResultado.getNumeroRegistro();
        Alumno alumno = alumnoService.buscarPorCodigoAlumnoTipoAlumno(
                examenMedicoMedicinaGeneral.getCodigoAlumno(),
                examenMedicoMedicinaGeneral.getTipoAlumno());
        this.antecedenteService.registrarAntecedente(examenMedicoMedicinaGeneral.getAntecedentes(),
                numeroRegistro, anio, alumno.getNumeroDocumento(), alumno.getIdTipoDocumento());
        this.interconsultaService.registrarInterconsulta(
                examenMedicoMedicinaGeneral.getInterconsultas(), numeroRegistro, anio);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean existeExamenMedicoMedicinaGeneral(Integer numeroRegistro, String anio)
    {
        ExamenMedicoMedicinaGeneral examenMedicoMedicinaGeneral = ExamenMedicoMedicinaGeneral
                .builder().numeroRegistro(numeroRegistro).anio(anio).build();
        return this.existe(examenMedicoMedicinaGeneral);
    }
}