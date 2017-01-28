# Insurance-Portal
This is a mini project that i did at HCL. This project includes updating user details to a database and fetching those details which are ready to edit in any page. The complete project is done using server-lets and JSP. Includes a notification panel which represents about to expire list. send documents as PDF using serverlets through mail.

-> Wrapped entire website in a secure shell in such a way that only logged users have access to the portal and the session will auto terminate after when the user is inactive for a while.
-> If the client try to access secure pages of admin it will drop the client in privilege issue page (for more security you can take a log of users who try to access the page they are not supposed to access)
-> For every error we have passed URL messages so the source can understand it and illustrate to the user what the error is for. In fact to give it a demo the URL in the top itself first goes inside the shell and as the use is not logged in the source throws the user to the login page with a URL message fail which the website understand and reply as please login first( above user input box).
-> We have looked over the database too in fact we are just using 3 tables for entire project and every table is used 100% without any data wastage in database.
-> For login we have used same database for both admin and client but the source we wrote differentiates who is client and who is admin and assigns roles.
-> And when creating a new user and the username is already exist it won’t search the entire database to check whether the username is present or not we created unique column and when the column name is  already exits the exception throwed is passed as error as username already exist.
-> By the above three  steps you can find the performance of the project and the flexibility to upgrade it in the future.
-> And in the new policy creation we illustrated how we managed to fetch the user details which are already existing in database and ready to edit by the admin which automates work.
-> Entire Website is 100% responsive and you can even check the mobile view to responsiveness.

Things we are trying to implement in future.

-> Notifications in menu which shows the count of policies which are about to expire and when clicked it only shows about to expire policies and easy renewal of policies from there.
-> Automatic mail to client when the user registration is successful (As the VM Lab is not connected to internet we can’t do it).
-> PDF / Document creation of invoice and policy forms and sending it as mail to client(We are working with a third party API called itext API to figure this out but the VM we are working are not supporting it as we have to increase the server timeout to resolve this). 

