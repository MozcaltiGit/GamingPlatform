package com.mozcalti.gamingapp.security;

import com.mozcalti.gamingapp.model.Usuario;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Setter(value = AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.NONE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String password;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Usuario usuario) {

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol()));

        return new UserDetailsImpl(
                usuario.getEmail(),
                usuario.getPassword(),
                true,
                true,
                true,
                usuario.isHabilitado(),
                authorities);
    }
}
