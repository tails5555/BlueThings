<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
div.row div {
	line-height: 100px;
}

.container>.switch {
	display: block;
	margin: 12px auto;
}

.switch {
	position: relative;
	display: inline-block;
	vertical-align: top;
	width: 120px;
	height: 70px;
	padding: 3px;
	background-color: white;
	border-radius: 30px;
	box-shadow: inset 0 -1px white, inset 0 1px 1px rgba(0, 0, 0, 0.05);
	cursor: pointer;
	background-image: -webkit-linear-gradient(top, #eeeeee, white 25px);
	background-image: -moz-linear-gradient(top, #eeeeee, white 25px);
	background-image: -o-linear-gradient(top, #eeeeee, white 25px);
	background-image: linear-gradient(to bottom, #eeeeee, white 25px);
}

.switch-input {
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
}

.switch-label {
	position: relative;
	display: block;
	height: inherit;
	font-size: 30px;
	text-transform: uppercase;
	background: #eceeef;
	border-radius: inherit;
	box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.12), inset 0 0 2px
		rgba(0, 0, 0, 0.15);
	-webkit-transition: 0.15s ease-out;
	-moz-transition: 0.15s ease-out;
	-o-transition: 0.15s ease-out;
	transition: 0.15s ease-out;
	-webkit-transition-property: opacity background;
	-moz-transition-property: opacity background;
	-o-transition-property: opacity background;
	transition-property: opacity background;
}

.switch-label:before, .switch-label:after {
	position: absolute;
	top: 50%;
	margin-top: -.5em;
	line-height: 1;
	-webkit-transition: inherit;
	-moz-transition: inherit;
	-o-transition: inherit;
	transition: inherit;
}

.switch-label:before {
	content: attr(data-off);
	right: 11px;
	color: #aaa;
	text-shadow: 0 1px rgba(255, 255, 255, 0.5);
}

.switch-label:after {
	content: attr(data-on);
	left: 11px;
	color: white;
	text-shadow: 0 1px rgba(0, 0, 0, 0.2);
	opacity: 0;
}

.switch-input:checked ~ .switch-label {
	background: #47a8d8;
	box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.15), inset 0 0 3px
		rgba(0, 0, 0, 0.2);
}

.switch-input:checked ~ .switch-label:before {
	opacity: 0;
}

.switch-input:checked ~ .switch-label:after {
	opacity: 1;
}

.col-sm-7 {
	font-size: 20px;
	border-radius: 10px;
	margin: 10px;
	background: linear-gradient(#eff, #dee);
	border: 1px solid #dee width: 300px;
}

.col-sm-3 {
	margin-top: 30px;
}
.scrolltbody {
    display: block;
    width:740px;
    border-collapse: collapse;
    border: 2px solid #000;
}
.scrolltbody th { border: 1px solid #000; background: pink; font-size : 10px; text-align : center; }
.scrolltbody td { border: 1px solid #000; border-top: 0; }
.scrolltbody tbody {
    display: block;
    height: 200px;
    overflow: auto;
    font-size : 10px;
}
.scrolltbody th:nth-of-type(1), .scrolltbody td:nth-of-type(1) { width: 30px; }
.scrolltbody th:nth-of-type(2), .scrolltbody td:nth-of-type(2) { width: 30px; }
.scrolltbody th:nth-of-type(3), .scrolltbody td:nth-of-type(3) { width: 80px; }
.scrolltbody th:nth-of-type(4), .scrolltbody td:nth-of-type(4) { width: 150px; }
.scrolltbody th:nth-of-type(5), .scrolltbody td:nth-of-type(5) { width: 150px; }
.scrolltbody th:nth-of-type(6), .scrolltbody td:nth-of-type(6) { width: 150px; }
.scrolltbody th:last-child { width: 150px; }
.scrolltbody td:last-child { width: calc( 150px - 18px ); }
.scrolltbody2 {
    display: block;
    width: 210px;
    border-collapse: collapse;
    border: 2px solid #000;
}
.scrolltbody2 th { border: 1px solid #000; background: #A9F5F2; font-size : 10px; text-align : center; }
.scrolltbody2 td { border: 1px solid #000; border-top: 0; }
.scrolltbody2 tbody {
    display: block;
    height: 50px;
    overflow: auto;
    font-size : 10px;
}
.scrolltbody2 th:nth-of-type(1), .scrolltbody2 td:nth-of-type(1) { width: 60px; }
.scrolltbody2 th:last-child { width: 150px; }
.scrolltbody2 td:last-child { width: calc( 150px - 18px ); }
.arriveList{
	width : 80px;
	height : 40px;
	font-size : 15px;
}
</style>
</head>
<body>

	<div class="container">
		
		<div style="margin: 20px;">
			<img src="11.png" class="img-responsive" />
		</div>
		
		<div class="table-responsive">
		  <table class="scrolltbody2">
		    <thead>
	            <tr>
	            	<th>정류장 코드</th>
	            	<th>정류장 이름</th>
	            </tr>
	        </thead>
	        <tbody>
				<c:forEach var="station" items="${ stations }">
		          <tr>
		              <td>${ station.arsId }</td>
		              <td>${ station.stNm }</td>
		          </tr>
		        </c:forEach>
	        </tbody>
		  </table>
		</div>
		<br/>
		<div class="table-responsive">
		  <table class="scrolltbody">
		    <thead>
	            <tr>
	            	<th class="info">버스종류</th>
	                <th class="info">노선번호</th>
	                <th class="info">이동방향</th>
	                <th class="info">첫 번째 도착</th>
	                <th class="info">첫번째 버스 위치</th>
	                <th class="info">두 번째 도착</th>
	                <th class="info">두번째 버스 위치</th>
	            </tr>
	        </thead>
	        <tbody>
				<c:forEach var="bus" items="${ buses }">
		          <tr>
		              <td>${ bus.type }</td>
		              <td>${ bus.rtNm }</td>
		              <td>${ bus.adirection }</td>
		              <td>${ bus.arrmsg1 }</td>
		              <td>${ bus.stationNm1 }</td>
		              <td>${ bus.arrmsg2 }</td>
		              <td>${ bus.stationNm2 }</td>
		          </tr>
		        </c:forEach>
	        </tbody>
		  </table>
		</div>
		<hr/>
		<div class="form-inline">
			<h3> *곧 도착 예정 버스* </h3>
			<c:forEach var="arrive" items="${ arrives }">
				<c:if test="${ arrive.type eq '공항' }"><span class="label label-info arriveList">${ arrive.rtNm }</span></c:if>
				<c:if test="${ arrive.type eq '간선' }"><span class="label label-primary arriveList">${ arrive.rtNm }</span></c:if>
				<c:if test="${ arrive.type eq '지선' }"><span class="label label-success arriveList">${ arrive.rtNm }</span></c:if>
				<c:if test="${ arrive.type eq '마을' }"><span class="label label-warning arriveList">${ arrive.rtNm }</span></c:if>
				<c:if test="${ arrive.type eq '광역' }"><span class="label label-danger arriveList">${ arrive.rtNm }</span></c:if>
				<c:if test="${ arrive.type eq '기타' }"><span class="label label-info arriveList">${ arrive.rtNm }</span></c:if>
			</c:forEach>
		</div>
		<hr/>
		<div class="form-inline">
			<form:form method="get" modelAttribute="search" class="form-inline">
				<label>검색할 정류장 번호</label>
				<form:input path="arsId" class="form-control" placeholder="검색할 정류장 번호"/>
				<label>검색할 정류장 장소</label>
				<form:input path="stSrch" class="form-control" placeholder="검색할 정류장 장소"/>
				<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i> 검색</button>
			</form:form>
		</div>
		<hr/>
		<div class="row">
			<div class="col-sm-7" style="text-align: center;">
				<strong> 전등 스위치 </strong>
			</div>
			<div class="col-sm-3" style="text-align: center;">
				<label class="switch"> <input type="checkbox"
					class="switch-input" checked> <span class="switch-label"
					data-on="On" data-off="Off"></span> <span class="switch-handle"></span>

				</label>
			</div>
			<div class="col-sm-7" style="text-align: center;">
				<strong> 콘센트 스위치 </strong>
			</div>
			<div class="col-sm-3" style="text-align: center;">
				<label class="switch"> <input type="checkbox"
					class="switch-input" checked> <span class="switch-label"
					data-on="On" data-off="Off"></span> <span class="switch-handle"></span>
				</label>
			</div>
		</div>

	</div>



</body>
</html>