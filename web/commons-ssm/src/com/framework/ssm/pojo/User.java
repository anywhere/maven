package com.framework.ssm.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.framework.ssm.validation.constraints.Phone;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:19:28 PM
 * <ul>
 * <li>comment:User entity.</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class User extends BaseObject implements UserDetails {
    
    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }
            
            if (g1.getAuthority() == null) {
                return 1;
            }
            
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
    
    // Fields
    
    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());
        
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        
        return sortedAuthorities;
    }
    
    private boolean accountNonExpired;
    
    private boolean accountNonLocked;
    
    private Set<GrantedAuthority> authorities;
    
    private Date createDate;
    
    private boolean credentialsNonExpired;
    
    private Date dateOfExpiry;
    
    @NotNull
    private String displayname;
    
    @NotNull
    @Email(message = "Invalid email id")
    private String email;
    
    private boolean enabled;
    
    private String id;
    
    private Long lastLoginTime;
    
    private Integer loginFaildTims;
    
    @NotNull
    @Phone(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}")
    private String msisdn;
    
    // 实现了UserDetails之后的相关变量
    // ((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})
    // @Password(regexp = "\\w{6,20}")
    private String password;
    
    private List<Roles> roles;
    
    @NotNull(message = "用户名不能为空")
    private String username;
    
    public User() {
    }
    
    // Property accessors
    
    /** full constructor */
    public User(String username, String password, String displayname, boolean enabled, String msisdn, String email,
            Long lastLoginTime, Integer loginFaildTims, Date dateOfExpiry, Date createDate) {
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.enabled = enabled;
        this.msisdn = msisdn;
        this.email = email;
        this.lastLoginTime = lastLoginTime;
        this.loginFaildTims = loginFaildTims;
        this.dateOfExpiry = dateOfExpiry;
        this.createDate = createDate;
    }
    
    /** full constructor */
    public User(String userId, String username, String password, String displayname, boolean enabled, String msisdn,
            String email, Long lastLoginTime, Integer loginFaildTims, Date dateOfExpiry, Date createDate,
            List<Roles> roles, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<GrantedAuthority> authorities) {
        // super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        
        if (username == null || "".equals(username) || password == null) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        } else {
            this.id = userId;
            this.username = username;
            this.password = password;
            this.displayname = displayname;
            this.enabled = enabled;
            this.msisdn = msisdn;
            this.email = email;
            this.lastLoginTime = lastLoginTime;
            this.loginFaildTims = loginFaildTims;
            this.dateOfExpiry = dateOfExpiry;
            this.createDate = createDate;
            this.roles = roles;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        }
    }
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public Date getDateOfExpiry() {
        return this.dateOfExpiry;
    }
    
    public String getDisplayname() {
        return this.displayname;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getId() {
        return this.id;
    }
    
    public Long getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public Integer getLoginFaildTims() {
        return this.loginFaildTims;
    }
    
    public String getMsisdn() {
        return this.msisdn;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public List<Roles> getRoles() {
        return roles;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = (Set<GrantedAuthority>) authorities;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public void setLoginFaildTims(Integer loginFaildTims) {
        this.loginFaildTims = loginFaildTims;
    }
    
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}