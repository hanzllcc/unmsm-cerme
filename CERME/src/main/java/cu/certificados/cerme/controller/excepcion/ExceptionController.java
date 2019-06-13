package cu.certificados.cerme.controller.excepcion;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cu.certificados.cerme.controller.excepcion.anotacion.Vista;
import cu.certificados.cerme.service.excepcion.BadRequestException;
import cu.certificados.cerme.service.excepcion.EjecucionManualException;
import cu.certificados.cerme.service.excepcion.EscenarioException;
import cu.certificados.cerme.service.excepcion.ListaVaciaException;
import cu.certificados.cerme.service.excepcion.OrdenEjecucionException;
import cu.certificados.cerme.service.excepcion.ValorEncontradoException;
import cu.certificados.cerme.service.excepcion.ValorNoEncontradoException;
import cu.certificados.cerme.utilitario.ConstantesExcepciones;

@ControllerAdvice(annotations = Vista.class)
public class ExceptionController
{
    private @Autowired Logger logger;

    @ExceptionHandler(BadRequestException.class)
    public String catchBadRequestException(BadRequestException ex)
    {
        logger.error(ex.getMessage(), ex);
        return "redirect:/400";
    }

    @ExceptionHandler({ EscenarioException.class, OrdenEjecucionException.class,
            EjecucionManualException.class, ListaVaciaException.class,
            ValorNoEncontradoException.class, ValorEncontradoException.class })
    public String catchListaVaciaException(Exception ex, RedirectAttributes redirect)
    {
        logger.error(ex.getMessage(), ex);
        redirect.addFlashAttribute("mensaje", ex.getMessage());
        return "redirect:/409";
    }

    @ExceptionHandler(Exception.class)
    public String catchExcepcion(Exception ex, RedirectAttributes redirect)
    {
        logger.error(ex.getMessage(), ex);
        redirect.addFlashAttribute("mensaje", ConstantesExcepciones.ERROR_DESCONOCIDO);
        return "redirect:/500";
    }
}