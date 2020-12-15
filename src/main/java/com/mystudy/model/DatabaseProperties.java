/**
 * 
 */
package com.mystudy.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Keshav
 *
 */
@Configuration
@PropertySource(value= {"classpath:application.properties"})
public class DatabaseProperties {
	
	@Value("${jdbc.driver}")
	private String driverName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.format_sql}")
	private String formatSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	public String getShowSql() {
		return showSql;
	}
	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}
	public String getFormatSql() {
		return formatSql;
	}
	public void setFormatSql(String formatSql) {
		this.formatSql = formatSql;
	}
	public String getHbm2ddl() {
		return hbm2ddl;
	}
	public void setHbm2ddl(String hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}
	@Override
	public String toString() {
		return "DatabaseProperties [driverName=" + driverName + ", url=" + url + ", userName=" + userName
				+ ", password=" + password + ", dialect=" + dialect + ", showSql=" + showSql + ", formatSql="
				+ formatSql + ", hbm2ddl=" + hbm2ddl + "]";
	}
	
}
