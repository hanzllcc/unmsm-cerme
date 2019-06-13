package cu.certificados.cerme.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.ICampaniaMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.Campania;
import cu.certificados.cerme.service.ICampaniaService;
import cu.certificados.cerme.service.excepcion.MantenimientoException;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class CampaniaService extends MantenibleService<Campania> implements ICampaniaService
{
    @SuppressWarnings("unused")
    private ICampaniaMapper campaniaMapper;

    private static final String GETS_ACTIVO = "GETS_ACTIVO";

    public CampaniaService(@Qualifier("ICampaniaMapper") IMantenibleMapper<Campania> mapper)
    {
        super(mapper);
        this.campaniaMapper = (ICampaniaMapper) mapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Campania> buscarTodos()
    {
        return this.buscar(new Campania(), Verbo.GETS);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Campania> buscarPorId(int idCampania)
    {
        Campania campania = Campania.builder().idCampania(idCampania).build();
        return this.buscar(campania, Verbo.GET);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Campania> buscarPorEstadoActivo(boolean estadoActivo)
    {
        Campania campania = Campania.builder().activo(estadoActivo).build();
        return this.buscar(campania, GETS_ACTIVO);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean existeCampania(int idCampania)
    {
        Campania campania = Campania.builder().idCampania(idCampania).build();
        return this.existe(campania);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int registrarCampania(Campania campania)
    {
        List<Campania> campanias = this.registrarAutoIncrementable(campania);
        if (!campanias.isEmpty() && campanias.get(0).getIdCampania() != null)
        {
            return campanias.get(0).getIdCampania();
        } else
        {
            throw new MantenimientoException(ConstantesExcepciones.ERROR_REGISTRO);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void actualizarCampania(Campania campania)
    {
        this.actualizar(campania);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void eliminarCampania(Campania campania)
    {
        this.eliminar(campania);
    }
}