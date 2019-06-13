package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.aspecto.enumeracion.Accion;
import cu.certificados.cerme.aspecto.enumeracion.Comentario;
import cu.certificados.cerme.aspecto.enumeracion.Tipo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAuditoria;
import cu.certificados.cerme.model.seguridad.Auditoria;

public interface IAuditoriaService extends IMantenibleService<Auditoria>
{
    public List<Auditoria> buscarPistasAuditoriaPorCriterio(CriterioBusquedaAuditoria criterio);

    public void registrarAuditoria(Auditoria auditoria);

    public void registrarAuditoria(Tipo tipo, Comentario comentario, Accion accion, boolean exito,
            String nombreUsuario, String direccionIp);
}