COMMON SENSE TEST CASES


Test Case 1: First Name Field is a Text Field
Description: Verify that the first name field is a text field, can be selected for input, and displays the inputted text.
Steps:

Navigate to the registration page.
Select the first name field.
Enter text into the first name field (e.g., "John").
Assertions:
Verify that the first name field is a text field.
Verify that the first name field can be selected.
Verify that the inputted text is displayed correctly in the first name field.


Test Case 2: Last Name Field is a Text Field
Description: Verify that the last name field is a text field, can be selected for input, and displays the inputted text.
Steps:

Navigate to the registration page.
Select the last name field.
Enter text into the last name field (e.g., "Doe").
Assertions:
Verify that the last name field is a text field.
Verify that the last name field can be selected.
Verify that the inputted text is displayed correctly in the last name field.


Test Case 3: Date of Birth Field is a Drop-Down
Description: Verify that the date of birth field consists of drop-down menus for day, month, and year, and that they have the expected options.
Steps:

Navigate to the registration page.
Select the day drop-down menu.
Select the month drop-down menu.
Select the year drop-down menu.
Assertions:
Verify that the day drop-down menu contains options from 1 to 31.
Verify that the month drop-down menu contains options from January to December.
Verify that the year drop-down menu contains a range of years (e.g., 1900 to the current year).


Test Case 4: Email Field is a Text Field
Description: Verify that the email field is a text field, can be selected for input, and displays the inputted text.
Steps:

Navigate to the registration page.
Select the email field.
Enter text into the email field (e.g., "john.doe@example.com").
Assertions:
Verify that the email field is a text field.
Verify that the email field can be selected.
Verify that the inputted text is displayed correctly in the email field.


Test Case 5: Repeat Email Field is a Text Field
Description: Verify that the repeat email field is a text field, can be selected for input, and displays the inputted text.
Steps:

Navigate to the registration page.
Select the repeat email field.
Enter text into the repeat email field (e.g., "john.doe@example.com").
Assertions:
Verify that the repeat email field is a text field.
Verify that the repeat email field can be selected.
Verify that the inputted text is displayed correctly in the repeat email field.


Test Case 6: Password Field is a Password Text Field
Description: Verify that the password field is a password text field, can be selected for input, and hides the inputted text.
Steps:

Navigate to the registration page.
Select the password field.
Enter text into the password field (e.g., "password123").
Assertions:
Verify that the password field is a password text field.
Verify that the password field can be selected.
Verify that the inputted text is hidden (e.g., displayed as dots or asterisks).


Test Case 7: Terms and Conditions Checkbox is Selectable
Description: Verify that the terms and conditions checkbox can be selected and deselected.
Steps:

Navigate to the registration page.
Select the terms and conditions checkbox.
Deselect the terms and conditions checkbox.
Assertions:
Verify that the checkbox can be selected.
Verify that the checkbox can be deselected.

Test Case 8: Terms and Conditions Link Opens Correctly
Description: Verify that clicking the highlighted "Terms and Conditions" text opens the terms and conditions in a new tab or as a pop-up window.
Steps:

Navigate to the registration page.
Locate the highlighted "Terms and Conditions" text near the checkbox.
Click on the highlighted "Terms and Conditions" text.
Assertions:
Verify that the terms and conditions open in a new browser tab or as a pop-up window.
Verify that the new tab or pop-up window displays the correct terms and conditions content.
Verify that the original registration page remains intact and accessible.

Test Case 9: Selecting the Terms and Conditions Radio Button
Description: Verify that selecting the terms and conditions radio button updates the display to indicate that the terms and conditions have been accepted.
Steps:

Navigate to the registration page.
Locate the terms and conditions radio button and the highlighted "Terms and Conditions" text.
Click on the terms and conditions radio button to select it.
Observe the radio button and any related display or message.
Assertions:
Verify that the radio button changes state to indicate it is selected (e.g., a filled circle appears).
Verify that any message or indicator related to the acceptance of the terms and conditions is displayed, confirming the user's selection.
Ensure that the registration page does not produce any errors and remains functional for further input.


Specific Drop-Down Menu Tests for Date of Birth


Test Case 1: Day Drop-Down Menu Has Correct Number of Days
Description: Verify that the day drop-down menu has the correct number of days for each month.
Steps:

Navigate to the registration page.
Select January in the month drop-down menu.
Verify the number of days in the day drop-down menu.
Repeat for other months (e.g., February, April, June).
Assertions:
Verify that January has 31 days.
Verify that February has 28 or 29 days (depending on the leap year).
Verify that April has 30 days.


Test Case 2: Month Drop-Down Menu Has 12 Months
Description: Verify that the month drop-down menu contains all 12 months.
Steps:

Navigate to the registration page.
Select the month drop-down menu.
Assertions:
Verify that the month drop-down menu contains January to December.


Test Case 3: Year Drop-Down Menu Has a Range of Years
Description: Verify that the year drop-down menu contains a reasonable range of years.
Steps:

Navigate to the registration page.
Select the year drop-down menu.
Assertions:
Verify that the year drop-down menu contains years from 1900 to the current year.


FUNCTIONAL TESTS


Test Case 1: Successful Registration with Valid Data
Description: Verify that the user can successfully register with all valid inputs.
Steps:

Navigate to the registration page.
Enter a valid first name (e.g., "John").
Enter a valid last name (e.g., "Doey").
Enter a valid date of birth (e.g., "01/01/2000").
Enter a valid email address (e.g., "john.doey@example.com").
Enter the same valid email address in the repeat email field.
Enter a valid password (e.g., "password123").
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that the user is redirected to a page with a message indicating that they need to activate their account.
Verify that the user receives an activation email.


Test Case 2: Email Already Registered
Description: Verify that if the user enters an email address already registered in the system, they are redirected to the login page with the appropriate message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an already registered email address.
Enter the same email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that the user is redirected to the login page.
Verify that a message is displayed: "There is an existing account associated with <<EMAIL_ADDRESS>>".


Test Case 3: Missing First Name
Description: Verify that leaving the first name field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Leave the first name field empty.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "Please fill in this First Name."


Test Case 4: Missing Last Name
Description: Verify that leaving the last name field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Leave the last name field empty.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Please fill in this Last Name."


Test Case 5: Missing Date of Birth
Description: Verify that leaving the date of birth field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Leave the date of birth field empty.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the date of birth field: "Please fill in this Date of Birth."


Test Case 6: Missing Email
Description: Verify that leaving the email field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Leave the email field empty.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Please fill in this Email."


Test Case 7: Missing Repeat Email
Description: Verify that leaving the repeat email field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Leave the repeat email field empty.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the repeat email field: "Please fill in this Repeat Email."


Test Case 8: Missing Password
Description: Verify that leaving the password field empty results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Leave the password field empty.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the password field: "Please fill in this Password."


Test Case 9: Missing Terms and Conditions
Description: Verify that not checking the terms and conditions checkbox results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Do not check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed: "Please accept the terms and conditions."


Test Case 10: First Name with Fewer than 4 Characters
Description: Verify that entering a first name with fewer than 4 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a first name with fewer than 4 characters (e.g., "Jon").
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "First Name must be between 4 and 150 characters."


Test Case 11: First Name with More than 150 Characters
Description: Verify that entering a first name with more than 150 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a first name with more than 150 characters.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "First Name must be between 4 and 150 characters."


Test Case 12: Last Name with Fewer than 4 Characters
Description: Verify that entering a last name with fewer than 4 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a last name with fewer than 4 characters (e.g., "Li").
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Last Name must be between 4 and 150 characters."


Test Case 13: Last Name with More than 150 Characters
Description: Verify that entering a last name with more than 150 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a last name with more than 150 characters.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Last Name must be between 4 and 150 characters."


Test Case 14: Email with More than 150 Characters
Description: Verify that entering an email address with more than 150 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an email address with more than 150 characters.
Enter the same email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Email must be no longer than 150 characters."


Test Case 15: Email with Invalid Format
Description: Verify that entering an email address with an invalid format results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an invalid email address (e.g., "john.doe@com").
Enter the same invalid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Invalid email."


Test Case 16: Repeat Email Mismatch
Description: Verify that entering a repeat email address that does not match the original email address results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address (e.g., "john.doe@example.com").
Enter a different email address in the repeat email field (e.g., "jane.doe@example.com").
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the repeat email field: "Email addresses do not match."


Test Case 17: Password with Fewer than 6 Characters
Description: Verify that entering a password with fewer than 6 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a password with fewer than 6 characters (e.g., "12345").
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the password field: "Password must be between 6 and 20 characters."


Test Case 18: Password with More than 20 Characters
Description: Verify that entering a password with more than 20 characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a password with more than 20 characters.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the password field: "Password must be between 6 and 20 characters."


Test Case 19: Email with Invalid Characters
Description: Verify that entering an email address with invalid characters results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an email address with invalid characters (e.g., "john+doe@exmple.com").
Enter the same email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Invalid email."


Test Case 20: Date of Birth Exceeds Current Date
Description: Verify that selecting a date of birth that exceeds the current date results in an error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a date of birth that exceeds the current date (e.g., "01/01/2025").
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed: "Selected date exceeds the current date."


Test Case 21: Activation Email Link in Same Browser
Description: Verify that clicking the activation link in the same browser automatically logs the user in.
Steps:

Complete the registration with valid details.
Open the activation email received.
Click on the activation link in the same browser.
Assertions:
Verify that the user is automatically logged into the system.


Test Case 22: Activation Email Link in Different Browser
Description: Verify that clicking the activation link in a different browser redirects the user to the login page with a welcome message and pre-populated email address.
Steps:

Complete the registration with valid details.
Open the activation email received.
Click on the activation link in a different browser.
Assertions:
Verify that the user is redirected to the login page.
Verify that a welcome message is displayed.
Verify that the email address field is pre-populated with the user's email address.


NEGATIVE TEST CASES


Test Case 1: First Name with Numbers
Description: Verify that entering numbers in the first name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter numbers in the first name field (e.g., "John123").
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "First Name must contain only letters."


Test Case 2: Last Name with Numbers
Description: Verify that entering numbers in the last name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter numbers in the last name field (e.g., "Doey456").
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Last Name must contain only letters."


Test Case 3: First Name with Special Characters
Description: Verify that entering special characters in the first name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter special characters in the first name field (e.g., "John@!").
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "First Name must contain only letters."


Test Case 4: Last Name with Special Characters
Description: Verify that entering special characters in the last name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter special characters in the last name field (e.g., "Doey@!").
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Last Name must contain only letters."


Test Case 5: First Name with Spaces
Description: Verify that entering spaces in the first name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter spaces in the first name field (e.g., " ").
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the first name field: "First Name must not be empty."


Test Case 6: Last Name with Spaces
Description: Verify that entering spaces in the last name field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter spaces in the last name field (e.g., " ").
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the last name field: "Last Name must not be empty."


Test Case 7: Email with Spaces
Description: Verify that entering spaces in the email field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter spaces in the email field (e.g., " ").
Enter the same spaces in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Invalid email."


Test Case 8: Email with Missing Domain
Description: Verify that entering an email address without a domain results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an email address without a domain (e.g., "john.doe@").
Enter the same invalid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Invalid email."


Test Case 9: Password with Spaces Only
Description: Verify that entering spaces only in the password field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter a valid email address.
Enter the same valid email address in the repeat email field.
Enter spaces only in the password field (e.g., " ").
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the password field: "Password must not be empty."


Test Case 10: Email with Invalid TLD
Description: Verify that entering an email address with an invalid top-level domain (TLD) results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter a valid first name.
Enter a valid last name.
Enter a valid date of birth.
Enter an email address with an invalid TLD (e.g., "john.doe@example.invalid").
Enter the same invalid email address in the repeat email field.
Enter a valid password.
Check the terms and conditions checkbox.
Click on the "Register" button.
Assertions:
Verify that an error message is displayed below the email field: "Invalid email."


SECURITY AND EDGE CASE TEST CASES

Note: These test cases assume the use of a tool like Burp Suite to capture and modify HTTP requests. The specifics of the request format (e.g., JSON, form data) will determine the exact implementation. Always sanitize inputs on both the client and server sides to prevent security vulnerabilities.

Test Case 24: SQL Injection in First Name
Description: Verify that SQL injection attempts in the first name field are not successful.
Steps:

Navigate to the registration page.
Enter an SQL injection string in the first name field (e.g., "' OR '1'='1").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the SQL injection string in the first name field.
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed, and the account is not created.
Verify that the database is not compromised.


Test Case 25: SQL Injection in Email
Description: Verify that SQL injection attempts in the email field are not successful.
Steps:

Navigate to the registration page.
Enter an SQL injection string in the email field (e.g., "john@example.com' OR '1'='1").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the SQL injection string in the email field.
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed, and the account is not created.
Verify that the database is not compromised.


Test Case 26: Cross-Site Scripting (XSS) in First Name
Description: Verify that XSS attempts in the first name field are not successful.
Steps:

Navigate to the registration page.
Enter an XSS script in the first name field (e.g., "<script>alert('XSS')</script>").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the XSS script in the first name field.
Forward the modified request to the server.
Assertions:
Verify that the script is not executed, and an error message is displayed.
Verify that the account is not created.


Test Case 27: Letters in Date of Birth
Description: Verify that entering letters in the date of birth field results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include letters in the date of birth field (e.g., "01/Jan/2000").
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed: "Date of Birth must be in the format dd/mm/yyyy."
Verify that the account is not created.


Test Case 28: HTML Injection in Last Name
Description: Verify that HTML injection attempts in the last name field are not successful.
Steps:

Navigate to the registration page.
Enter an HTML injection string in the last name field (e.g., "<b>Doe</b>").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the HTML injection string in the last name field.
Forward the modified request to the server.
Assertions:
Verify that the HTML is not rendered, and an error message is displayed.
Verify that the account is not created.


Test Case 29: Long Input in First Name
Description: Verify that very long input in the first name field is handled correctly.
Steps:

Navigate to the registration page.
Enter a very long string (e.g., 1000 characters) in the first name field.
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the long string in the first name field.
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed: "First Name must be between 4 and 150 characters."
Verify that the account is not created.


Test Case 30: Special Characters in Password
Description: Verify that special characters in the password field are handled correctly.
Steps:

Navigate to the registration page.
Enter a password with special characters (e.g., "p@$$w0rd!").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include the special characters in the password field.
Forward the modified request to the server.
Assertions:
Verify that the password is accepted if special characters are allowed.
Verify that the account is created if all other data is valid.


Test Case 31: Spaces in Password
Description: Verify that entering spaces in the password field results in an appropriate error message if spaces are not allowed.
Steps:

Navigate to the registration page.
Enter a password with spaces (e.g., "pass word").
Enter valid data in the other fields.
Capture the HTTP request using Burp Suite.
Modify the request to include spaces in the password field.
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed: "Password cannot contain spaces."
Verify that the account is not created.


Test Case 32: Malformed JSON Request
Description: Verify that a malformed JSON request results in an appropriate error message and does not create an account.
Steps:

Navigate to the registration page.
Enter valid data in all fields.
Capture the HTTP request using Burp Suite.
Modify the request to make the JSON malformed (e.g., remove a closing brace).
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed indicating a malformed request.
Verify that the account is not created.


Test Case 33: Missing Fields in JSON Request
Description: Verify that missing fields in the JSON request result in appropriate error messages.
Steps:

Navigate to the registration page.
Enter valid data in all fields.
Capture the HTTP request using Burp Suite.
Modify the request to remove one or more fields (e.g., remove the "email" field).
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed indicating the missing fields.
Verify that the account is not created.


Test Case 34: Incorrect Content-Type Header
Description: Verify that sending the request with an incorrect Content-Type header results in an appropriate error message.
Steps:

Navigate to the registration page.
Enter valid data in all fields.
Capture the HTTP request using Burp Suite.
Modify the request to set an incorrect Content-Type header (e.g., "text/plain" instead of "application/json").
Forward the modified request to the server.
Assertions:
Verify that an error message is displayed indicating an incorrect content type.
Verify that the account is not created.

Test Case 35: Changing the Accept Terms and Conditions in a Captured Request from True to False
Description: Verify that modifying the terms and conditions acceptance value in a captured request from true to false results in the appropriate error message or prevents registration.
Steps:

Navigate to the registration page.
Enter valid data in all fields.
Select the terms and conditions radio button to accept the terms.
Capture the HTTP request using a tool like Burp Suite.
In Burp Suite, modify the captured request by changing the terms and conditions acceptance value from true to false.
Forward the modified request to the server.
Assertions:
Verify that the server responds with an error message indicating that the terms and conditions must be accepted.
Verify that the account is not created.
Confirm that the error message is displayed on the registration page, stating that the user must accept the terms and conditions.

Test Case 36: Rate Limiting for Registration to Prevent DDoS
Description: Verify that the registration system enforces rate limiting to prevent DDoS attacks.
Steps:

Attempt to register a new user account with valid data.
Repeat the registration request rapidly in quick succession (e.g., 100 requests per minute) using an automated script or tool.
Monitor the responses from the server.
Assertions:
Verify that after a certain threshold (e.g., 10 requests per minute), the server responds with a rate limiting error message (e.g., HTTP status code 429 "Too Many Requests").
Verify that the error message indicates the rate limit has been exceeded and advises on retrying after a specific period.
Confirm that the server does not process further registration requests from the same IP address within the limited period.
Ensure that legitimate users can still register successfully once the rate limiting period has elapsed.
Note:
Tool and Environment: This test requires the use of an automated tool or script to simulate multiple registration attempts in a short period. Tools like Apache JMeter, Postman, or custom scripts can be used.
Server Configuration: The exact behavior and thresholds for rate limiting will depend on the server configuration and policies in place. Adjust the test parameters accordingly.

Test Case 37: Checking the TTL (Time-To-Live) of the Registration Link from Email
Description: Verify that the registration link sent via email expires after the specified TTL period.
Steps:

Register a new user account with valid data.
Wait for the registration email to arrive in the provided email inbox.
Note the current time and the TTL specified for the registration link (e.g., 24 hours).
Click on the registration link within the TTL period.
Assertions for Step 4:
Verify that the registration link successfully activates the user account and logs the user in or redirects to the appropriate activation page.
Wait until the TTL period has expired (e.g., after 24 hours from the noted time).
Click on the registration link after the TTL period has expired.
Assertions for Step 6:
Verify that the registration link does not activate the account.
Verify that the user is redirected to a page with an appropriate error message indicating that the link has expired (e.g., "This registration link has expired. Please register again.").
Confirm that the expired link cannot be used to activate an account and prompts the user to initiate a new registration process if needed.
Note:
Email Monitoring: Ensure access to the email account used for registration to receive and click the registration link.
Time Management: Accurate tracking of the TTL period is essential for this test case. Use time monitoring tools if needed to ensure precision.

Test Case 38: Prevent Profile Change by Modifying Cookies
Description: Verify that a user cannot change the logged-in profile by modifying cookies.
Steps:

Log in to the application with User A's credentials.
Navigate to the profile page and note the profile details of User A.
Capture the current session cookies using the browser's developer tools or an interception tool like Burp Suite.
Log out of User A's account.
Log in to the application with User B's credentials.
Navigate to the profile page and note the profile details of User B.
Capture the current session cookies for User B.
Using the browser's developer tools or Burp Suite, replace User B's session cookies with User A's session cookies.
Refresh the profile page or navigate to another page that requires authentication.
Assertions:
Verify that the profile details displayed are still those of User B and not User A.
Verify that the server either rejects the modified cookies or logs out the user due to session mismatch.
Confirm that an error message is displayed if there is a session conflict or invalid session.
Note:
Session Implementation: The exact behavior and test implementation will depend on how the sessions are managed on the server side (e.g., JWT tokens, session IDs stored in cookies).
Security Best Practices: Ensure that the application uses secure, HttpOnly, and SameSite attributes for cookies to prevent client-side manipulation and cross-site request forgery (CSRF).


Warnings
Request Format Sensitivity: The exact implementation of these test cases will depend on how the request is sent (e.g., JSON, form data). Ensure you understand the format and structure of the requests before executing these tests.
Data Sanitization: Always sanitize inputs on both the client and server sides to prevent security vulnerabilities such as SQL injection and XSS.
Impact on Database: These tests should be performed in a controlled environment to avoid any potential impact on production databases or services.
