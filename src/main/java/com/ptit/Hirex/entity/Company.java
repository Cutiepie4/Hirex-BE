package com.ptit.Hirex.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

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

	@JsonIgnore()
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Work> works;

	@JsonIgnore()
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@OrderBy("updatedAt DESC")
	private List<Review> reviews;

	@Transient
	public double getAvgOverallRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getOverallRate)
				.average()
				.orElse(0.0) * 10) / 10;
	}
	@Transient
	public double getAvgSalaryRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getSalaryRate)
				.average()
				.orElse(0.0) * 10) / 10;
	}
	@Transient
	public double getAvgTrainingRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getTrainingRate)
				.average()
				.orElse(0.0) * 10) / 10;
	}
	@Transient
	public double getAvgManagementRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getManagementRate)
				.average()
				.orElse(0.0) * 10) / 10;
	}
	@Transient
	public double getAvgCultureRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getCultureRate)
				.average()
				.orElse(0.0) * 10) / 10;
	}
	@Transient
	public double getAvgOfficeRate() {
		return (double) Math.round(reviews
				.stream()
				.mapToInt(Review::getOfficeRate)
				.average()
				.orElse(0.0) * 10) / 10; 
	}

	@Transient
	public long getRecommendPercent() {
		double totalReviews = reviews.size();
		long recommendTrue = reviews
				.stream()
				.filter(Review::isRecommend)
				.count();
		return Math.round(recommendTrue / totalReviews * 100);
	}

	@Transient
	public long getFiveOverallRate() {
		double totalReviews = reviews.size();
		long rateReq = reviews.stream()
				.filter(review -> review.getOverallRate() == 5)
				.count();
		return Math.round(rateReq / totalReviews * 100);
	}
	@Transient
	public long getFourOverallRate() {
		double totalReviews = reviews.size();
		long rateReq = reviews.stream()
				.filter(review -> review.getOverallRate() == 4)
				.count();
		return Math.round(rateReq / totalReviews * 100);
	}
	@Transient
	public long getThreeOverallRate() {
		double totalReviews = reviews.size();
		long rateReq = reviews.stream()
				.filter(review -> review.getOverallRate() == 3)
				.count();
		return Math.round(rateReq / totalReviews * 100);
	}
	@Transient
	public long getTwoOverallRate() {
		double totalReviews = reviews.size();
		long rateReq = reviews.stream()
				.filter(review -> review.getOverallRate() == 2)
				.count();
		return Math.round(rateReq / totalReviews * 100);
	}
	@Transient
	public long getOneOverallRate() {
		double totalReviews = reviews.size();
		long rateReq = reviews.stream()
				.filter(review -> review.getOverallRate() == 1)
				.count();
		return Math.round(rateReq / totalReviews * 100);
	}

}
