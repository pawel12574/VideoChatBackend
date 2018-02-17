//package corpchat.configurations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.corpchat.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class Security extends WebSecurityConfigurerAdapter {
//
////    @Bean
////    public CustomAuthenticatiocnProvider getAuthenticationProvider() {
////        return new CustomAuthenticationProvider();
////    }
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean // w innym projekcie dziala bez tego
//    public UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/accounts/login-error")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        http.headers().frameOptions().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(getAuthenticationProvider());
//////                .inMemoryAuthentication()
//////                .withUser("user").password("password").roles("ADMIN");
////    }
//
//
//
//}