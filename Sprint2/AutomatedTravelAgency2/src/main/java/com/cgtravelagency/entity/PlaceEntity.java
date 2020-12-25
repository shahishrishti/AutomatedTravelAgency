package com.cgtravelagency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public class PlaceEntity {

	@Id
	@GeneratedValue
	@Column(name = "placeid")
	private Long placeId;
	
	@Column(name = "place")
	private String placeName;

	public PlaceEntity() {
		super();
	}

	public PlaceEntity(String placeName) {
		super();
		this.placeName = placeName;
	}

	public PlaceEntity(Long placeId, String placeName) {
		super();
		this.placeId = placeId;
		this.placeName = placeName;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "PlaceEntity [placeId=" + placeId + ", placeName=" + placeName + "]";
	}
	
}
