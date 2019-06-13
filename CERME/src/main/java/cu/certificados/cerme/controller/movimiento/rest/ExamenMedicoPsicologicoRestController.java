package cu.certificados.cerme.controller.movimiento.rest;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.movimiento.ExamenMedicoPsicologico;
import cu.certificados.cerme.service.IExamenMedicoPsicologicoService;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.utilitario.ConstantesGenerales;
import cu.certificados.cerme.utilitario.ValidatorUtil;
import cu.certificados.cerme.validacion.grupo.accion.IActualizacion;
import cu.certificados.cerme.validacion.grupo.accion.IRegistro;

@RequestMapping("/examenmedico/psicologia")
public @RestController class ExamenMedicoPsicologicoRestController
{
    private @Autowired IExamenMedicoPsicologicoService examenMedicoPsicologicoService;

    @PostMapping
    public String registrarExamenMedicoPsicologico(
            @Validated({ IRegistro.class,
                    Default.class }) @RequestBody ExamenMedicoPsicologico examenMedicoPsicologico,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.examenMedicoPsicologicoService
                .registrarExamenMedicoPsicologico(examenMedicoPsicologico);
        return ConstantesGenerales.REGISTRO_EXITOSO;
    }

    @PutMapping
    public String actualizarExamenMedicoPsicologico(
            @Validated({ IActualizacion.class,
                    Default.class }) @RequestBody ExamenMedicoPsicologico examenMedicoPsicologico,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.examenMedicoPsicologicoService
                .actualizarExamenMedicoPsicologico(examenMedicoPsicologico);
        return ConstantesGenerales.ACTUALIZACION_EXITOSA;
    }

    @DeleteMapping
    public String eliminarExamenMedicoPsicologico(
            @Validated(IActualizacion.class) @RequestBody ExamenMedicoPsicologico examenMedicoPsicologico,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.examenMedicoPsicologicoService
                .eliminarExamenMedicoPsicologico(examenMedicoPsicologico);
        return ConstantesGenerales.ELIMINACION_EXITOSA;
    }
}