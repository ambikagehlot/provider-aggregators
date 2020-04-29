package com.ipa.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider_details")
public class ProviderAggregator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")  
	private int providerId;
	
	@Column(name = "provider_name")
	private String providerName;
	
	@Column(name = "provider_url")
	private String providerUrl;
	
	/*
	 * @Column(name = "provider_response_type") private String providerResponseType;
	 * 
	 * @Column(name = "provider_response_format") private String
	 * providerResponseFormat;
	 */
	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	/*
	 * public String getProviderResponseType() { return providerResponseType; }
	 * 
	 * public void setProviderResponseType(String providerResponseType) {
	 * this.providerResponseType = providerResponseType; }
	 * 
	 * public String getProviderResponseFormat() { return providerResponseFormat; }
	 * 
	 * public void setProviderResponseFormat(String providerResponseFormat) {
	 * this.providerResponseFormat = providerResponseFormat; }
	 */	
	
	
}
