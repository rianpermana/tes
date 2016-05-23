package co.id.jasaraharja.microservices.user.domain;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document(expiry=0)
public class User {

	@Id
	private String username;
	
	@Field
	private String fullName;
	
	@Field
	private String phone;
	
	@Field
	private String email;
	
	@Field
	private String role;
	
	@Field
	private String pushToken;
	
	public User() {
		
	}
	
	public User(String username, String fullName, String phone, String email, String role) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPushToken() {
		return pushToken;
	}
	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}
	
	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", fullName=").append(fullName);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", pushToken='").append(pushToken).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
