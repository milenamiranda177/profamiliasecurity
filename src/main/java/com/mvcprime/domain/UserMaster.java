package com.mvcprime.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class UserMaster implements Serializable {

	 private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name = "user_id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    @Column(name = "username")
	    private String login;
	    @Column(name = "password")
	    private String password;
	    
	    @Column(name = "enabled")
	    private Integer enabled;
	    
	    @OneToMany(
	            fetch = FetchType.EAGER, cascade = CascadeType.ALL,
	            mappedBy = "userId"
	    )
	    private Set<UserRole> authorities;
	    
	    public Integer getId()
	    {
	        return id;
	    }

	    public void setId(Integer id)
	    {
	        this.id = id;
	    } 
    
		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	public Integer getEnabled() {
			return enabled;
		}

		public void setEnabled(Integer enabled) {
			this.enabled = enabled;
		}
		
		

	public Set<UserRole> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(Set<UserRole> authorities) {
			this.authorities = authorities;
		}

	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Login: " + login);
        return buffer.toString();
    }
}
