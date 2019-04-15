<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/bootstrapMeta.jsp" />
<title>Cities</title>
<jsp:include page="includes/bootstrapCss.jsp" />
<link
	href="http://www.malot.fr/bootstrap-datetimepicker/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
</head>
<body>
	<div class="container" role="main">
 
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form class="form-horizontal" method="post" action="changeEmployee">
					<fieldset>
						<legend>Change City ${city.name}</legend>
 
						<! ----------------  name ---------------- -->
						<div class="form-group">
							<label for="inputName" class="col-md-2 control-label">Name</label>
							<div class="col-md-10">
								<input class="form-control" id="inputName" type="text" name="name"
									readonly value="<c:out value="${city.name}"/>">
							</div>
						</div>
 
						<! ----------------  country ---------------- -->
						<div class="form-group">
							<label for="inputCountry" class="col-md-2 control-label">Country</label>
							<div class="col-md-10">
								<input class="form-control" id="inputCountry" type="text"
									name="country" value="<c:out value="${city.country}"/>">
							</div>
						</div>
 
						<! ----------------  state ---------------- -->
						<div class="form-group">
							<label for="inputState" class="col-md-2 control-label">State</label>
							<div class="col-md-10">
								<input class="form-control" id="inputState" type="text"
									name="state" value="<c:out value="${city.state}"/>">
							</div>
						</div>
 
						<! ----------------  population ---------------- -->
						<div class="form-group">
							<label for="inputPupulation" class="col-md-2 control-label">Population</label>
							<div class="col-md-10">
								<input class="form-control" id="inputPupulation" type="text"
									name="population" value="<c:out value="${city.population}"/>">
							</div>
						</div>
 
						<! ----------------  buttons ---------------- -->
						<div class="form-group">
							<div class="col-md-10 col-md-offset-2">
								<button type="submit" class="btn btn-primary">Submit</button>
								<a href="listCities" class="btn btn-default">Cancel</a>
							</div>
						</div>
 
					</fieldset>
				</form>
			</div>
		</div>
 
	</div>
	<!--  End of container -->
 
 
<!-- JS for Bootstrap -->
	<%@include file="includes/bootstrapJs.jsp"%>
<!-- JS for Bootstrap -->
 
 
<!-- JS for Datetime picker -->
 
	<script type="text/javascript"
		src="http://www.malot.fr/bootstrap-datetimepicker/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
 
	<script>
		$(function() {
 
			$(".form_datetime").datetimepicker({
				format : "dd.mm.yyyy",
				autoclose : true,
				todayBtn : true,
				pickerPosition : "bottom-left",
				minView : 2
			});
 
		});
	</script>
 
</body>
</html>