package com.cgtravelagency.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicletype")
public class VehicleTypeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "typeid")
	private Long typeId;
	
	@Column(name = "typename")
	private String typeName;
	
	@Column(name = "seatingcapacity")
	private int seatingCapacity;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY, mappedBy = "vehicleType")
	private Set<VehicleEntity> vehicles;
	
	public VehicleTypeEntity() {
		super();
	}

	public VehicleTypeEntity(String typeName, int seatingCapacity) {
		super();
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
	}

	public VehicleTypeEntity(Long typeId, String typeName, int seatingCapacity) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
	}

	public VehicleTypeEntity(String typeName, int seatingCapacity, Set<VehicleEntity> vehicles) {
		super();
		this.typeName = typeName;
		this.seatingCapacity = seatingCapacity;
		this.vehicles = vehicles;
	}
	

	public VehicleTypeEntity(Long typeId, String typeName, int seatingCapacity, Set<VehicleEntity> vehicles) {
		super();
		this.typeId = typeId;
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

	public Set<VehicleEntity> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<VehicleEntity> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "VehicleTypeEntity [typeId=" + typeId + ", typeName=" + typeName + ", seatingCapacity=" + seatingCapacity
				+ ", vehicles=" + vehicles + "]";
	}
	
}
