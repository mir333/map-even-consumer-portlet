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
package im.ligas.mapjs.portlet.table;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import im.ligas.mapjs.data.DataFile;
import im.ligas.mapjs.portlet.AbstractPortlet;
import im.ligas.mapjs.data.DummyDataProvider;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

/**
 * @author Miroslav Ligas
 */
public class TableDetailPortlet extends AbstractPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(TableDetailPortlet.class);

	public void getTableData(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException, IOException {
		String code = ParamUtil.getString(request, "countryCode");
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("data", DummyDataProvider.getInstance()
				.getDataByCode(DataFile.CHILD_MORTALITY, code));
		writeJSON(request, response, data);

	}


}
