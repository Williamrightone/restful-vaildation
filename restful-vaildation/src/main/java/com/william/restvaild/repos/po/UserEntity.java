package com.william.restvaild.repos.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "PROJECT_USER")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 6084452811440424431L;

	@Id
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "USER_NAME", nullable = false)
	private String userName;
	
}
