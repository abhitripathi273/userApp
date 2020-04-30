package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
public class ShippingAddress {

	@Id
	private Integer pinCode;
	private String area;
	private String district;
	private String state;
	private String country;
	private boolean defaultAddress;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	/**
	 * @param pinCode
	 * @param area
	 * @param district
	 * @param state
	 * @param country
	 * @param defaultAddress
	 * @param user
	 */
	public ShippingAddress(Integer pinCode, String area, String district, String state, String country,
			boolean defaultAddress, User user) {
		super();
		this.pinCode = pinCode;
		this.area = area;
		this.district = district;
		this.state = state;
		this.country = country;
		this.defaultAddress = defaultAddress;
		this.user = user;
	}
	/**
	 * @return the pinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the defaultAddress
	 */
	public boolean isDefaultAddress() {
		return defaultAddress;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "ShippingAddress [pinCode=" + pinCode + ", area=" + area + ", district=" + district + ", state=" + state
				+ ", country=" + country + ", defaultAddress=" + defaultAddress + "]";
	}
	
}
