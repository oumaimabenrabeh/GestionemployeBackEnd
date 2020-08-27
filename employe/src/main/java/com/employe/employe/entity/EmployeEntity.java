package com.employe.employe.entity;

import javax.persistence.*;

@Entity
@Table(name="employe")
public class EmployeEntity {
	 @Id
	    @GeneratedValue
	    private Long id;
	     
	    @Column(name="nom")
	    private String nom;
	     
	    @Column(name="prenom")
	    private String prenom;
	    
	    @Column(name="adresse")
	    private String adresse;
	    
	    
	    @Column(name="num_tel")
	    private String numTEL;
	     
	    @Column(name="email", nullable=false, length=200)
	    private String email;

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

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getNumTEL() {
			return numTEL;
		}

		public void setNumTEL(String numTEL) {
			this.numTEL = numTEL;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public EmployeEntity(Long id, String nom, String prenom, String adresse, String numTEL, String email) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.numTEL = numTEL;
			this.email = email;
		}

		public EmployeEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

}
