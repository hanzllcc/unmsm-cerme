package mapperTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.configuracion.PersistenceConfiguration;
import cu.certificados.cerme.mapper.IConsultaAtencionInicialMapper;
import cu.certificados.cerme.model.criterio.CriterioBusquedaAtencionInicial;

@ContextConfiguration(classes = { PersistenceConfiguration.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioMapperTest
{
    //private @Autowired IUsuarioService usuarioService;
    private @Autowired IConsultaAtencionInicialMapper one;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buscarUsuarioPorIdUsuarioTest()
    {
       // Usuario usuario = usuarioService.buscarPorIdUsuarioParaInicioSesion("ADMIN");
        //Assert.assertEquals("ADMIN", usuario.getIdUsuario());
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void adf()
    {
        CriterioBusquedaAtencionInicial criterioBusqueda = new CriterioBusquedaAtencionInicial();
        criterioBusqueda.setIdCampania(1);
        criterioBusqueda.setCodigoAlumno("13200025");
        System.out.println(
                one.buscarConsultaAtencionInicialLaboratorioPorCriterioBusqueda(criterioBusqueda));

    }
}