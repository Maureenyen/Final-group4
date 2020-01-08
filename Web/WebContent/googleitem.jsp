<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<script type="text/javascript"
	src="http://www.schillmania.com/projects/snowstorm/snowstorm.js"></script>

<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>


<body style="background-color: rgb(255, 230, 153);">
	<hr size="10px" color=black align="center" width="100%">
	<p>
		<img id="pooggle" alt="POOGLE" src="Pooggle.gif" style=""
			top: 20px; right: 500px; position:absolute;">
	</p>

	<form action='./TestProject' method='get'>
		<input type='text' name='keyword'
			placeholder='Input something about your pet....' size='45'
			style="top: 180px; right: 470px; position: absolute; border-width: 4px; border-style: solid; border-color: black; padding: 5px; background: rgba(0, 0, 0, 0);" />
		<input type='submit' value='➤' onclick=" showDiv()"
			style="top: 150px; right: 370px; position: absolute; width: 50px; height: 50px; font-size: 30px; background: rgba(0, 0, 0, 0);" />

		<div
			style="width: 1000px; height: 10000000; border: 6px black dashed; top: 240px; right: 570px; left: 250px; position: absolute;">

			<%
				String[][] orderList = (String[][]) request.getAttribute("query");
				for (int i = 0; i < orderList.length; i++) {
			%>

			<p>
				<a href='<%=orderList[i][1]%>'
					style="right: 400; font-size: 24px; color: black; font: serif;">
					<%=orderList[i][0]%>
				</a> <br> <br>
				<%
					}
				%>

				<br> <br>
			<hr size="10px" color=black align="center" width="100%">
			<div class="card-section"></div>
			<div class="brs-col"></div>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<div class="brs-col"></div>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<p class="nVcaUb">
				<a herf=""> </a>
			</p>
			<br>
			<div>
				<h3 style="text-align: center">相關搜尋</h3>
				<div>
					<ul style="list-style: none;">
					<%
				String[][] orderList1 = (String[][]) request.getAttribute("related");
				for (int i = 0; i < orderList1.length; i++) {
				%>
				<li>
				<a href='#'
					style="right: 400; font-size: 24px; color: black; font: serif;">
					<%=orderList1[i][0]%>
				</a> <br>
				</li>
				<%
					}
				%>
					</ul>
				</div>
			</div>

		</div>
</body>

</html>