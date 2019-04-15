<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/bootstrapMeta.jsp" />
<title>Cities</title>
<jsp:include page="includes/bootstrapCss.jsp" />
</head>
<body>
	<div class="container" role="main">
 
		<div class="page-header">
        	<h1>City Management</h1>
      	</div>
 
		<!--  Messages  ----------------------------------------------------------- -->
 		<!--  Error message ----------------------------------------------------------- -->
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
		<!--  Error message ----------------------------------------------------------- -->
 
		<!--  Warning message ----------------------------------------------------------- -->
		<c:if test="${not empty warningMessage}">
			<div class="alert alert-warning" role="warning">${warningMessage}</div>
		</c:if>
		<!--  Warning message ----------------------------------------------------------- -->
 
		<!--  successful message ----------------------------------------------------------- -->
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="warning">${message}</div>
		</c:if>
		<!--  Messages  ----------------------------------------------------------- -->
 
 
		<!--  Search bar ----------------------------------------------------------- -->
		<jsp:include page="includes/searchNav.jsp" />
		<!--  Search bar ----------------------------------------------------------- -->
 
		<!--  2 simple buttons ----------------------------------------------------------- -->
 		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p>
					<a href="newCity.jsp" class="btn btn-success">Add new City</a>
					<a href="fillCitiesList" class="btn btn-success">Fill List</a>
				</p>
			</div>
		</div>
		<!--  2 simple buttons ----------------------------------------------------------- -->
 
 
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
 
				<table data-toggle="table" class="table table-striped" data-sortable="true">
					<thead>
						<tr>
							<th data-sortable="true">Name</th>
							<th data-sortable="true">Country</th>
							<th data-sortable="true">State</th>
							<th data-sortable="true">Population</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
					<!--  list all cities ----------------------------------------------------------- -->
 						<c:forEach items="${cities}" var="city">
							<tr>
								<td>${city.name}</td>
								<td>${city.country}</td>
								<td>${city.state}</td>
								<td>${city.population}</td>
 
								<td>
									<a href="editCity?name=${city.name}" class="btn btn-xs btn-success">Edit</a> 
									<a href="deleteCity?name=${city.name}" class="btn btn-xs btn-danger">Delete</a>
								</td>
							</tr>
						</c:forEach>
					<!--  list all cities ----------------------------------------------------------- -->
					</tbody>
				</table>
			</div>
		</div>
 
 
	</div>	<!--  End of container -->
 
<!-- JS for Bootstrap -->
	<%@include file="includes/bootstrapJs.jsp"%>
<!-- JS for Bootstrap -->
 
</body>
</html>