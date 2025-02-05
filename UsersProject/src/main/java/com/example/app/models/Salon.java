package com.example.app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="salones")
public class Salon {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//AI: Autoincremento
	private Long id;
	@NotNull
	private String curso;
	@Column(updatable=false) //Que la columna no puede editarse
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@OneToMany(mappedBy="salon", fetch=FetchType.LAZY)
	private List<Usuario> usuarios;

	public Salon() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
		return usuarios != null ? usuarios : new ArrayList<>();
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	// Método para contar inscritos
	public int getNumeroDeInscritos() {
		return getUsuarios().size();
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
