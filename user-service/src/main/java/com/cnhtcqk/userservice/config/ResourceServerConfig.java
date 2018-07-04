package com.cnhtcqk.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author fuxuelong
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    Logger log = LoggerFactory.getLogger(ResourceServerConfig.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/login","/user/register").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/login", "/**/*.css", "/img/**", "/third-party/**")
                .permitAll()
                .antMatchers("/**").authenticated();

    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
       // resources.resourceId("foo").tokenStore(tokenStore);
        resources.tokenStore(tokenStore);
    }

    @Autowired
    TokenStore tokenStore;

    @Autowired
    JwtAccessTokenConverter tokenConverter;
}
