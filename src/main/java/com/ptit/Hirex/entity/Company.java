package com.ptit.Hirex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "description")
	private String description;

	@Column(name = "employee_size")
	private int employeeSize;

	@Column(name = "head_office")
	private String headOffice;

	@Column(name = "industry")
	private String industry;

	@Column(name = "website")
	private String website;

	@Column(name = "image_base64", columnDefinition = "TEXT")
	private String imageBase64;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
