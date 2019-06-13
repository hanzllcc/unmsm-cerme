package cu.certificados.cerme.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IParametroCorreoMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.ParametroCorreo;
import cu.certificados.cerme.service.IParametroCorreoService;
import cu.certificados.cerme.service.excepcion.ValorNoEncontradoException;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class ParametroCorreoService extends MantenibleService<ParametroCorreo>
        implements IParametroCorreoService
{
    @SuppressWarnings("unused")
    private IParametroCorreoMapper parametroCorreoMapper;

    public ParametroCorreoService(
            @Qualifier("IParametroCorreoMapper") IMantenibleMapper<ParametroCorreo> mapper)
    {
        super(mapper);
        this.parametroCorreoMapper = (IParametroCorreoMapper) mapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ParametroCorreo buscarParametroCorreo()
    {
        List<ParametroCorreo> parametrosCorreo = this.buscar(new ParametroCorreo(), Verbo.GET);
        if (parametrosCorreo.isEmpty())
        {
            throw new ValorNoEncontradoException(
                    ConstantesExcepciones.PARAMETRO_CORREO_NO_ENCONTRADO);
        }
        return parametrosCorreo.get(0);
    }
}