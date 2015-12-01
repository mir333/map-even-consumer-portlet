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
package im.ligas.mapjs.portlet.wc;


import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import im.ligas.mapjs.portlet.AbstractPortlet;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author Miroslav Ligas
 */
public class WebContentDetailPortlet extends AbstractPortlet {

	public void getWebContent(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException, IOException {


		String code = ParamUtil.getString(request, "countryCode");
		if (Validator.isNull(code)) {
			return;
		}

		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(td.getCompanyId(), JournalArticle.class.getName());
		ExpandoColumn countryCode = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "countryCode");

		List<ExpandoValue> list = Collections.emptyList();
		if (countryCode != null) {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class);
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", countryCode.getCompanyId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("columnId", countryCode.getColumnId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("data", code));
			list = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);
		}

		if (!list.isEmpty()) {
			Locale locale = PortalUtil.getLocale(request);
			JournalArticle article = JournalArticleLocalServiceUtil.getArticle(list.get(0).getClassPK());
			String content = JournalContentUtil.getContent(td.getScopeGroupId(), article.getArticleId(), null, LocaleUtil.toLanguageId(locale), td);
			JSONObject data = JSONFactoryUtil.createJSONObject();
			data.put("country", code);
			data.put("description", content);
			data.put("title", article.getTitle(locale));
			writeJSON(request, response, data);
		}
	}

}
