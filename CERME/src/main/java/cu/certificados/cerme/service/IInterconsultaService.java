package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.movimiento.Interconsulta;

public interface IInterconsultaService extends IMantenibleService<Interconsulta>
{
    public void registrarInterconsulta(List<Interconsulta> interconsultas, Integer numeroRegistro,
            String anio);

    public void registrarInterconsulta(List<Interconsulta> interconsultas);

    public void registrarInterconsulta(Interconsulta interconsulta);
}