<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RemoveBus</title>
    <link type="image/png" sizes="20x20" rel="icon" href="../images/icons8-bus-16.png">
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .container-fluid {
            position: absolute;
        }

        .navbar {
            width: 99vw;
            position: sticky;
            top: 0;
            z-index: 2;
            display: flex;
            align-items: center;
        }

        .navbar-brand {
            position: relative;
            left: 2%;
        }

        .body-content {
            position: relative;
            width: 96vw;
            height: 100vh;
            /* overflow: scroll; */
            /* display:grid;
        grid-template-columns: auto; */
        }

        .btn {
            position: relative;
            right: 2%;
            width: 5vw;

        }

        .sidebar-nav {
            width: 20%;
            height: 100%;
            background-color: antiquewhite;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            position: fixed;
            z-index: 1;
        }

        .sidebar-nav a {
            text-decoration: none;
            font-weight: bold;
            color: black;
            width: 10vw;
        }

        .content-part {
            display: flex;
            justify-content: center;
            width: 60%;
            height: 70%;
            z-index: 0;
            position: relative;
            left: 30%;
            top: 15%;
            border-radius: 10px;
            border: 2px solid rgb(184, 221, 224);
            box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 6px -1px,
                rgba(0, 0, 0, 0.06) 0px 2px 4px -1px;
        }

        form {
            position: relative;
            top: 14%;
            padding: 5%;
            height: 60%;
        }

        th {
            position: relative;
            bottom: 2vh;
            padding: 1%;
            width: 5vw;
        }

        input {
            padding: 2%;
            width: 20vw;
            border-radius: 10px;
            border: 1px solid;
            background-color: rgb(255, 255, 255);
        }

        input[type="submit"] {
            padding: 2%;
            width: 80%;
            border-radius: 30px;
            position: relative;
            top: 3vh;
            color: azure;
            font-weight: bold;
        }
    </style>


</head>

<body>
    <div class="container-fluid p-0 m-0 ">

        <nav class="navbar bg-warning">
            <!-- <div class="container-fluid bg-warning"> -->
            <span class="navbar-brand h1">Admin</span>
             <!-- </div> -->
        </nav>
        <div class="body-content ">

            <div class="sidebar-nav bg-body-tertiary p-5">
                <a href="addBus.jsp" class="btn btn-outline-warning p-2">Add Bus</a>
                <a href="addTrip.jsp" class="btn btn-outline-warning p-2">Add Trip</a>
                <a href="adminActivity.jsp" class="btn btn-outline-warning p-2">Home</a>
                <a href="removeTrip.jsp" class="btn btn-outline-warning p-2">Remove Trip</a>
            </div>

            <div class="content-part bg-body-tertiary ">
                <form action="removeBusServlet" method="post">
                    <table>
                        <tr>
                            <th>
                                <label for="busId">Bus ID:</label>
                            </th>

                            <td>
                                <input type="text" id="busId" name="busId"><br><br>
                            </td>
                        </tr>
                    </table>
                    <center><input type="submit" value="Submit" class="bg-success" /></center>
                </form>


            </div>
        </div>
</body>

</html>