package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.movimiento.Antecedente;

public interface IAntecedenteService extends IMantenibleService<Antecedente>
{
    public void registrarAntecedente(List<Antecedente> antecedentes);

    public void registrarAntecedente(List<Antecedente> antecedentes, Integer numeroRegistro,
            String anio, String numeroDocumento, String idTipoDocumento);

    public void registrarAntecedente(Antecedente antecedente);
}