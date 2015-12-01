<%--
/**
 * Copyright (c) 2015 Miroslav Ligas All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<portlet:defineObjects/>
<c:set var="ns"><portlet:namespace/></c:set>

<div>
	<table id="dataTable${ns}" class="display" cellspacing="0" width="100%">
		<thead>
		<tr>
			<th>Country</th>
			<th>Year</th>
			<th title="probability of dying between birth and age 1 per 1000 live births">Infant mortality rate</th>
			<th title="per 1000 live births">Neonatal mortality rate</th>
			<th title="probability of dying by age 5 per 1000 live births">Under-five mortality rate</th>
		</tr>
		</thead>
	</table>
</div>

<portlet:resourceURL id="getTableData" var="getTableDataURL"/>
<script type="text/javascript">

	AUI().ready('node', 'aui-io-request', function (A) {

		var ajaxParam;

		var dataTable = $('#dataTable${ns}').DataTable({
			"paging":   true,
			"sDom": '<"top">rt<"bottom"lp><"clear">',
			"ajax": {
				"url": '${getTableDataURL}',
				"type": 'POST',
				"data": function(){return {'${ns}countryCode':ajaxParam}}
			}
		});



		A.one(document).on('mapEvent:countrySelect', function (evt) {

			console.log(evt);
			ajaxParam = evt;
			dataTable.ajax.reload();
		});


	});
</script>
