<h1>Day Care Web Application</h1><br>

<h2>Project Description :</h2> 
This is a web application designed for a daycare center named <b>Little Angels Day Care</b>, located in Bengaluru. The application provides a simple interface for parents and child care workers to register, log in and view updates on daily activities and special events. <br> <br> <br> <br>

<h2>Project Structure :</h2>
<h3>Technologies Used :</h3> 
<ul><li><b>Frontend : </b>HTML5, CSS3</li>
<li><b>Backend : </b>Java Servlets 6.0, Java SE 21</li>
  <li><b>Database : </b>MySQL</li>
  <li><b>Server : </b>Apache Tomcat 10.1</li>
  <li><b>IDE : </b>Eclipse</li>
</ul> <br>

<h3>Project Folders :</h3>
<li><b>src/main/java :-</b></li>
  <ul><li><b>com.fc.servlet : </b>Contains servlets for handling login and registration :- </li>
   <ul><li><b>LoginServlet.java : </b>Manages user authentication.</li>
    </ul>
    <ul><li><b>RegisterServlet.java : </b>Handles new user registration.</li>
    </ul>
 <br>
<li><b>com.fc.util : </b>Contains utility classes :- </li>
   <ul><li><b>JDBCUtils.java : </b>Manages database connections and operations.</li>
    </ul>
  </ul> 
  <li><b>src/main/webapp :-</b> Contains HTML and CSS files for the frontend interface.</li><br> <br> <br> <br>

  <h2>Features :</h2>
  <h3>1. Login Page (Home Page)</h3>
  <ul><li><b>Functionality :</b> The login page serves as the home page.</li>
  <li><b>Process :</b></li>
  <ul>
    <li>Users enter their <b>mobile number</b> (username) and <b>password.</b></li>
  </ul>
    <ul>
      <li>If credentials are correct, they are redirected to the Welcome page.</li>
    </ul>
    <ul>
      <li>If credentials are incorrect, they are directed to an error page with a message prompting for the correct username and password.</li>
    </ul>
    <ul>
      <li>On the error page, an "OK" button returns users to the login page.</li>
    </ul>
    <li><b>New User Registration :</b> A link at the bottom returns users to the login page.</li>
  </ul> <br> <br>

  <h3>2. Registration Page</h3>
  <ul><li><b>Functionality :</b> Allows new users to register with their details.</li>
  <li><b>Process :</b></li>
  <ul>
    <li>Users fill in the registration form and click the "Submit" button.</li>
  </ul>
    <ul>
      <li>Data entered is saved in the MySQL database.</li>
    </ul>
    <ul>
      <li>After successful registration, users are redirected to the login page to log in with their new credentials.</li>
    </ul>
  </ul> <br> <br>

  <h3>3. Welcome Page</h3>
  <ul><li><b>Content :</b></li>
  <ul>
    <li>Shows a brief description about the Little Angels Day Care for logged-in users.</li>
  </ul>
    <ul>
      <li>Provides two links at the bottom of the page :</li>
       <ol><li><b>Daily Activities : </b>Shows photos of activities conducted at the daycare.</li>
         <li><b>Events : </b>Displays photos of occassional events held at Little Angels.</li></ol>
    </ul>
    </ul> <br> <br> <br> <br>

   <h2>Database Structure :</h2>
   The application uses MySQL to store user information. Data from the registration form(including name, father's name, mother's name, dob, email,mobile number, password, address and other relevant fields) is saved in the database which is then accessed during login for authentication. During log in, they need username i.e mobile number and password.
   <br> <br> <br> <br>

   <h2>Usage Instructions :</h2>
   <ol><li><b>Register : </b>If you are a new user, click the "New User, Kindly Register Here..." link on the login page, fill out the registration form and submit it.</li>
   <li><b>Login :</b> Enter your registered mobile number and password on the login page.</li>
     <li><b>Navigation : </b>
     <ul>
       <li>After logging in, you'll be taken to the Welcome page.</li> </ul>
       <ul>
         <li>From the Welcome page, you can view photos of daily activities and events.</li></ul>
     </li>
   </ol>  
   <br> <br> <br> <br>

    

![Screenshot 2024-11-14 153318](https://github.com/user-attachments/assets/16397efb-64a7-4cae-94e5-617964dae4a2)
