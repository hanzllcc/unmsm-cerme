package cu.certificados.cerme.model.mantenimiento;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import cu.certificados.cerme.validacion.IdTabla;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultiTabCab
{
    @IdTabla(existe = true, groups = IActualizacion.class)
    private int idTabla;

    @NotNull(message = "{NotNull.MultiTabCab.descripcion}")
    @NotBlank(message = "{NotBlank.MultiTabCab.descripcion}")
    @Length(min = 3, max = 50, message = "{Length.MultiTabCab.descripcion}")
    private String descripcion;
}