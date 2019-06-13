package cu.certificados.cerme.service.impl.movimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IExamenMedicoPsicologicoMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.ExamenMedicoPsicologico;
import cu.certificados.cerme.service.IExamenMedicoPsicologicoService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class ExamenMedicoPsicologicoService extends MantenibleService<ExamenMedicoPsicologico>
        implements IExamenMedicoPsicologicoService
{
    @SuppressWarnings("unused")
    private IExamenMedicoPsicologicoMapper examenMedicoPsicologicoMapper;

    public ExamenMedicoPsicologicoService(
            @Qualifier("IExamenMedicoPsicologicoMapper") IMantenibleMapper<ExamenMedicoPsicologico> mapper)
    {
        super(mapper);
        this.examenMedicoPsicologicoMapper = (IExamenMedicoPsicologicoMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarExamenMedicoPsicologico(ExamenMedicoPsicologico examenMedicoPsicologico)
    {
        this.registrar(examenMedicoPsicologico);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void actualizarExamenMedicoPsicologico(ExamenMedicoPsicologico examenMedicoPsicologico)
    {
        this.actualizar(examenMedicoPsicologico);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void eliminarExamenMedicoPsicologico(ExamenMedicoPsicologico examenMedicoPsicologico)
    {
        this.eliminar(examenMedicoPsicologico);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ExamenMedicoPsicologico> buscarResultadoRegularPorNumeroRegistro(
            Integer numeroRegistro)
    {
        ExamenMedicoPsicologico examenMedicoPsicologico = ExamenMedicoPsicologico.builder()
                .numeroRegistro(numeroRegistro).build();
        return this.buscar(examenMedicoPsicologico, Verbo.GET);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean existeExamenMedicoPsicologico(Integer numeroRegistro)
    {
        ExamenMedicoPsicologico examenMedicoPsicologico = ExamenMedicoPsicologico.builder()
                .numeroRegistro(numeroRegistro).build();
        return this.existe(examenMedicoPsicologico);
    }
}