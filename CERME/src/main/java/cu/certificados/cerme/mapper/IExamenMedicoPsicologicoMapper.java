package cu.certificados.cerme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.movimiento.ExamenMedicoPsicologico;
import cu.certificados.cerme.model.parametro.Parametro;

public interface IExamenMedicoPsicologicoMapper extends IMantenibleMapper<ExamenMedicoPsicologico>
{
    @Select(value = { "{call MANT_EXAMEN_MEDICO_PSICOLOGICO ( " 
            + "#{verbo, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.numeroRegistro, jdbcType = INTEGER, mode = IN},"
            + "#{objeto.codigoAlumno, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.tipoAlumno, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.idResultadoPsicologico, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.observacion, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.idCampania, jdbcType = INTEGER, mode = IN},"
            + "#{objeto.idEstadoExamenMedico, jdbcType = VARCHAR, mode = IN},"
            + "#{userAudit, jdbcType = VARCHAR, mode = IN})}" })
    @Options(statementType = StatementType.CALLABLE)
    public List<ExamenMedicoPsicologico> mantener(Parametro parametro);
}