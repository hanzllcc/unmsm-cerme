package cu.certificados.cerme.mapper.base;

import java.util.List;

import cu.certificados.cerme.model.parametro.Parametro;

public interface IMantenibleMapper<T>
{
    public List<T> mantener(Parametro parametro);
}
