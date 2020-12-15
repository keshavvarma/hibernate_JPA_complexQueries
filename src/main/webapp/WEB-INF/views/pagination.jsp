<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagination</title>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
</head>
<body>
<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Student id</th>
                <th>Student name</th>
                <th>DOB</th>
                <th>Age</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Student id</th>
                <th>Student name</th>
                <th>DOB</th>
                <th>Age</th>
            </tr>
        </tfoot>
    </table>
    <br>
    <br>
    <br>
    <button id="moreElement">More Element</button>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    
    <script type="text/javascript">
	    $(document).ready(function() {
	    	var pageNumber = 1;
	    	//var table;
	    	const URL = "http://localhost:8080/hibernateWithSpringJPA/student/findRecords.do";
	    	  
    	 	var loadRecords = function loadRecords(){
    	 		table = $('#example').DataTable({
    	 			"processing": true,
    	 			"pageLength": 10,
		    		 ajax: {
		    			 url: URL + "?pageNumber=" + pageNumber,
		    			 dataSrc: 'aaData'
		    			/*  ,
		                 dataFilter: function(data){
			                    var json = jQuery.parseJSON( data );
			                    console.log(json);
			                    json.recordsTotal = json.recordsTotal;
			                    json.recordsFiltered = json.recordsFiltered;
			                    json.data = json.aaData;
			                    return JSON.stringify( json ); // return JSON string
			                } */
		    		 	},
		    		 columns: [
		    			 	{data:"studentId"},
		    			 	{data:"name"},
		    			 	{data:"dob"},
		    			 	{data:"age"}	    			 	
		    		 	],
		    		 	bDestroy: true
		    	 });
	    	 }
    	 	loadRecords();
    	 	
	    	 $("#moreElement").click(function(){
	    		 pageNumber++;
	    		// table.ajax.reload();
	    		 loadRecords();
	    	 });
	    	 
	    /* var table = $('#example').DataTable({
	            "processing": true,
	            "serverSide": true,
	            "ajax": {
	            	url: URL,
	            	data: {
	            		"pageNumber": pageNumber
	            	}
	            },
	            columns: [
    			 	{data:"studentId"},
    			 	{data:"name"},
    			 	{data:"dob"},
    			 	{data:"age"}	    			 	
    		 	]
	        }); */
	    });
    </script>
</body>
</html>