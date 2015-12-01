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

<div id="content${ns}"></div>

<portlet:resourceURL id="getWebContent" var="getDescriptionURL"/>
<script type="text/javascript">
	AUI().ready('node', 'aui-io-request', function (A) {
		A.one(document).on('mapEvent:countrySelect', function (evt) {

			console.log(evt);
			A.io.request(
					'${getDescriptionURL}',
					{
						dataType: 'json',
						data:{
							'${ns}countryCode': evt
						},
						on: {
							success: function () {
								var data = this.get('responseData');
								var desc = "No description was provided.";
								if(data){
									desc = '<h1>'+data['title']+'</h1>';
									desc += data['description'];
								}
								A.one("#content${ns}").html(desc);
							}
						}
					}
			);
		});
	});
</script>
