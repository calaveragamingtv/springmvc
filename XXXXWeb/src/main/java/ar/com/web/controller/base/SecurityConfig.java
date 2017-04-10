package ar.com.web.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${login.usuario}")
    private String mensajeError;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth
        .inMemoryAuthentication()
          .withUser("user")  // #1
            .password("pass")
            .roles("USER")
            .and()
          .withUser("admin") // #2
            .password("pass")
            .roles("ADMIN","USER");
    }

    // Authentication : User --> Roles
  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("barry").password("pass").roles("ADMIN");
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/webjars/**").antMatchers("/");

    }





    // Authorization : Role -> Access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
           .antMatchers("/login", "/", "/index.jsp" ).permitAll()
            .antMatchers("/", "/home").permitAll()
            .antMatchers( "/usuarios.html").authenticated()
            .antMatchers( "/usuarios").authenticated()
            //.hasRole("ADMIN").anyRequest().authenticated()
            .and()
        .formLogin()
           .loginPage("/login")
           .defaultSuccessUrl("/usuarios")
           .failureUrl("/login?error=" + this.mensajeError)
            .permitAll()
            .and()
        .logout()
            .permitAll();
       /* http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/welcome").hasRole("ADMIN")
        .and().authorizeRequests().anyRequest().authenticated()

            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/usuarios", true)
            .permitAll()
            .and()
        .logout()
            .permitAll();*/
        /*.formLogin()
            .loginPage("/base/login.jsp")
            .permitAll()
            .and()
        .logout()
            .permitAll();*/

    }




}
