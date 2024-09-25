This project implements a user registration and login system with servlets in Java. It uses a MySQL database to store user information.

Here's a breakdown of the functionalities:

1. RegistrationServlet:
This servlet handles user registration requests submitted via a form (registration.jsp).
It retrieves user information from the request parameters: name, email, password, and mobile number.
The servlet connects to the MySQL database using JDBC and a prepared statement to prevent SQL injection vulnerabilities.
It inserts the user data into the registration_users table.
Based on the number of rows affected (success or failure), the servlet dispatches the user to either:
registration.jsp with a "success" status message.
login.jsp with a "failed" status message.

2. login Servlet:
This servlet handles user login requests submitted via a form (presumably in login.jsp).
It retrieves the email and password from the request parameters.
It connects to the MySQL database and uses a prepared statement to check for a matching email and password in the registration_users table.
If a valid user is found:
A session is created and the user's name is stored as a session attribute.
The user is forwarded to the index.jsp page (presumably the main application page).
If the login fails:
A "failed" status message is set as a request attribute.
The user is redirected back to the login.jsp page.

3. JSP Integration (implicit in login.jsp):
The provided code snippet demonstrates a way to check if a user is logged in using sessions in a JSP page.
It checks if the name attribute is present in the session. If not, it redirects the user to the login.jsp page.

Overall, this project demonstrates a basic user registration and login system using Java servlets and a MySQL database.
