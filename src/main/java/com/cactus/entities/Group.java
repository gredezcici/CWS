package com.cactus.entities;

import java.util.List;

public class Group {
	private String id;
	private String group_name;
	private List<String> accessLevels;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public List<String> getAccessLevels() {
		return accessLevels;
	}
	public void setAccessLevels(List<String> accessLevels) {
		this.accessLevels = accessLevels;
	}
}
