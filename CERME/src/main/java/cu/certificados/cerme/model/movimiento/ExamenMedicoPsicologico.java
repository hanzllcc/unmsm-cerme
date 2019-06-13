package cu.certificados.cerme.model.movimiento;

import org.hibernate.validator.constraints.Length;

import cu.certificados.cerme.utilitario.MultiTablaUtil;
import cu.certificados.cerme.validacion.CodigoAlumno;
import cu.certificados.cerme.validacion.IdCampania;
import cu.certificados.cerme.validacion.MultitabDet;
import cu.certificados.cerme.validacion.NumRegPsicologico;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;
import cu.certificados.cerme.validacion.grupo.accion.IRegistro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CodigoAlumno(existe = true, groups = IRegistro.class)
public class ExamenMedicoPsicologico
{
    @NumRegPsicologico(existe = true, groups = IActualizacion.class)
    private Integer numeroRegistro;

    @MultitabDet(campoIdItem = "idResultadoPsicologico", idTabla = MultiTablaUtil.TABLA_RESULTADO_PSICOLOGICO, existe = true, min = 1, max = 1)
    private String idResultadoPsicologico;

    @Length(max = 250, message = "{Length.ExamenPsicologico.observacion}")
    private String observacion;

    @IdCampania(existe = true, groups = IRegistro.class)
    private Integer idCampania;
    private String codigoAlumno;
    private String tipoAlumno;
    private String idEstadoExamenMedico;

    /* Datos Adicionales */
    private String descripcionTipoAlumno;
    private String descripcionResultadoPsicologico;
    private String descripcionCampania;
    private String descripcionEstadoExamenMedico;
}