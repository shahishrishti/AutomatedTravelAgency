package com.cgtravelagency.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Place {
	
	@Min(value = 1)
	private Long placeId;
	
	@NotNull
	@NotBlank
	private String placeName;

	public Place() {
		super();
	}

	public Place(@NotNull @NotBlank String placeName) {
		super();
		this.placeName = placeName;
	}

	public Place(@Min(1) Long placeId, @NotNull @NotBlank String placeName) {
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
		return "Place [placeId=" + placeId + ", placeName=" + placeName + "]";
	}
		
}
