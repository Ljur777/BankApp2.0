package com.example.bankapp.config;
import com.example.bankapp.service.Impl.ClientServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

//    @Autowired
 //   private PasswordEncoder passwordEncoder;  // Объект для шифрования паролей

 //   @Bean
   // public PasswordEncoder getPasswordEncoder(){  // Создаю бин для шифровальщика паролей
   //     return new BCryptPasswordEncoder(8);
  //  }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration").permitAll()    // Указываем кто может пользоваться нашей системой без авторизации и указываем общедоступные страницы
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // Указываем куда имеено будет перенаправляться запрос, если польщователь не авторизировался
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.csrf().disable();                          // Строка, которая разрешает пост-запросы
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // Метод ответсвенный за авторизацию пользователя
        auth.userDetailsService(clientServiceImpl)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
/*
    @Bean //Указываем те страницы, к-е можно просмотреть без регистрации
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll() //без регистрации можно просмотреть только логин
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean  //задаем пароль и имя пользователя- для тестирования
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
    */
    //слай в 13,01


}