package cu.certificados.cerme.service;

import java.util.List;

import cu.certificados.cerme.model.mantenimiento.ParametroGeneral;

public interface IParametroGeneralService extends IMantenibleService<ParametroGeneral>
{
    public List<ParametroGeneral> buscarTodos();
    
    public void actualizarParametroGeneral(ParametroGeneral parametroGeneral);
    
    public Integer buscarAnioInicio();
    
    public String buscarCorreoSUM();
    
    public String buscarCorreoClinica();
}