package cu.certificados.cerme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import cu.certificados.cerme.model.criterio.CriterioBusquedaEnvioCorreo;
import cu.certificados.cerme.model.procesoautomatico.EnvioLote;

public interface IEjecucionProcesoManualMapper
{
    @Select(value = {
            "{call ENVIO_CORREO ( " 
                    + "#{idDestinoEnvio,    jdbcType = VARCHAR, mode = IN},"
                    + "#{idProcesoAutomatico,    jdbcType = VARCHAR, mode = IN},"
                    + "#{codigoFacultad,    jdbcType = NUMERIC, mode = IN},"
                    + "#{codigoFacultadesEnvio,    jdbcType = VARCHAR, mode = IN},"
                    + "#{idCampania,        jdbcType = INTEGER, mode = IN},"
                    + "#{fechaInicio,       jdbcType = DATE, mode = IN},"
                    + "#{fechaFin,          jdbcType = DATE, mode = IN})}" })
    @Options(statementType = StatementType.CALLABLE)
    public List<EnvioLote> buscarAlumnosParaEnvioCorreo(
            CriterioBusquedaEnvioCorreo criterioBusquedaEnvioCorreo);
}