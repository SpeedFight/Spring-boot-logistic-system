package com.bootLogisticSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * This class represent data entity for input/output reports.
 * @author Karol Łukasiewicz
 *
 */
@Entity
@JsonPropertyOrder({"clientId", "requestId", "name", "quantity", "price"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Request extends GenerateAble{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@NotBlank(message = "Client Id can't be empety")
	@Pattern(regexp = "^[\\p{Alnum}]{1,6}$",
			message = "Client Id must be between 1 and 6 long, alphanumeric characters without whitespaces between")
	private String clientId;

	@PositiveOrZero(message = "Request Id must be positive or zero")
	private int requestId;
	
	@NotBlank(message = "Name can't be empety")
	@Size(min = 1, max = 255, 
			message = "Name must be between 1 and 255 characters")
	private String name;
	
	@Min(value = 1, message = "Quantity must be greater than 1")
	private int quantity;
	
	@Positive(message = "Price must be positive number")
	private double price;
	
	public Request() {};	

	public Request(String clientId, int requestId, String name, int quantity, double price) {
		super();
		this.clientId = clientId;
		this.requestId = requestId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	@JsonSetter("Client_Id")
	private void setClientIdCSV(String clientId) {
		this.clientId = clientId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	@JsonSetter("Request_id")
	private void setRequestIdCSV(int requestId) {
		this.requestId = requestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonSetter("Name")
	private void setNameCSV(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@JsonSetter("Quantity")
	private void setQuantityCSV(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@JsonSetter("Price")
	private void setPriceCSV(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", clientId=" + clientId + ", requestId=" + requestId + ", name=" + name
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + requestId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (requestId != other.requestId)
			return false;
		return true;
	}
	
}
