<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello

<script>
function updated(element)
{
    var idx=element.selectedIndex;
    var val=element.options[idx].value;
    var content=element.options[idx].innerHTML;
    alert(val + " " + content);
 }
</script>

<select name="select" onchange="updated(this)">
    <option value="1">pomme</option>
    <option value="2">orange</option>
    <option value="3">cerise</option>
</select>

</body>
</html>