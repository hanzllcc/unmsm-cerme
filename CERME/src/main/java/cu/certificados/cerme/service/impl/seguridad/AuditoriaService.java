package cu.certificados.cerme.service.impl.seguridad;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.aspecto.enumeracion.Accion;
import cu.certificados.cerme.aspecto.enumeracion.Comentario;
import cu.certificados.cerme.aspecto.enumeracion.Tipo;
import cu.certificados.cerme.mapper.IAuditoriaMapper;
import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAuditoria;
import cu.certificados.cerme.model.parametro.Parametro;
import cu.certificados.cerme.model.seguridad.Auditoria;
import cu.certificados.cerme.service.IAuditoriaService;
import cu.certificados.cerme.service.impl.MantenibleService;
import cu.certificados.cerme.utilitario.DatesUtils;
import cu.certificados.cerme.utilitario.Verbo;

@Service
public class AuditoriaService extends MantenibleService<Auditoria> implements IAuditoriaService
{
    private IAuditoriaMapper auditoriaMapper;

    public AuditoriaService(@Qualifier("IAuditoriaMapper") IMantenibleMapper<Auditoria> mapper)
    {
        super(mapper);
        this.auditoriaMapper = (IAuditoriaMapper) mapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Auditoria> buscarPistasAuditoriaPorCriterio(
            CriterioBusquedaAuditoria criterioBusqueda)
    {
        return auditoriaMapper.buscarPistasAuditoriaPorCriterio(criterioBusqueda);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarAuditoria(Auditoria auditoria)
    {
        auditoria.setFecha(new Date());
        auditoria.setHora(DatesUtils.obtenerFechaEnFormato(new Date(), DatesUtils.FORMATO_HHMMSS));
        this.registrar(auditoria);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarAuditoria(Tipo tipo, Comentario comentario, Accion accion, boolean exito,
            String nombreUsuario, String direccionIp)
    {
        Auditoria auditoria = Auditoria.builder().codigoAuditoria(tipo.name().toUpperCase())
                .idAccion(accion.toString()).comentario(comentario.toString()).exito(exito)
                .direccionIp(direccionIp).nombreUsuario(nombreUsuario).fecha(new Date())
                .hora(DatesUtils.obtenerFechaEnFormato(new Date(), DatesUtils.FORMATO_HHMMSS))
                .build();
        auditoriaMapper.mantener(new Parametro(Verbo.INSERT, auditoria));
    }
}