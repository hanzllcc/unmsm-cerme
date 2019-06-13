package cu.certificados.cerme.validacion.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cu.certificados.cerme.service.IMultiTabCabService;
import cu.certificados.cerme.utilitario.ValidatorUtil;
import cu.certificados.cerme.validacion.IdTabla;

public class IdTablaValidator implements ConstraintValidator<IdTabla, Integer>
{
    private int min;
    private int max;
    private boolean existe;
    private @Autowired IMultiTabCabService multiTabCabService;

    @Override
    public void initialize(IdTabla anotacion)
    {
        this.min = anotacion.min();
        this.max = anotacion.max();
        this.existe = anotacion.existe();
    }

    @Override
    public boolean isValid(Integer idTabla, ConstraintValidatorContext context)
    {
        if (idTabla == null)
        {
            ValidatorUtil.addCustomMessageWithTemplate("{NotNull.MultiTaCab.idTabla}", context);
            return false;
        }
        if (idTabla < min || idTabla > max)
        {
            ValidatorUtil.addCustomMessageWithTemplate("{Range.MultiTaCab.idTabla}", context);
            return false;
        }
        boolean existeIdTabla = multiTabCabService.existeIdTabla(idTabla);
        return existe ? existeIdTabla : !existeIdTabla;
    }
}