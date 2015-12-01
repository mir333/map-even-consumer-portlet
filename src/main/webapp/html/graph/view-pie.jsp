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

<div id="content${ns}" style="height: 200px">
	<div style="position: relative">
		<h3 class="chart-label" style="position: absolute;top:70px;left: 42%">${year}</h3>
	</div>
</div>

<portlet:resourceURL id="getChartData" var="getChartDataURL"/>
<script type="text/javascript">

	AUI().ready('node', 'aui-io-request', function (A) {

		var chart = new Chartist.Pie('#content${ns}',
				{
					series: []
				},
				{
					donut: true,
					donutWidth: 40,
					startAngle: 270,
					total: 100,
					fullWidth: true,
					showLabel: true
				});

		chart.on('draw', function (data) {
			if (data.type === 'slice') {
				var pathLength = data.element._node.getTotalLength();

				data.element.attr({
					'stroke-dasharray': pathLength + 'px ' + pathLength + 'px'
				});

				var animationDefinition = {
					'stroke-dashoffset': {
						id: 'anim' + data.index,
						dur: 1000,
						from: -pathLength + 'px',
						to: '0px',
						easing: Chartist.Svg.Easing.easeOutQuint,
						fill: 'freeze'
					}
				};

				if (data.index !== 0) {
					animationDefinition['stroke-dashoffset'].begin = 'anim' + (data.index - 1) + '.end';
				}

				data.element.attr({
					'stroke-dashoffset': -pathLength + 'px'
				});

				data.element.animate(animationDefinition, false);
			}
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
								console.log(responseData);
								if (responseData) {
									responseData = responseData[0];
									chart.update({series: [responseData[${dataIndex}]]});
								}
							}
						}
					});
		});
	});
</script>
