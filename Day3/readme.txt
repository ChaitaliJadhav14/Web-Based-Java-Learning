STEPS TO CREATE A WEB-BASED PROJECT USING JAVA EE
• Java JDK (8 or above)
• Apache Tomcat (9/10)
• IDE (Eclipse / IntelliJ / NetBeans)

Set:
  Project Name
  Target Runtime: Apache Tomcat
  Dynamic Web Module Version: 3.1 or 4.0
Finish

Project/
 ├─ src/main/java/        (Java files: Servlets)
 ├─ WebContent/ or webapp/ (HTML, JSP, CSS, JS)
 └─ WEB-INF/
      └─ web.xml          (Deployment descriptor)
Install JDK → Install Tomcat → Create Project → Add HTML/JSP →
Create Servlet → Configure web.xml → Add Logic → Deploy → Test

2. Create a New Dynamic Web Project (Eclipse/IDE)
File → New → Dynamic Web Project
New → Servlet
  |----Enter Servlet Details ->Java Package:com.example (or any package name)
                             |->Class Name:GreetingServlet
http://localhost:8080/YourAppName/doGreet

Change URL Pattern
In the servlet wizard screen, find:
URL Mapping:
Delete default value (like /GreetingServlet) and type:
/doGreet
Then click Finish.

Servlet: a server is web component that used to extend the functionality of Web Server.
 it is a component that run on server side and therfore it can be used to handle server side processing.
 it can be used to generate dymaic web contents.
                                                     HTTP REQUEST                   
                       mail.google.com ->---->------->-------->------>-----|     google's mailSever
                   web Browser                                           web server 
                   google chrome            HTTP Response                  tomcate
                        lOGIN PAGE<---------<------<-----------<---------<---||
                          (static page)(html)      HTTP Response             || 
                              |---->------------------->------------>---->---||
                                                                              |
                               inboxpage<---<-------------<-------------------|
                                dynamicpage              HTTP Response
                                   (servlet) 


 ┌───────────────────────┐          ┌────────────────────────────────────┐             ┌──────────────────────────┐
 │   WEB BROWSER         │          │  WEB SERVER (TOMCAT)               │             │   SERVLET / JSP          │
 │  (Google Chrome)      │          │  Static + Dynamic Resources        │             │  Dynamic Processing      │
 └──────────┬────────────┘          └───────────────┬────────────────────┘             └──────────┬──────────────┘
            │                                        │                                            │
            │ 1) HTTP REQUEST: mail.google.com       │                                            │
            ├───────────────────────────────────────►│                                            │
            │                                        │                                            │
            │◄───────────────────────────────────────┤                                            │
            │ 2) HTTP RESPONSE: LOGIN PAGE (HTML)    │                                            │
            │                                        │                                            │
            └─> Browser renders Login Page           │                                            │

      User enters username/password and submits form

            │                                        │                                            │
            │ 3) HTTP REQUEST: /login                │                                            │
            ├───────────────────────────────────────►│───► Calls Servlet / Business Logic         │
            │                                        │                                            │
            │                                        │ 4) Generate Dynamic Inbox Page             │
            │                                        ├────────────────────────────────────────────►│
            │                                        │                                            │
            │◄────────────────────────────────────────┤                                            │
            │ 5) HTTP RESPONSE: INBOX PAGE (Dynamic) │                                            │
            │                                        │                                            │
 ┌──────────v────────────┐                          │                                            │
 │ Browser shows Inbox    │                          │                                            │
 └────────────────────────┘                          └────────────────────────────────────────────┘


notes: Serclets become popular because they are wrriten using java class and therefore, they can avail all the features  of java language eg. Platform independent, multithread,secured , Robust, protable and so on.


Implementing Servlet:

in order to to implement servlet, it is necessary to provide a java class which is referred as Servlet implementation Class.
this  class must make use of someAPI known as ServletAPI.

ServletAPI:
2 packages provide by:
1.jakarta.servlet
2.jakarta.servlet.http 
 these packages mainly provide folllowing
 1. Servlet  (I> 1 package)
 2. GenricServlet(C- 1 package)
 3. HttpServlet(C- 2 package)
 4. HttpServletRequest(I - 2 package)
 5. HttpServletResponse(I - 2 package)

 the Servlet implementation class can be defined using 3 options:
 1. Implementing Servlet interface 
 2. Extending GenricServlet class
 2. Extending HttpServlet class

in case of 1st option class must implement all the methods from the interface  irrepective
of whether they are in use or not .
therefore this option not recommented.

the 2nd option used when a servlet is meant for accepting any type  of REQUEST.

the 3rd option used when a servlet is meant for accepting any http request.

jakarta EE as a Specification(means set of rules):
 it is Specification not an implementation.
 the implementation is provide by 3rd party software known as either a web Server
 (servlet ,jsp ) or Application server(servlet,jsp , EJB)


Deploying a web Application:
    once a web Application specific component is developed , in order to excute that , 
    it is necessary to host the Application on a web server.
    this phase is known as deployment.


Life Cycle of Servlets:
3 stages:
1. Instatiation and Intalization
2. Service
3. Destroy

The Servlet interface provides relevant methods which are called a life Cycle method
1. init()
2. Service()
3. Destroy()
1.when the servlet is requested for the vary 1st  time, it is loaded by web component
and then container instantiates the servlet.
2. once the instantiation is done, container invokes init() method.
3. this method can be used to handle initalization if any.
4. once Intalization is done, container invoke service() method and it is used for
serving the client.
5.when the servlet is requested sub-sequent times, container invokes service() method.
therefore, service() method is called every time when the Servlets is requested.

6. when the web server is stopped ot the application is undeployed, cantainer invoke
 Destroy() method.
                       +-----------------------------+
                       |     Client Request (1st)    |
                       +-------------+---------------+
                                     |
                                     v
                      +-----------------------------------+
                      |  Servlet Loading by Container     |
                      +----------------+------------------+
                                       |
                                       v
                           (1) Instantiation
                                       |
                                       v
                     +------------------------------------+
                     |  init()  → Initialization Stage     |
                     |  Called ONLY ONCE                   |
                     +----------------+---------------------+
                                       |
                                       v
                           (2) Service Stage
                                       |
                                       v
                +------------------------------------------------+
                |  service()  → Handles Every Client Request     |
                |  Called for 1st & All Subsequent Requests      |
                +----------------+-------------------------------+
                                       |
                                       v
                    (Server stops or App Undeployed)
                                       |
                                       v
                          (3) Destroy Stage
                                       |
                                       v
                       +-------------------------------+
                       |  destroy()  → Cleanup Stage   |
                       |  Called ONLY ONCE             |
                       +-------------------------------+

 service() and doGet():
 when a servlet is requestes every time, service() method is invoked.
 the super class HttpServlet already define service() methed that checked  the type 
  of incoming HTTP request.

  HTTP request can be several type:
  1. GET 
  2. POST 
  3. PUT
  4. DELETE 
  5. PATCH 
  6. TRACE
  7. OPTIONS 
  8. HEAD 
  Depnding upon the tye of incoming http request , the service() method invoke
  the appropriate doXXXX() method.
  eg in case GET-->   doGet() invoke
          if POST -->doPost()
  in order to customize the implementation, these methed need to be overridden
  in subclass.        

        http://localhost:9000/web-project/doGreet
        |         |        |        |           |
    protocal  ip address portno  context-root  resources URL

 REQUESTING a servlet:
 there are server options by which a servlet can be requested.
 1.using browser's address bar.
 2.using html Anchor Tag(<a href = "url">)  
 3.using html form
 4.using servlet
 5.using jsp 

1.using browser's address bar.
+------------------------------------------------------+
|            Browser's Address Bar                     |
|   (User types URL → Servlet is requested)            |
+-----------------------------+------------------------+
                              |
                              |  HTTP Request
                              v
                 +-------------------------------+
                 |   Web Server / Container      |
                 |     (Tomcat)                  |
                 +---------------+---------------+
                                 |
                                 |  Maps URL to Servlet
                                 v
                     +-------------------------+
                     |      Servlet            |
                     |  (service/doGet/doPost) |
                     +------------+------------+
                                  |
                                  | HTTP Response
                                  v
                    +-------------------------------+
                    |      Browser displays page     |
                    +--------------------------------+


2.using html Anchor Tag(<a href = "url">) 

+-----------------------------------------------------------+
|                HTML Anchor Tag (Hyperlink)                |
|          <a href="ServletURL"> Click Here </a>            |
+-------------------------------+---------------------------+
                                |
                                | User clicks the link
                                | Browser sends HTTP Request
                                v
                   +----------------------------------+
                   |     Web Server / Container       |
                   |          (Tomcat)                |
                   +---------------+------------------+
                                   |
                                   |  Maps URL to Servlet
                                   v
                        +---------------------------+
                        |          Servlet          |
                        |  (service/doGet/doPost)   |
                        +-------------+-------------+
                                      |
                                      |  HTTP Response
                                      v
                        +-------------------------------+
                        |   Browser displays response   |
                        +-------------------------------+


 3.HTML from processing: in web application, clinet may want to send some information
   to words server along with the request for futher processing.
   this is typically done using a html form. 
    when submit button  is clicked, data entered by end user is send along with 
    the request toword server.
    that data is called as request parameter and it is in the form of name- value paris.

    in order to retrieve request parameter on server side, HttpServletRequest
    interface provied getParameter()
┌───────────────────────────────────────────────┐
│ 1) User types data into form fields & clicks  │
│    "Submit"                                   │
└───────────────────────────────────────────────┘
                      │
                      │ (HTTP GET or POST)
                      ▼
HTTP Request → Web Server (Tomcat / Apache / Nginx + app server)
┌────────────────────────────────────────────────────────────────┐
│ 2) Server receives request at URL mapped to a servlet/JSP      │
│                                                                │
│ 3) Container routes request to Servlet                         │
│    - If JSP, JSP can forward/include or act as endpoint        │
└────────────────────────────────────────────────────────────────┘
                      │
                      ▼
Servlet (doGet/doPost / service)
┌────────────────────────────────────────────────────────────────┐
│ 4) Servlet reads form data:                                     │
│    - request.getParameter("name")                               │
│    - request.getParameterValues("checkboxName")                 │
│    - For files: use multipart parser (Servlet 3.0 API / Apache) │
│ 5) Server-side validation & business logic                      │
│ 6) Possibly store/update DB / session / call services           │
│ 7) Prepare response (HTML/JSP/redirect/JSON)                    │
└────────────────────────────────────────────────────────────────┘
                      │
                      ▼
HTTP Response → Browser (shows result page / redirect / error)
