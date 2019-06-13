package cu.certificados.cerme.service.impl.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IConsultaExamenMedicoPsicologicoMapper;
import cu.certificados.cerme.model.consulta.administrativa.ConsultaPsicologicoAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoPsicologico;
import cu.certificados.cerme.service.IConsultaExamenMedicoPsicologicoService;

@Service
public class ConsultaExamenMedicoPsicologicoService
        implements IConsultaExamenMedicoPsicologicoService
{
    private @Autowired IConsultaExamenMedicoPsicologicoMapper consultaExamenMedicoPsicologicoMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ConsultaPsicologicoAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoPsicologico criterioBusquedaAdministrativaExamenMedicoPsicologico)
    {
        return consultaExamenMedicoPsicologicoMapper.buscarPorCriterioBusquedaAdministrativa(
                criterioBusquedaAdministrativaExamenMedicoPsicologico);
    }
}