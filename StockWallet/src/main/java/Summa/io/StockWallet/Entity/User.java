//package Summa.io.StockWallet.Entity;
//
//import java.util.Collection;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//@Entity
//@Table(name="user")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private String name="";
//	private String email="";
//	private String password="";
//	@Transient
//	private String validationPassword="";
//	private boolean terms=false;
//	
//	public User() {
//		
//	}
//	
//	public User(String name, String email, String password) {
//		this.name=name;
//		this.email=email;
//		this.password=password;
//	}
//	
//	@ManyToMany
//    private Collection<Role> roles;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getValidationPassword() {
//		return validationPassword;
//	}
//	public void setValidationPassword(String validationPassword) {
//		this.validationPassword = validationPassword;
//	}
//	public boolean isTerms() {
//		return terms;
//	}
//	public void setTerms(boolean terms) {
//		this.terms = terms;
//	}
//	public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//	
//	
//	
//}
