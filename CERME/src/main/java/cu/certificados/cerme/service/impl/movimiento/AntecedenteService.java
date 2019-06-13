package cu.certificados.cerme.service.impl.movimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IAntecedenteMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.Antecedente;
import cu.certificados.cerme.service.IAntecedenteService;
import cu.certificados.cerme.service.impl.MantenibleService;

@Service
public class AntecedenteService extends MantenibleService<Antecedente>
        implements IAntecedenteService
{
    @SuppressWarnings("unused")
    private IAntecedenteMapper antecedenteMapper;

    public AntecedenteService(
            @Qualifier("IAntecedenteMapper") IMantenibleMapper<Antecedente> mapper)
    {
        super(mapper);
        this.antecedenteMapper = (IAntecedenteMapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarAntecedente(List<Antecedente> antecedentes)
    {
        for (Antecedente antecedente : antecedentes)
        {
            registrarAntecedente(antecedente);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarAntecedente(List<Antecedente> antecedentes, Integer numeroRegistro,
            String anio, String numeroDocumento, String idTipoDocumento)
    {
        for (Antecedente antecedente : antecedentes)
        {
            antecedente.setAnio(anio);
            antecedente.setNumeroRegistro(numeroRegistro);
            antecedente.setIdTipoDocumento(idTipoDocumento);
            antecedente.setNumeroDocumento(numeroDocumento);
            registrarAntecedente(antecedente);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registrarAntecedente(Antecedente antecedente)
    {
        this.registrar(antecedente);
    }
}