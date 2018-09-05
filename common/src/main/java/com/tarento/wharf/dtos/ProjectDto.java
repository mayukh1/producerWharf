package com.tarento.wharf.dtos;

public class ProjectDto {
	private Long id;
	private String name;
	private String details;
	private Long startDate;
	private Long releseDate;
	private long duration;
	private String year;
	private String country;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Long getStartDate() {
		return startDate;
	}
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	public Long getReleseDate() {
		return releseDate;
	}
	public void setReleseDate(Long releseDate) {
		this.releseDate = releseDate;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
