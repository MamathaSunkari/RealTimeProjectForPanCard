package com.project.pan.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "pancard")
public class PanCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	@NotNull(message = "{PAN number must not be null}")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "{PAN number must follow the format ABCDE1234F}")
	private String panNumber;
	
	@NotNull(message = "{Name must not be null}")
	 @Column(nullable = false)
	private String name;
	
	@NotNull(message = "{Date of birth must not be null}")
	private String dob;
	
	@NotNull(message = "{Address must not be null}")
	private String address;
	
	public PanCard() {
		// TODO Auto-generated constructor stub
	}

	public PanCard(String panNumber, String name, String dob, String address) {
		super();
		this.panNumber = panNumber;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}