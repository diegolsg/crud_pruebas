package com.covinoc.crud.adapter.api.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    @Autowired
    public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1. validar que sea un Heather Authorization valido.
        String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authHeader==null || authHeader.isEmpty() || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        //2. Validar que Jwt sea valido.
        String jwt=authHeader.split(" ")[1].trim();
        if(!this.jwtUtil.isValid(jwt)){
            filterChain.doFilter(request,response);
            return;
        }
        //3. Cargar el usuario del UserDetailService.
        String username=jwtUtil.getUsername(jwt);
        User user=(User) this.userDetailsService.loadUserByUsername(username);

        //4. Cargar al usuario en el contexto de seguridad
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
             user.getUsername(),user.getPassword(),user.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        System.out.println(authenticationToken);
        filterChain.doFilter(request,response);

    }
}
