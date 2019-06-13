package cu.certificados.cerme.service.impl.movimiento;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IExamenMedicoTriajeMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.ExamenMedicoTriaje;
import cu.certificados.cerme.service.IExamenMedicoTriajeService;
import cu.certificados.cerme.service.impl.MantenibleService;

@Service
public class ExamenMedicoTriajeService extends MantenibleService<ExamenMedicoTriaje>
        implements IExamenMedicoTriajeService
{
    @SuppressWarnings("unused")
    private IExamenMedicoTriajeMapper examenMedicoTriajeMapper;

    public ExamenMedicoTriajeService(
            @Qualifier("IExamenMedicoTriajeMapper") IMantenibleMapper<ExamenMedicoTriaje> mapper)
    {
        super(mapper);
        this.examenMedicoTriajeMapper = (IExamenMedicoTriajeMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarExamenMedicoTriaje(ExamenMedicoTriaje examenMedicoTriaje)
    {
        this.registrar(examenMedicoTriaje);
    }
}