package cu.certificados.cerme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import cu.certificados.cerme.mapper.base.IMantenibleMapper;
import cu.certificados.cerme.model.parametro.Parametro;
import cu.certificados.cerme.model.seguridad.Perfil;

public interface IPerfilMapper extends IMantenibleMapper<Perfil>
{
    @Select(value = { "{call MANT_PERFILES ( "
            + "#{verbo, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.idPerfil, jdbcType = VARCHAR, mode = IN},"
            + "#{objeto.descripcion, jdbcType = VARCHAR, mode = IN},"
            + "#{userAudit, jdbcType = VARCHAR, mode = IN})}" })
    @Options(statementType = StatementType.CALLABLE)
    public List<Perfil> mantener(Parametro parametro);
}