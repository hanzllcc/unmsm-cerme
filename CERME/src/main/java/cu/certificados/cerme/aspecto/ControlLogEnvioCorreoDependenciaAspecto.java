package cu.certificados.cerme.aspecto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cu.certificados.cerme.aspecto.anotacion.ControlLogEnvioCorreoDependencia;
import cu.certificados.cerme.model.logEnvio.LogEnvioCorreoDependencia;
import cu.certificados.cerme.model.procesoautomatico.Correo;

@Aspect
@Component
public class ControlLogEnvioCorreoDependenciaAspecto
{
    @Around("@annotation(controlLogEnvioCorreoDependencia)")
    public Object registrarLogEnvioCorreoDependencia(ProceedingJoinPoint proceedingJoinPoint,
            ControlLogEnvioCorreoDependencia controlLogEnvioCorreoDependencia) throws Throwable
    {
        boolean exito = false;
        String mensaje = "ENVIO EXITOSO";
        long tiempoInicial = System.currentTimeMillis();
        long tiempoFinal = 0;

        Object[] argumentos = proceedingJoinPoint.getArgs();
        Correo correo = (Correo) argumentos[0];
        try
        {
            return proceedingJoinPoint.proceed();
        } catch (Exception ex)
        {
            exito = true;
            mensaje = ex.getMessage();
            throw ex;
        } finally
        {
            tiempoFinal = System.currentTimeMillis();
            LogEnvioCorreoDependencia logEnvioCorreoDependencia = LogEnvioCorreoDependencia.builder()
                    .codigoDependencia(correo.getCodigoDependencia())
                    .idCampania(correo.getIdCampania())
                    .exito(exito)
                    .mensaje(mensaje)
                    .idProcesoAutomatico(correo.getIdProcesoAutomatico()).build();
        }
    }
}