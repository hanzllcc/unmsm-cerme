package cu.certificados.cerme.service.impl.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.mapper.IConsultaExamenMedicoLaboratorioMapper;
import cu.certificados.cerme.model.consulta.administrativa.ConsultaLaboratorioAdministrativo;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAdministrativaExamenMedicoLaboratorio;
import cu.certificados.cerme.service.IConsultaExamenMedicoLaboratorioService;

@Service
public class ConsultaExamenMedicoLaboratorioService implements IConsultaExamenMedicoLaboratorioService
{
    private @Autowired IConsultaExamenMedicoLaboratorioMapper consultaExamenMedicoLaboratorioMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ConsultaLaboratorioAdministrativo> buscarPorCriterioBusquedaAdministrativa(
            CriterioBusquedaAdministrativaExamenMedicoLaboratorio criterioBusquedaAdministrativaExamenMedicoLaboratorio)
    {
        return consultaExamenMedicoLaboratorioMapper
                .buscarPorCriterioBusquedaAdministrativa(criterioBusquedaAdministrativaExamenMedicoLaboratorio);
    }
}