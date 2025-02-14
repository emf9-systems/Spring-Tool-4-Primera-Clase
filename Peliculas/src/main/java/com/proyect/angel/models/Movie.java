package com.proyect.angel.models;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//AI: Autoincremento
	private Long id;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Size(min=2, message="El titulo debe tener al menos 2 caracteres")
	private String title;
	@NotNull(message="Este espacio no puede estar en blanco (Ingrese solo numeros)")
	@Max(9999)
	private Integer releaseYear;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Size(min=2, message="Debe tener al menos 2 caracteres")
	private String director;
	@Size(min=2, message="Debe tener al menos 2 caracteres")
	private String imageUrl;
	@NotBlank(message="Este espacio no puede estar en blanco")
	@Column(columnDefinition = "TEXT")
	@Size(min=2, message="Ingrese una breve descripcion de la pelicula")
	private String synopsis;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User author;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="fav_movies",
    		joinColumns=@JoinColumn(name="movie_id"),
    		inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<User> users;
    
    public Movie() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
    
    public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
