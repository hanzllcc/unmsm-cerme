package cu.certificados.cerme.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cu.certificados.cerme.configuracion.security.CustomGrantedAuthority;
import cu.certificados.cerme.configuracion.security.CustomUser;
import cu.certificados.cerme.model.seguridad.Usuario;
import cu.certificados.cerme.service.IUsuarioService;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private @Autowired IUsuarioService usuarioService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {
        Usuario usuario = usuarioService.buscarPorIdUsuarioParaInicioSesion(login);
        CustomUser user = null;
        if (usuario != null)
        {
            user = new CustomUser(usuario.getIdUsuario(), usuario.getContrasenia(),
                    usuario.isActivo(), true, true, true,
                    buscarPorIdUsuario(usuario.getIdPerfil()));
        }
        return user;
    }

    private List<GrantedAuthority> buscarPorIdUsuario(Integer idPerfil)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new CustomGrantedAuthority(String.valueOf(idPerfil), "ALL"));
        return authorities;
    }
}