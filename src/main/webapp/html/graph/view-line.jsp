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

<div id="content${ns}" style="height: 400px">
	<div class="checkbox" style="position: relative;">
		<label class="checkbox" style="position: absolute;
    right: 15px;
    top: 20px;"><input type="checkbox">Compare</label>
	</div>
</div>

<portlet:resourceURL id="getChartData" var="getChartDataURL"/>
<script type="text/javascript">

	AUI().ready('node', 'aui-io-request', function (A) {
		var labelData = JSON.parse('${labelData}');
		var dataSet = [];

		var chart = new Chartist.Line('#content${ns}',
				{
					labels: labelData,
					series: []
				},
				{
					fullWidth: true,
					chartPadding: {
						right: 10
					},
					lineSmooth: Chartist.Interpolation.cardinal({
						fillHoles: true
					}),
					low: 0
				});

		A.one(document).on('mapEvent:countrySelect', function (evt) {

			A.io.request(
					'${getChartDataURL}',
					{
						dataType: 'json',
						data: {
							'${ns}countryCode': evt
						},
						on: {
							success: function (evt) {
								var responseData = this.get('responseData');
								var usefulData = responseData.map(function (value, index) {
									return value[2].replace(/^(\d+)(.+$)/i, '$1');
								});
								usefulData = usefulData.reverse();
								if (usefulData) {
									var compare = A.one("#content${ns} input").get('checked');
									if(!compare){
										dataSet = [];
									}
									dataSet.push(usefulData);
									chart.update({labels: labelData,series: dataSet});
								}
							}
						}
					});
		});
	});
</script>
