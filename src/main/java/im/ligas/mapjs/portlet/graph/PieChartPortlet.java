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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import im.ligas.mapjs.data.DataFile;
import im.ligas.mapjs.data.DummyDataProvider;
import im.ligas.mapjs.portlet.AbstractPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Ligas
 */
public class PieChartPortlet  extends AbstractPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(PieChartPortlet.class);
	private static final Map<String,Integer> YEARS = new HashMap<String, Integer>(){{
		put("1",2050);
		put("4",2020);
		put("5",2010);
		put("8",1980);
	}};


	@Override
	public void setModel(Map<String, Object> model, RenderRequest request) {
		PortletPreferences prefs = request.getPreferences();
		String dataIndex = prefs.getValue("dataIndex", "");
		model.put("dataIndex", dataIndex);
		model.put("year", YEARS.get(dataIndex));
	}

	public void savePrefs(ActionRequest request, ActionResponse response) throws ReadOnlyException, IOException, ValidatorException, PortletModeException {
		String name = request.getParameter("dataIndex");

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue("dataIndex", name);
		prefs.store();

		response.setPortletMode(PortletMode.VIEW);

	}

	public void getChartData(ResourceRequest request, ResourceResponse response){
		String code = ParamUtil.getString(request, "countryCode");
		if (Validator.isNull(code)) {
			return;
		}

		try {
			JSONArray dataByCode = DummyDataProvider.getInstance()
				.getDataByCode(DataFile.URBANIOZATION, code);
			writeJSON(request, response, dataByCode);
		} catch (IOException e) {
			LOG.error("could not send message.", e);
		}
	}

}
