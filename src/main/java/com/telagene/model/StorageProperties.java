package com.telagene.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is responsible to define application properties.
 */

@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
