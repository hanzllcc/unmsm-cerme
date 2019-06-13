package cu.certificados.cerme.service.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IPerfilMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.seguridad.Perfil;
import cu.certificados.cerme.service.IPerfilService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class PerfilService extends MantenibleService<Perfil> implements IPerfilService
{
    @SuppressWarnings("unused")
    private IPerfilMapper perfilMapper;

    public PerfilService(@Qualifier("IPerfilMapper") IMantenibleMapper<Perfil> mapper)
    {
        super(mapper);
        this.perfilMapper = (IPerfilMapper) mapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Perfil> buscarTodos()
    {
        return this.buscar(new Perfil(), Verbo.GETS);
    }
}