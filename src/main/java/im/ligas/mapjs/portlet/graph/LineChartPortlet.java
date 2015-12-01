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
package im.ligas.mapjs.portlet.graph;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import im.ligas.mapjs.data.DataFile;
import im.ligas.mapjs.data.DummyDataProvider;
import im.ligas.mapjs.portlet.AbstractPortlet;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Miroslav Ligas
 */
public class LineChartPortlet extends AbstractPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(LineChartPortlet.class);

	@Override
	public void setModel(Map<String, Object> model, RenderRequest request) {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (int i = 1990; i < 2016; i++) {
			array.put(i);
		}
		model.put("labelData", array.toString());
	}

	public void getChartData(ResourceRequest request, ResourceResponse response) {
		String code = ParamUtil.getString(request, "countryCode");
		if (Validator.isNull(code)) {
			return;
		}

		try {
			JSONArray dataByCode = DummyDataProvider.getInstance()
					.getDataByCode(DataFile.CHILD_MORTALITY, code);
			writeJSON(request, response, dataByCode);
		} catch (IOException e) {
			LOG.error("could not send message.", e);
		}
	}
}
