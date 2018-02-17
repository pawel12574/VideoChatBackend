package corpchat.service.impl;

import corpchat.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    corpchat.model.User user = userRepository.findByEmail(email);
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    if(user == null) throw new UsernameNotFoundException("No such user");

    List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

    return new User(
            user.getEmail(),  /*email*/
            user.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            grantedAuths
    );
  }


}
