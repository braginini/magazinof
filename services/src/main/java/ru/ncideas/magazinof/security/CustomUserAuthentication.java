package ru.ncideas.magazinof.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.ncideas.magazinof.entity.Role;
import ru.ncideas.magazinof.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CustomUserAuthentication implements Authentication {

    private boolean authenticated = false;
    private List<GrantedAuthority> grantedAuthorityList;
    private User user;
    private Date authTime;

    public CustomUserAuthentication() {
    }

    public CustomUserAuthentication(User user) {
        this(user, System.currentTimeMillis());
    }

    protected CustomUserAuthentication(User user, long authTime) {
        this(user, new Date(authTime));
    }

    protected CustomUserAuthentication(User user, Date authTime) {
        this.authTime = authTime;
        this.user = user;
        this.grantedAuthorityList = new ArrayList<GrantedAuthority>();
        /*if (user != null) {
            for (UnitUserRole unitUserRole : user.getUnitUserRoleList()) {
                grantedAuthorityList.add(new GrantedAuthorityImpl(unitUserRole.getRole().getName()));
            }
        }*/
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public List<Role> getOrgUserRoles() {
        return null;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    public Object getCredentials() {
        return getUser().getPassword();
    }

    public Object getDetails() {
        return getUser();
    }

    public Object getPrincipal() {
        return getUser().getUsername();
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
