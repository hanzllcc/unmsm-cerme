package cu.certificados.cerme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import cu.certificados.cerme.model.criterio.CriterioBusquedaReporteAtencionDiaria;
import cu.certificados.cerme.model.reporte.ReporteAtencionDiaria;

public interface IReporteAtencionDiariaMapper
{
    @Select(value = { "{call REPORT_ATENCION_DIARIA ( "
            + "#{verbo, jdbcType = VARCHAR, mode = IN},"
            + "#{fechaInicio, jdbcType = DATE, mode = IN},"
            + "#{fechaFin, jdbcType = DATE, mode = IN},"
            + "#{idCampania, jdbcType = INTEGER, mode = IN})}" })
    @Options(statementType = StatementType.CALLABLE)
    public List<ReporteAtencionDiaria> buscarAtencionesDiarias(
            CriterioBusquedaReporteAtencionDiaria criterioBusquedaReporteAtencionDiaria);
}