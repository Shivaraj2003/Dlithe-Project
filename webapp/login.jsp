 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login Page</title>
  <link type="image/png" sizes="20x20" rel="icon" href="../images/icons8-bus-16.png" />
  <!-- bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"></script>
  <style>
    * {
      margin: 0;
      padding: 0;
    }

    .login {
      width: 50vw;
      
      display: flex;
      flex-direction: column;
      /* justify-content: center; */
      position: relative;
      top: 15vh;
      background-color: rgb(255, 255, 255);
      box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px,
        rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
    }

    h1 {
      position: relative;
      right: 20vh;
      margin: 10vh;
      color: #c5c3c3;
    }

    input {
      padding: 1vh;
      border: transparent;
      border-bottom: 3px solid #ccc;
      width: 25vw;
    }
    

    form {
      position: relative;
      bottom: 10%;
    }

    input[type="submit"] {
      position: relative;
      top: 15%;
    }

    .container-fluid {
      background-color: #ccc;
      height: 100vh;
    }
  </style>
</head>

<body>
  <div class="container-fluid">
    <center>
      <div class="container login">
        <h1 >Login</h1>
        <form action="loginServlet" method="POST">
          <!-- <label for="username">Username:</label> -->
          <input type="text" id="username" name="username" placeholder="Username" required /><br /><br />
          <!-- <label for="password">Password:</label> -->
          <input type="password" id="password" name="password" placeholder="Password" required /><br /><br />
          <input type="submit" value="Login" class=" btn-outline-warning"  /><br /><br />
          
        </form>
      </div>
    </center>
  </div>
</body>

</html>