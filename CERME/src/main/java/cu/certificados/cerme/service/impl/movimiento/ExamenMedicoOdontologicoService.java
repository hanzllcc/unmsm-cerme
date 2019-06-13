package cu.certificados.cerme.service.impl.movimiento;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IExamenMedicoOdontologiaMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.ExamenMedicoOdontologico;
import cu.certificados.cerme.service.IExamenMedicoOdontologiaService;
import cu.certificados.cerme.service.impl.MantenibleService;

@Service
public class ExamenMedicoOdontologicoService extends MantenibleService<ExamenMedicoOdontologico>
        implements IExamenMedicoOdontologiaService
{
    @SuppressWarnings("unused")
    private IExamenMedicoOdontologiaMapper examenMedicoOdontologiaMapper;

    public ExamenMedicoOdontologicoService(
            @Qualifier("IExamenMedicoOdontologiaMapper") IMantenibleMapper<ExamenMedicoOdontologico> mapper)
    {
        super(mapper);
        this.examenMedicoOdontologiaMapper = (IExamenMedicoOdontologiaMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarExamenMedicoOdontologico(ExamenMedicoOdontologico examenMedicoOdontologico)
    {
        this.registrar(examenMedicoOdontologico);
    }
}