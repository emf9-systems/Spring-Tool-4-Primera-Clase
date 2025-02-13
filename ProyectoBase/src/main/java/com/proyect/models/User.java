package com.proyect.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//AI: Autoincremento
	private Long id;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Size(min=2, max=100, message="El nombre debe tener al menos 2 caracteres")
	private String name;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Size(min=2, max=100, message="El apeliido debe tener al menos 2 caracteres")
	private String lastName;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Email
	@Size(min=2, max=100, message="El e-mail debe tener al menos 2 caracteres")
	private String email;
	@NotBlank(message="Este campo no puede estar en blanco")
	@Size(min=8, message="La contraseña debe tener al menos 8 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe incluir al menos una letra mayúscula, una letra minúscula y un número")
	private String password;
	@Transient
	@NotBlank(message="Este campo no puede estar en blanco")
	private String passwordConfirmation;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
    
    
	

}
