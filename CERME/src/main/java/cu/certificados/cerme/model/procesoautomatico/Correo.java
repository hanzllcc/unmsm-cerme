package cu.certificados.cerme.model.procesoautomatico;

import cu.certificados.cerme.utilitario.MimeTypeUtil;
import cu.certificados.cerme.utilitario.StringsUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Correo
{
    private Integer codigoDependencia; //FACULTAD
    private Integer idCampania;
    private String idProcesoAutomatico;
    private String textoEncabezado;
    private String textoCuerpo;
    private String correoDestino;
    private String correoDestinoConCopia;
    private String correoEmisor;
    private String nombreDocumento;
    private byte[] documento;
    private String contentType;

    public String getNombreConExtension()
    {
        return StringsUtils.concatenarCadena(this.nombreDocumento, getExtension());
    }
    
    public String getExtension()
    {
        return MimeTypeUtil.obtenerExtensionPorMymetype(contentType);
    }
}