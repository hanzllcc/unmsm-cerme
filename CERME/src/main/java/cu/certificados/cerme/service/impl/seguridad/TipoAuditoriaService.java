package cu.certificados.cerme.service.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.ITipoAuditoriaMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.seguridad.TipoAuditoria;
import cu.certificados.cerme.service.ITipoAuditoriaService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class TipoAuditoriaService extends MantenibleService<TipoAuditoria>
        implements ITipoAuditoriaService
{
    @SuppressWarnings("unused")
    private ITipoAuditoriaMapper tipoAuditoriaMapper;

    public TipoAuditoriaService(
            @Qualifier("ITipoAuditoriaMapper") IMantenibleMapper<TipoAuditoria> mapper)
    {
        super(mapper);
        this.tipoAuditoriaMapper = (ITipoAuditoriaMapper) mapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<TipoAuditoria> buscarTodos()
    {
        return this.buscar(new TipoAuditoria(), Verbo.GETS);
    }
}