package cu.certificados.cerme.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.ICie10Mapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.Cie10;
import cu.certificados.cerme.service.ICie10Service;
import cu.certificados.cerme.service.impl.MantenibleService;

@Service
public class Cie10Service extends MantenibleService<Cie10> implements ICie10Service
{
    private static final String GET_DESCRIPCION = "GET_DESCRIPCION";

    @SuppressWarnings("unused")
    private ICie10Mapper cie10Mapper;

    public Cie10Service(@Qualifier("ICie10Mapper") IMantenibleMapper<Cie10> mapper)
    {
        super(mapper);
        this.cie10Mapper = (ICie10Mapper) mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Cie10> buscarPorDescripcion(String descripcion)
    {
        Cie10 cie10 = Cie10.builder().descripcion(descripcion).build();
        return this.buscar(cie10, GET_DESCRIPCION);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean existeCie10(String idCie10)
    {
        Cie10 cie10 = Cie10.builder().idCie10(idCie10).build();
        return this.existe(cie10);
    }
}