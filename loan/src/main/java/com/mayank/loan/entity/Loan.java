package com.mayank.loan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "loan",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_name")
})
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;

	@JsonProperty("product_name")
	@Column(name = "product_name" , unique=true)
	private String product_name;

	@JsonProperty("principal_amount")
	@Column(name = "principal_amount")
	private float principal_amount;

	@JsonProperty("tenure")
	@Column(name = "tenure")
	private int tenure;

	@JsonProperty("rate")
	@Column(name = "rate")
	private double rate;

	@JsonProperty("is_Active")
	@Column(name = "is_Active")
	private boolean isActive;

	@JsonProperty("created_By")
	@Column(name = "created_By")
	private String createdBy;

	@JsonProperty("created_On")
	@Column(name = "created_On")
	private LocalDateTime createdOn;

	@JsonProperty("updated_By")
	@Column(name = "updated_By")
	private String updatedBy;

	@JsonProperty("updated_On")
	@Column(name = "updated_On")
	private LocalDateTime updatedOn;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrincipal_amount() {
		return principal_amount;
	}

	public void setPrincipal_amount(float principal_amount) {
		this.principal_amount = principal_amount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn() {
		LocalDateTime curr = LocalDateTime.now();
		

		this.createdOn = curr;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn() {
		LocalDateTime curr = LocalDateTime.now();

		this.updatedOn = curr;
	}

}
