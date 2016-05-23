package co.id.jasaraharja.microservices.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="ldap")
public class LdapSettings {

	private String url;
	private String managerDn;
	private String managerPassword;
	private String userSearchBase;
	private String userSearchFilter;
	private String groupSearchBase;
	private String groupSearchFilter;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getManagerDn() {
		return managerDn;
	}
	public void setManagerDn(String managerDn) {
		this.managerDn = managerDn;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getUserSearchBase() {
		return userSearchBase;
	}
	public void setUserSearchBase(String userSearchBase) {
		this.userSearchBase = userSearchBase;
	}
	public String getUserSearchFilter() {
		return userSearchFilter;
	}
	public void setUserSearchFilter(String userSearchFilter) {
		this.userSearchFilter = userSearchFilter;
	}
	public String getGroupSearchBase() {
		return groupSearchBase;
	}
	public void setGroupSearchBase(String groupSearchBase) {
		this.groupSearchBase = groupSearchBase;
	}
	public String getGroupSearchFilter() {
		return groupSearchFilter;
	}
	public void setGroupSearchFilter(String groupSearchFilter) {
		this.groupSearchFilter = groupSearchFilter;
	}
	
}
