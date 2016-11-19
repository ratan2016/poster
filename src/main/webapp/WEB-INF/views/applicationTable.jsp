<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	$(document).ready(function(){
		$("#applicationTable").dataTable({
	        "aLengthMenu": [5, 10, 20, 50],
	        "iDisplayLength": 5,
	        "aaSorting": [[ 1, "asc" ]],
	        "aoColumns":[
	                     {"bSortable": false},
	                     {"bSortable": true},
	                     {"bSortable": true}
	                 ]
	    });
	});
</script>
<form role="form">
	<table class="table table-responsive table-striped"
		id="applicationTable">
		<thead>
			<th class="select-radio">&nbsp;&nbsp;&nbsp;</th>
			<th>Bundle Name</th>
			<th>Bundle Description</th>

		</thead>
		<tbody>

			<c:forEach var="api" items="${apiBundleList}">
				<tr>
					<td><input type="radio" name="selectRadio"
						onclick="dataFiller(this)" class="form-control"
						style="box-shadow: none" id="${api.id}" /></td>
					<td id="bundleName_${api.id}"><c:out value="${api.bundleName}" /></td>
					<td id="bundleDescription_${api.id}"><c:out
							value="${api.bundleDescription}" /></td>

				</tr>
			</c:forEach>

		</tbody>

	</table>
</form>