package cu.certificados.cerme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.mantenimiento.Cie10;
import cu.certificados.cerme.model.parametro.Parametro;

public interface ICie10Mapper extends IMantenibleMapper<Cie10>
{
    @Select(value = { "{call MANT_CIE10 ( "
            + "#{verbo, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.idCie10, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.descripcion, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.grupo, jdbcType = VARCHAR, mode = IN},"
            + "#{userAudit, jdbcType = VARCHAR, mode = IN})}" })
    @Options(statementType = StatementType.CALLABLE)
    public List<Cie10> mantener(Parametro parametro);
}