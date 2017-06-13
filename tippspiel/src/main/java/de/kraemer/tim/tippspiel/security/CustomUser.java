package de.kraemer.tim.tippspiel.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import de.kraemer.tim.tippspiel.account.Account;

public class CustomUser extends User implements UserDetails{
	private static final long serialVersionUID = 6295229428286544967L;
	
	private Account account;

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public CustomUser(Account account) {
		super(account.getUsername(), account.getPassword(), getAuthorities(account));
		this.account = account;
	}
	
	private static Set<GrantedAuthority> getAuthorities(Account account){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getRole());
        authorities.add(grantedAuthority);
        return authorities;
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
