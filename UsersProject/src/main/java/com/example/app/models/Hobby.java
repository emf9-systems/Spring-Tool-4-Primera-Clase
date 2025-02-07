package com.example.app.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="hobbies")
public class Hobby {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//AI: Autoincremento
	private Long id;
	@NotNull
	private String pasaTiempo;
	@Column(updatable=false) //Que la columna no puede editarse
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="usuarios_has_hobbies",
    		joinColumns=@JoinColumn(name="hobby_id"),
    	    inverseJoinColumns=@JoinColumn(name="usuario_id")
    		) 
    private List<Usuario> usuarios;
	
	public Hobby() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasaTiempo() {
		return pasaTiempo;
	}

	public void setPasaTiempo(String pasaTiempo) {
		this.pasaTiempo = pasaTiempo;
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
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@PrePersist  //Antes de crear al usuario
	protected void onCreate() {
		this.createdAt = new Date();  //DEFAULT CURRENT_TIMESTAMP
	}
	
	@PreUpdate  //Antes de que yo actualice 
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
