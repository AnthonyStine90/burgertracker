<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="webjars/bootswatch/5.2.3/dist/sketchy/bootstrap.css"
    />
    <title>Whopper Whopper</title>
  </head>
  <body>
    <div class="container">
      <h1>Burger Tracker</h1>

      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Burger Name</th>
            <th scope="col">Restaurant Name</th>
            <th scope="col">Rating (out of 5)</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="burger" items="${burgers}">
            <tr class="table-info">
              <td>${burger.name}</td>
              <td>${burger.restaurantName}</td>
              <td>${burger.rating}</td>
              <td><a href="/burgers/edit/${burger.id}">Edit</a></td>
              <td>
                <form action="/burgers/${burger.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" class="btn btn-primary" value="Delete">
            </form></a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="container">
      <h1>Add a Burger:</h1>
      <!-- if we use data binding in spring you have to use form:form tags include the modelAttribute. built into jsp allowing us to prepopulate forms while editing and access the object when we create an instance    -->
      <form:form action="/burgers" method="post" modelAttribute="burger">
        <div class="form-control">
          <form:label path="name">Name</form:label>
          <form:errors path="name" />
          <form:input path="name"></form:input>
          <form:label path="restaurantName">Restaurant Name</form:label>
          <form:errors path="restaurantName" />
          <form:input path="restaurantName"></form:input>
          <form:label path="rating">Rating</form:label>
          <form:errors path="rating" />
          <form:input path="rating"></form:input>
          <form:label path="notes">Notes</form:label>
          <form:input path="notes"></form:input>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form:form>
    </div>
  </body>
</html>
