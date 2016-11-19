<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#apiDocumentTable").dataTable({
	        "aLengthMenu": [5, 10, 20, 50],
	        "iDisplayLength": 5,
	        "aaSorting": [[ 1, "asc" ]],
	        "aoColumns":[
	                     {"bSortable": false},
	                     {"bSortable": true},
	                     {"bSortable": true},
	                     {"bSortable": true}
	                 ]
	    });
	});
</script>
<form role="form">
	<table class="table table-responsive table-striped" id="apiDocumentTable">
		<thead>
			<th class="select-radio">&nbsp;&nbsp;&nbsp;</th>
			<th>Document Name</th>
			<th>Document Description</th>
			<th>API Bundle Name</th>

		</thead>
		<tbody>

			<c:forEach var="document" items="${apiDocumentList}">
				<tr>
					<td><input type="radio" name="selectRadio" onclick="dataFiller(this)" class="form-control" style="box-shadow:none" id="${document.id}" />
					</td>
					<td id="documentName_${document.id}"><c:out value="${document.documentName}" /></td>
					<td id="documentDescription_${document.id}"><c:out value="${document.documentDescription}" /></td>
					<td id="bundleId_${document.id}"><c:out value="${apiBundleMap[document.bundleId]}" />
					<input type="hidden" id="bundle_hidden_${document.id}" value="${document.bundleId}">
					</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>
</form>