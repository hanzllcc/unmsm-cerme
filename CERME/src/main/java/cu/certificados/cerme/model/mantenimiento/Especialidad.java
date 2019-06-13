package cu.certificados.cerme.model.mantenimiento;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import cu.certificados.cerme.validacion.IdEspecialidad;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad
{
    @IdEspecialidad(existe = true, groups = IActualizacion.class)
    private Integer idEspecialidad;

    @NotNull(message = "{NotNull.Especialidad.descripcionCorta}")
    @NotBlank(message = "{NotBlank.Especialidad.descripcionCorta}")
    @Length(min = 3, max = 25, message = "{Length.Especialidad.descripcionCorta}")
    private String descripcionCorta;

    @NotNull(message = "{NotNull.Especialidad.descripcion}")
    @NotBlank(message = "{NotBlank.Especialidad.descripcion}")
    @Length(min = 3, max = 400, message = "{Length.Especialidad.descripcion}")
    private String descripcion;
}