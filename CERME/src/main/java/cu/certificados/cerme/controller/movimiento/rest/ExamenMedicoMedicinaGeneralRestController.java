package cu.certificados.cerme.controller.movimiento.rest;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.movimiento.ExamenMedicoMedicinaGeneral;
import cu.certificados.cerme.service.IExamenMedicoMedicinaGeneralService;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.utilitario.ConstantesGenerales;
import cu.certificados.cerme.utilitario.ValidatorUtil;
import cu.certificados.cerme.validacion.grupo.accion.IRegistro;

@RequestMapping("/examenmedico/medicinaGeneral")
public @RestController class ExamenMedicoMedicinaGeneralRestController
{
    private @Autowired IExamenMedicoMedicinaGeneralService examenMedicoMedicinaGeneralService;

    @PostMapping
    public String registrarExamenMedicoMedicinaGeneral(@Validated({ IRegistro.class,
            Default.class }) @RequestBody ExamenMedicoMedicinaGeneral examenMedicoMedicinaGeneral,
            Errors error)
    {
        if (error.hasErrors())
        {
            throw new BadRequestException(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
        this.examenMedicoMedicinaGeneralService
                .registrarExamenMedicoMedicinaGeneral(examenMedicoMedicinaGeneral);
        return ConstantesGenerales.REGISTRO_EXITOSO;
    }
}