<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<header>
    <h1>Welcome to New User Registration form </h1>
</header>

<style>

table {
    border: 1px solid black;
    position: absolute;
    top: 250px;
    right: 550px;
    width: 300px;
    height: 120px;
}

 body {
 background-color: 3b5998;
 }

 header {
     position: absolute;
     top: 20px;
     right: 200px;
     left: 375px  ;
 }


 button {

  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  margin: 365px 488.5px;
  border: none;
  cursor: pointer;
  width: 22.5%;

  }

 button:hover {
     opacity: 0.8;
 }

.clickhere{
  padding: -5px -20px;
  margin: -360px 490px;
  background-color: #D3D3D3;
  border: none;
  width: 22.5%;
}

</style>

<body>

	<font color="red">${errorMessage}</font>
	
	<form action="create" method="post">
		
		<table align="center" bgcolor="dde8e1">
			<tr>
				<td align="justify">Name </td>
				<td><input type="text" name="name" value="om" /><br></td>
			</tr>

			<tr>
				<td align="justify">Password </td>
				<td><input type="password" name="password" value="om" /><br></td>
			</tr>

		<button class="button" type="submit">Create Login</button>

		</table>

	</form>
</body>

</html>
