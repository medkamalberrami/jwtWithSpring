package com.example.demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Formation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int duree;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Collection<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Collection<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	@OneToMany(mappedBy="formation")
	private Collection<Etudiant> etudiant;
	
	public Formation()
	{
		
	}
	
	public Formation(String nom , int duree,Collection<Etudiant> etudiant)
	{
		this.nom=nom;
		this.duree=duree;
		this.etudiant=etudiant;
	}

}
