package cu.certificados.cerme.service.impl.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IConsultaExamenMedicoRadiologicoMapper;
import cu.certificados.cerme.model.consulta.administrativa.ConsultaRadiologicoAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoRadiologico;
import cu.certificados.cerme.service.IConsultaExamenMedicoRadiologicoService;

@Service
public class ConsultaExamenMedicoRadiologicoService
        implements IConsultaExamenMedicoRadiologicoService
{
    private @Autowired IConsultaExamenMedicoRadiologicoMapper consultaExamenMedicoRadiologicoMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ConsultaRadiologicoAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoRadiologico criterioBusquedaAdministrativaExamenMedicoRadiologico)
    {
        return consultaExamenMedicoRadiologicoMapper.buscarPorCriterioBusquedaAdministrativa(
                criterioBusquedaAdministrativaExamenMedicoRadiologico);
    }
}