package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.seguridad.TipoAuditoria;

public interface ITipoAuditoriaService extends IMantenibleService<TipoAuditoria>
{
    public List<TipoAuditoria> buscarTodos();
}
