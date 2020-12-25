package com.cgtravelagency.json;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VehicleType {
	
	@Min(value = 1, message = "Minimum value of Vehicle Type ID should be 1")
	private Long typeId;
	
	@NotNull
	@NotBlank
	private String typeName;
	
	@Min(value = 2, message = "Minimum value of seatingCapacity should be 2")
	private int seatingCapacity;
	
	private Set<Vehicle> vehicles;
	
	public VehicleType() {
		super();
	}

	public VehicleType(String typeName, int seatingCapacity) {
		super();
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
	}

	public VehicleType(Long typeId, String typeName, int seatingCapacity) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
	}
	

	public VehicleType(@Min(value = 1, message = "Minimum value of Vehicle Type ID should be 1") Long typeId,
			@NotNull @NotBlank String typeName,
			@Min(value = 2, message = "Minimum value of seatingCapacity should be 2") int seatingCapacity,
			Set<Vehicle> vehicles) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
		this.vehicles = vehicles;
	}

	public VehicleType(@NotNull @NotBlank String typeName,
			@Min(value = 2, message = "Minimum value of seatingCapacity should be 2") int seatingCapacity,
			Set<Vehicle> vehicles) {
		super();
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
		this.vehicles = vehicles;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "VehicleType [typeId=" + typeId + ", typeName=" + typeName + ", seatingCapacity=" + seatingCapacity
				+ ", vehicles=" + vehicles + "]";
	}

	
	
}
