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

<form action="<portlet:actionURL name="savePrefs"/>" method="post" name="<portlet:namespace />fm">
	<label for="<portlet:namespace />dataIndex">Year:</label>
	<select	name="<portlet:namespace />dataIndex">
		<option value="1">2050</option>
		<option value="4">2020</option>
		<option value="5">2010</option>
		<option value="8">1980</option>
	</select>

	<input  class="btn" type="submit" value="Save"/>
</form>
