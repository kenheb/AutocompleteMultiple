<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<style type="text/css" media="all">
.ui-autocomplete {
    position: absolute;
    cursor: default;
    height: 200px;
    width: 250px;
    font-size:14px;
    overflow-y: scroll;
    overflow-x: hidden;}
</style>

<script type="text/javascript">
$(document).ready(function(){
	var ac_config = {
			source: function(request, response) {
	            $.ajax({
	                url: "AutocompleteServlet",
	                dataType: "json",
	                data: request,
	                success: function( data, textStatus, jqXHR) {
	                   	 var items = data;
	                     response(items);
	                },
	                error: function(jqXHR, textStatus, errorThrown){
	                	alert("Error occurred!");
	                }
	            });
	        }, 

		select: function(event, ui){
			$("#name").val(ui.item.city);
			$("#address").val(ui.item.address);
			$("#zip").val(ui.item.zip);
			$("#municipality").val(ui.item.municipality);
			$("#phone").val(ui.item.phone);
		},
		minLength:1
	};
	$("#name").autocomplete(ac_config, {scroll: true});
	
});
</script>

<title>AutocompleteMultiple</title>
</head>
<body>

	 <p><label>Name</label><br />
		 <input type="text" name="name" id="name" value="" /></p>
	 <p><label>Address</label><br />
		 <input type="text" name="address" id="address" value="" /></p>
	 <p><label>Zip</label><br />
	 	 <input type="text" name="zip" id="zip" value="" /></p>
	 <p><label>Municipality</label><br />
	 	 <input type="text" name="municipality" id="municipality" value="" /></p>
	 <p><label>Phone</label><br />
	 	 <input type="text" name="phone" id="phone" value="" /></p>

</body>
</html>


