Pharmease
Pharmease is a web application designed to help users find the nearest pharmacies that have the medications they need. It also provides the total time and distance between the user and the selected pharmacy using the Java Map API by Mapple. The application includes robust user and admin authentication via OTP sent to Gmail and ensures that all user details are validated properly.

Features
Find Nearest Pharmacies

Locate nearby pharmacies based on the user's current location.
Search for pharmacies that stock specific medications.
Distance and Time Calculation

Calculate the total time and distance between the user and the selected pharmacy using Mapple's Java Map API.
Pharmacy Information

Provide detailed information about each pharmacy, including address, contact details, and available medications.
User and Admin Authentication

Secure login and registration process with OTP verification sent to the user's Gmail.
Admin panel for managing pharmacy data and user details.
Technologies Used
Frontend: HTML, CSS, JavaScript
Backend: Java, Spring Boot
Database: MySQL
Map API: Mapple Java Map API
Email Service: JavaMail API for sending OTP
Installation
Clone the repository: Obtain the project files from the repository.
Navigate to the project directory: Move to the directory where the project files are located.
Set up the database:
Create a MySQL database named pharmease.
Import the provided SQL script to set up the necessary tables.
Configure the application:
Update the application.properties file with your database credentials and email service details.
Ensure the configurations for database connection and email service are correct.
Build and run the application: Use Maven to build and start the Spring Boot application.
Access the application: Open your browser and navigate to the specified localhost URL to start using the application.
Usage
User Registration and Login:

Register as a new user by providing your email and other required details.
Verify your account by entering the OTP sent to your Gmail.
Login using your verified credentials.
Search for Pharmacies:

Enter the medication you need.
The application will list the nearest pharmacies that have the medication in stock.
View Pharmacy Details:

Click on a pharmacy to view detailed information including address, contact details, and available medications.
The total time and distance to the pharmacy will also be displayed.
Admin Panel:

Admins can log in to manage pharmacy data and user details.
Admin functionalities include adding new pharmacies, updating existing ones, and managing user accounts.
Contributing
Fork the repository.
Create a new branch: Make your changes in a new branch.
Make your changes and commit them: Ensure your changes are committed with a descriptive message.
Push to the branch: Upload your changes to your repository.
Create a pull request: Submit your changes for review.

Thank you for using Pharmease! We hope it helps you find the medications you need quickly and easily.
