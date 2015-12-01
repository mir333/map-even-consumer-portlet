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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static im.ligas.mapjs.data.DataFile.*;

/**
 * @author Miroslav Ligas
 */
public class DummyDataProvider {
	private static final DummyDataProvider INSTANCE = new DummyDataProvider();

	private static final Log LOG = LogFactoryUtil.getLog(DummyDataProvider.class);
	private static final String HEADER = "header";
	private static final String DATA = "data";

	private static Map<String, JSONObject> data;

	public DummyDataProvider() {
		data = new HashMap<String, JSONObject>();

		data.put(CHILD_MORTALITY.toString(), readCSVFile(CHILD_MORTALITY.getFileName()));
		data.put(ROAD_TRAFIC_DETHS.toString(), readCSVFile(ROAD_TRAFIC_DETHS.getFileName()));
		data.put(URBANIOZATION.toString(), readCSVFile(URBANIOZATION.getFileName()));
	}

	public static DummyDataProvider getInstance() {
		return INSTANCE;
	}

	public JSONArray getDataByCode(DataFile dataFile, String code) {
		JSONObject dataSet = data.get(dataFile.toString());
		JSONObject data = dataSet.getJSONObject(DATA);
		return data.getJSONArray(code);
	}

	private JSONObject readCSVFile(String fileName) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		InputStream in = this.getClass().getClassLoader()
			.getResourceAsStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		try {
			String headerLine = br.readLine();
			if (headerLine == null) {
				return null;
			}

			result.put(HEADER, getDataHeader(headerLine));

			result.put(DATA, getData(br));
		} catch (Exception e) {
			LOG.error("Could not load data", e);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				//empty
			}
		}
		return result;
	}

	private JSONObject getData(BufferedReader br) throws IOException {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		String line;
		while ((line = br.readLine()) != null) {

			String[] lineValues = parseLine(line);

			if (lineValues != null) {
				String countryName = lineValues[0];
				String code = CountryMappingUtil.getCode(countryName);
				JSONArray storedData = result.getJSONArray(code);
				if (storedData == null) {
					storedData = JSONFactoryUtil.createJSONArray();
					result.put(code, storedData);
				}

				storedData.put(convertToJson(lineValues));
			}
		}
		return result;
	}

	private JSONArray getDataHeader(String headerLine) throws IOException {
		String[] headerLineArr = parseLine(headerLine);
		return convertToJson(headerLineArr);
	}

	private JSONArray convertToJson(String[] lineValues) {
		JSONArray result = JSONFactoryUtil.createJSONArray();
		for (String lineValue : lineValues) {
			result.put(lineValue);
		}
		return result;
	}

	private String[] parseLine(String line) {
		String[] split = line.split(",");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].replace("\"", "");
		}
		return split;
	}
}
