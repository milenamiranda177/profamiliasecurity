package com.mvcprime.filter;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class MyAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authentication.getName());
        if (userDetails != null && new BasicPasswordEncryptor().checkPassword(authentication.getCredentials().toString(),
                        userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        
        throw new BadCredentialsException("Bad credentials");
    }
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
}