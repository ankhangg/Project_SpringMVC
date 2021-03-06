package com.dxc.config;

import com.dxc.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
  MyDBAuthenticationService myDBAauthenticationService;

  @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

  
      // Các User trong Database
      auth.userDetailsService(myDBAauthenticationService);

   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable();
          
         // Các trang không cần đăng nhập
       http.authorizeRequests().antMatchers("/home","/", "/viewitem","/login").permitAll();
       
       // Nếu chưa login, nó sẽ redirect tới trang /login.
       http.authorizeRequests().antMatchers("/inputinfo")//
       .access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')");
 


 
       // Trang chỉ dành cho MANAGER
       //http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");
       
    // Trang chỉ dành cho ADMIN
      http.authorizeRequests().antMatchers("/admin","/item","/add_item").access("hasRole('ROLE_ADMIN')");


 
       // Khi người dùng đã login, với vai trò XX.
       // Nhưng truy cập vào trang yêu cầu vai trò YY,
       // Ngoại lệ AccessDeniedException sẽ ném ra.
       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

 
       // Cấu hình cho Login Form.
       http.authorizeRequests().and().formLogin()//
         
               // Submit URL của trang login
               .loginProcessingUrl("/j_spring_security_check") // Submit URL
               .loginPage("/login")//
               .defaultSuccessUrl("/home")//
               .failureUrl("/login?error=true&alert=danger")//
               .usernameParameter("userName")//
               .passwordParameter("password")
           
               // Cấu hình cho Logout Page.
               // (Sau khi logout, chuyển tới trang home)
               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");

   }
}
