Queries in JDBC

In JDBC ar mainlly two type:

1.simple Queries: when a query doesnot have parameter then it called simple query.
     eg: SELECT * FROM EMP;
         DELETE FROM EMP;
2. parameter Queries: When query accepts some parameter then it called parameterized 
    query.
    eg: SELECT * from emp where sal betwen <min> and <max>
       DELETE FROM EMP where EMP IN(NO1,NO2,NO3)

 Generallly, when the query is simple query, Statement is used whereas in case of 
 parameterized query , PreparedStatement is used.      
-  it is also possible to excute parameterized query using Statement but in this 
  case as soon as the parameter value is change, a new query is formed and it gets
  compiled.
   this lead to performance implications.
-  in case of PreparedStatement the query is formed and compiled just once,
   because  it gts cached and therefore it suitable for parameterized Queries.



 int studetId =nextInt();// Accepting ID from user
       

 SELECT * FROM STUDENT WHERE STUDENT_ID ="studetId;

 performing DML Operation:
 -IN CASE of SELECT query , the returned data is stored in form of ResultSet and 
 the object of type ResultSet is obtained using a method : executeQuery().

 -In case of DML operations like INSERT DELETE, UPDATE , ResultSet is not required. Therefore to make
 call towords DB,excuteUpdate methed is used.

 -the methed return int that indicates the number of records affected due to that query.


performing DML update:
-in order to perform DML update , first it necessary to load the data on which 
  update is required
- this is typically done by Id.
- Once the data is loaded in the form of object , it can be modified using
 setter method.
- this changes the state of the data on java side but not on DB side .
- In order to complete the update operation , it necessary to reflect this modified
  state back to DB side.


Statement in JDBC
- to make a call towords DB , some type of Statement is required.
in JDBC , there are 3 type of Statement:
1. Statement
2. PreparedStatemet
3. CallableStatement
 
 1. Statement: it is used to excute simple queries.
 eg: stmt.executeQuery(Select * from EMP);
     stmt.excuteUpdate("DELETE from emp");

 2. PreparedStatement: it used to execute parameterized queries.

 3. CallableStatement: it used to invoke stored procedure present on DB side.

 Making a JDBC call: in order to make a jdbc call, Statement Interface provides 
    several mathods.
    1.executeQuery(): it is used  especially in case of Select query.
                      it return set that hold data retrieved from DB
    2.excuteUpdate(): it is used  especially in case of DML query.
                      it return int which indicates the number of records affected.

    3.excute(): it can be to accomplish several requiements.
            eg: 
          -  Executing dynamic Queries(Query string is decided at runtime)
          -  Executing DDL queries.
          -  it return  boolean value, that indicates whether the outcome of the 
            query is an object of type ResultSet or not.


Transaction Management : 
 A Transaction is set of operation b to be performed in single unit. 
 Managing the Transaction is key activiy in business application.
 if not handled properly, it lead to the problem of data  inconsistency.

 in order to manage Transactions , it is necessary  to ensures that the Transactios 
  atomic (excute all or none).
  2 update 2 INSERT required between A to b Transaction

 -  in case of JDBC, by default all DML operation are auto-committed.
 - this may cause data inconsistency
 -  therefore to ensure the atomicity of the Transaction , first it is necessary 
    to disable Auto-Commit.
 -  This is done using relevent metheds of Connection Interface:
 1. setAutoCommit(boolean)[Use false to disable it]
 2. commit()=> used to commit the Transaction
 3. rollback()=> used to rollback the Transaction.

 
Java SE (core Java)
  1. Desktop application: run on single machine only
  2. Simple N/W based application: client - server application with limited feature
Java EE(Adv Java) 
    1. Web based applications  

 Jakarta EE (Java EE (J2EE)):
    Jakarta EE stands for Jakarta Enterprise Edition
    it is platform meant for developing Web based as well as Enterprise applications.

    any application that is accessed using web browser is referred as web application.

    2type:
    1.Internet - available for all userd
    2.Inteanet - available for specific user

Enterprise applications:
        when a web applicable requires some Enterprise services to be incoporated 
        then that application is referred as Enterprise applicable.

Enterprise services are higher and services.
eg: 
  1. Scalability: Availability to handle muiltiple users
  2. Availability: available feature foe all
  3. Transaction Management: Acid Property
  4. Persistency: 
  5. Concurrency
  6. Secuity
  7. Asynchronous Messaging
1. Scalability
Ability of an application to handle increasing number of users, data, or workload 
by adding more resources.
2. Availability
Ensures the application is available to users at all times, often achieved 
through clustering, load balancing, and failover mechanisms.

3. Transaction Management

Supports the ACID properties:
Atomicity
Consistency
Isolation
Durability
Ensures data correctness during complex operations.

4. Persistency (Persistence)
Ability to store and retrieve data permanently, usually via databases, ORMs
 or JPA/Hibernate.

5. Concurrency
Ability to handle multiple users or threads accessing the system at the same 
time without conflicts.

6. Security
Ensures authentication, authorization, encryption, and protection from threats.

7. Asynchronous Messaging

Supports communication between components without waiting for immediate
responses.

Examples: JMS, message queues, Kafka, RabbitMQ.
Jakarta EE Architecture:
  based on Conponent Drien Architecture.
  A Conponent is application level  reusable piece of code.
   2 type components
   1. Unmanaged
   2. managed
Unmanaged components:
  when a component is to instantiated explicitly using New keyword , then
  that component called as Unmanaged component.

  in general ,java SE (core java) consists of Unmanaged components.

 managed components:
  when a component is to instantiated iimplicitly without New keyword , then
  that component called as managed component.

in general , Jakarta EE (Java EE (J2EE)) consists of managed components.
managed components.
2 type
1. Web component:
2. Business  component :
1. Web component:
  A component that is responsible for accepting web request and generating web responses
   is called web component
   2 type of web components
   1. Servlet
   2. JSP

2. Business  component :
    A component that is responsible for handling business logic of the application
    called as Business component.
    it ia taken care by EJB ie. Enterprise Java Bean 

           Components
--------------------------------------------------------------------
                                                           Application Servers
                         Java SE                      Jakarta EE
                     (Unmanaged)                     (Managed)
                                                        Web Server
                                                     WEb Container
                                                -------------------------
                                                |     Web Components     |
                                                |   - Servlet            |
                                                |   - JSP                |
                                                -------------------------
                                                        
                                                      EJB Container
                                                -------------------------
                                                |  Business Components   |
                                                |       - EJB            |
                                                -------------------------


hOW Jakarta ee Components ARE managed

- Jakarta EE  component are managed by runtime environment known as Container.
- Since there 2 type of managed component , there 2 type container
1. WEb Container (responsible for Managing web component )
2. EJB Container (responsible for Managing EJB component  )

how these container are made by Available?
  these container are made  available by 3rd part software known as 
  1. Web Server
  2. Application Server
1. Web Server
          it provide an environment known as web container and  hence it can be used 
          to execute web component like Servlet and Jsp
          There are several web servers available whereas  the most commonly used and
          popular one is Tomcat by Apache software Foundation.


2. Application server
     its is an extansion  to Web server.
     it not only provide web container but also EJB Container.

     there are several applicable server available:
         1. WebLogic (By Oracle Crop)
         2. webSpher(by IBM)
         3.JBoss(By RedHat)
         4. GlassFish(By Oracle Crop)
                   
                        
