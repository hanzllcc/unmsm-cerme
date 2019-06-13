package cu.certificados.cerme.controller.movimiento.rest;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.movimiento.ExamenMedicoOdontologico;
import cu.certificados.cerme.service.IExamenMedicoOdontologiaService;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.utilitario.ConstantesGenerales;
import cu.certificados.cerme.utilitario.ValidatorUtil;
import cu.certificados.cerme.validacion.grupo.accion.IRegistro;

@RequestMapping("/examenmedico/odontologia")
public @RestController class ExamenMedicoOdontologicoRestController
{
    private @Autowired IExamenMedicoOdontologiaService examenMedicoOdontologiaService;

    @PostMapping
    public String registrarExamenMedicoOdontologico(@Validated({ Default.class,
            IRegistro.class }) @RequestBody ExamenMedicoOdontologico examenMedicoOdontologico,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.examenMedicoOdontologiaService
                .registrarExamenMedicoOdontologico(examenMedicoOdontologico);
        return ConstantesGenerales.REGISTRO_EXITOSO;
    }
}