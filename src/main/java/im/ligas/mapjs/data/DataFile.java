/**
 * Copyright (c) 2015 Miroslav Ligas All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package im.ligas.mapjs.data;

/**
 * @author Miroslav Ligas
 */
public enum DataFile {
	CHILD_MORTALITY("child-mortality.csv"),
	URBANIOZATION("urbanization.csv"),
	ROAD_TRAFIC_DETHS("road-traffic-deaths.csv");

	private String fileName;

	DataFile(String fileName) {
		this.fileName = fileName;

	}

	public String getFileName() {
		return this.fileName;
	}
}
