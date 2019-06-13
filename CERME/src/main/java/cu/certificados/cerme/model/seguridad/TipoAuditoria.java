package cu.certificados.cerme.model.seguridad;

import lombok.Data;

@Data
public class TipoAuditoria
{
    private Integer idTipoAuditoria;
    private String descripcion;
    private String codigoAuditoria;
}