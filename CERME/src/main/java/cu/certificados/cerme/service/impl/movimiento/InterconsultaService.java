package cu.certificados.cerme.service.impl.movimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IInterconsultaMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.Interconsulta;
import cu.certificados.cerme.service.IInterconsultaService;
import cu.certificados.cerme.service.impl.MantenibleService;

@Service
public class InterconsultaService extends MantenibleService<Interconsulta>
        implements IInterconsultaService
{
    @SuppressWarnings("unused")
    private IInterconsultaMapper interconsultaMapper;

    public InterconsultaService(
            @Qualifier("IInterconsultaMapper") IMantenibleMapper<Interconsulta> mapper)
    {
        super(mapper);
        this.interconsultaMapper = (IInterconsultaMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarInterconsulta(List<Interconsulta> interconsultas, Integer numeroRegistro,
            String anio)
    {
        for (Interconsulta interconsulta : interconsultas)
        {
            interconsulta.setNumeroRegistro(numeroRegistro);
            interconsulta.setAnio(anio);
            registrarInterconsulta(interconsulta);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarInterconsulta(List<Interconsulta> interconsultas)
    {
        for (Interconsulta interconsulta : interconsultas)
        {
            registrarInterconsulta(interconsulta);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarInterconsulta(Interconsulta interconsulta)
    {
        this.registrar(interconsulta);
    }
}