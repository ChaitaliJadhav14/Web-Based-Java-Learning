JDBC: JAVA TO DATABSE CONNECTIVITY.
it is api that allow java application to interact with DATABASE
(java)
                 (api)
java app ------> JDBC-------> DB(DB vendor)
                                ↗️     ⬇️
                           ↗️       ( vendor specific api) 
                   ↗️
             ↗️
java object
JDBC Driver: A Driver a program that convert JDBC calls into some format that is compatible with vendor Specific API.

vendor Specific API is api provided by Db vendor (product provider)
 to simplify access  for the applications which want to interact with Db

 JDBC Driver are mainly 4 type are:

 1.Type 1         
 2.Type 2
 3.Type 3
 4.Type 4

 1.Type 1  
    -  it is called as JDBC-ODBC Bridge.
    -  ODBC is api given by microsoft.
    -  it uses 3rd party library i.e ODBC for conversion.
    -  Pros/Cons:
    -  it is simple to uses.
    -  it is the slowest.
    -  it platform dependent because ODBC id microsoft specific and     applicable  for windows platform only.
    -  Every client machine needs an ODBC configuration setup.
     - Suitable for small and simple application but not for large scale application.


java app                                         DB
    |                                             |
    |---->JDBC API---->Type 1---->ODBC API---->vend.pecific api  

                 +----------------------+
                |      Java App        |
                +----------------------+
                           |
                           |   JDBC API
                           v
                +------------------------------+
                |     JDBC Type 1 Driver       |
                |     (JDBC–ODBC Bridge)       |
                +------------------------------+
                           |
                           |     ODBC API
                           v
                +------------------------------+
                |  ODBC Driver (Vendor-Specific)|
                +------------------------------+
                           |
                           v
                     +-------------+
                     |     DB      |
                     +-------------+
   

Type2:
   - it called as Native API , Party Java Driver.
   - it uses a combination of java and db vendor specific implementation.
   - it uses db specific Native API for futher communication.
   - unlike Type1 it does not use 3rd part library.
   - it is faster as compared to type1 Driver.
   - it is platform independent.
   - Every client machine must have DB specific Native API installed.


                +----------------------+
                |      Java App        |
                +----------------------+
                           |
                           |   JDBC API
                           v
              +--------------------------------+
              |     JDBC Type 2 Driver         |
              | (Java + Native Library .dll/.so)|
              +--------------------------------+
                           |
                           |  Vendor-Specific Native API
                           v
               +------------------------------+
               |            Database           |
               +------------------------------+


Type3:
   - called as Net Protocal, Intermediate DB Access Server.
   -  it used when a client application needs  to interact with muiltiple db Server.
   - it uses 3rd party software known as Intermediate DB Access Server.
     that act as a router to dispatch the call towords db Server.    

                   +----------------------+
                  |      Java App        |
                  +----------------------+
                             |
                             |  JDBC Type 3 (Middleware Driver)
                             v
        +----------------------------------------------------+
        |   Intermediate DB Access Server (Middleware Tier)  |
        |  (Translates vendor-specific protocol <-> JDBC)    |
        +----------------------------------------------------+
           /                    |                     \
          /                     |                      \
         v                      v                       v
 +----------------+     +----------------+      +----------------+
 |      DB1       |     |      DB3       |      |      DB4       |
 +----------------+     +----------------+      +----------------+

 Type4:
   - called as vendor specific, Pure Java Driver
   - ir is Driver provided bt DB  vendor but completely implementate using java.
   - it uses TCP/IP Socket connection  for futher communication.
   - it is fastest.
   - it is platform independent.
   - it does not need any configuration setup on client machine.
   - Therefore it is highly recommended for large scale application and production environment.
                  +----------------------+
                  |      Java App        |
                  +----------------------+
                             |
                             |   JDBC API
                             v
                +-------------------------------+
                |     JDBC Type 4 Driver        |
                | (Pure Java Database Driver)   |
                +-------------------------------+
                             |
                             |  IP Address + Port No.
                             v
                +----------------------------------+
                |   Vendor-Specific Database API    |
                |     (MySQL / Oracle / PostgreSQL)|
                +----------------------------------+
                             |
                             v
                     +---------------+
                     |      DB       |
                     +---------------+

  JDBC Core API:- the JDBC API belong the package : java.sql 
     1. DriverManager   (Clsss)--->Establish connection
     2. Connection      (Interface-I)--->Represents an active connection
     3. Statement         (I)----->Execute SQL queries
     4. PreparaedStatemet (I)----->Precompiled SQL (faster + secure)
     5. CallableStatement(I)------->Call stored procedures
     6. ResultSet        (I)------->Holds SELECT results
All classes are in java.sql package.

  Step in JDBC:
  1.load the Driver.
  2.Estsblish connection
  3.Obtain some Statement
  4.Execute SQL Query
  5.For SELECT query, obtain ResultSet and perfom navigation.


com.mysql.cj.jdbc.Driver

  com.mysql → MySQL company package
  cj → "Connector/J" (the official JDBC driver for MySQL)
  jdbc → JDBC package
  Driver → The driver class that handles the connection

JAR File(.jar)-> (java Archive(combination of several.class file))
       |
       |
       ⬇
      MySQL type 4 Driver Class(.Class file)
 ---->  Driver.Class

 Steps:
 -  Right-click your project
 -  Click Build Path → Add External Archives
 -  Select:mysql-connector-j-8.0.xx.jar
 -  Click Apply and Close

Meaning of jdbc:mysql://localhost:3306/cdacs
jdbc        → Java Database Connectivity protocol (Main Protocal) 
mysql       → Database type (MySQL)  (sub protocol)
localhost   → Database server is running on your computer  (IP Address)
3306        → MySQL port number  
cdacs       → Database name  
?useSSL=false → This is a URL parameter that tells MySQL Driver:
               "Do not use SSL (Secure Socket Layer) when connecting."
Socket = localhost+portno

ResultSet :
       is representation of th data fetched from Db table on java side(client side)
     - it holds the data in the form of row and columns just like a typical db table.
     - every row has record position and every columns has column index.
     both of them start with 1 not 0.
     - apart from the actual record position , there 2 additional position
     1. Before First
     2. After last 
     
    - by default the cursor of the ResultSet points to Before First.
    - In case of Column the index depends upon the SQL query and not the actual DB table design.
    - In order  to perform navigation on ResultSet , the Interface provide next() method.
    - it check whether next record is available or not and shift the cursor to that record is available or not and shifts the  cursor to that record if it is available.
    it return a boolean value.
    - in order to read the values, the Interface provide relevent getter method.
    eg : getInt()--->read Int
         getString()---read String 
    


                           BEFORE FIRST
                          |
                          v
                   (cursor starts here)
                          |
                          | rs.next()
                          v
          +-------------------------------------+
Column →  |   1      |     2      |      3      |
          |  (id)    |   (name)   |   (city)     |
          +-------------------------------------+
Row 1 →   |   101    |  Rakesh    |    Pune      |
          +-------------------------------------+
Row 2 →   |   102    |  Anjali    |   Mumbai     |
          +-------------------------------------+
Row 3 →   |   103    |  Preeti    |   Mumbai     |
          +-------------------------------------+
                          |
                          | rs.next()
                          v
                       AFTER LAST


Standard Practices In JDBC:
1. Decouping (separating ) the code  for  Estsblishing Db Connection.
2. Auto-Loading of driver Class.
3. Auto-closing of resources eg. Connection, Statement, ResultSet.
4. implementing DAO Pattern.

                    +-----------------------------+
                    |         DaoInterface<T,ID>   |
                    |------------------------------|
                    |  + getAll()                  |
                    |  + getById(ID id)            |
                    |  + save(T entity)            |
                    |  + update(T entity)          |
                    |  + deleteById(ID id)         |
                    +---------------↑--------------+
                                    |
                                    | implements
                                    |
                    +-------------------------------+
                    |        StudentDao              |
                    |------------------------------- |
                    |  uses JDBC to talk to MySQL    |
                    +-----------------------↑--------+
                                            |
                                            | maps
                                            |
          +-------------------------+       |       +-----------------------------+
          |       Student Class     |       |       |        MySQL Table         |
          |-------------------------|       |       |          students           |
          | - int studentId         |-------+------>| student_id   (INT)         |
          | - String studentName    | maps fields   | student_name (VARCHAR)     |
          | - String studentCity    | <-------------| student_city (VARCHAR)     |
          +-------------------------+               +-----------------------------+


DriverManager:
     it is class use to Estsblish connection with db.
   - it can Estsblish connection with Database using JDBC Driver only
      when the driver itself is registered with DriverManager  
   - Generally all driver implementation clases provide static block that
     already contains the code for registration.
   - Therefore to perfom the registration, the excution of the static block is required
      that is possible by loading the driver specific class.

 Ques:---why loading of jdbc driver is important?       
      com.mysql.cj.jdbc    
      class Driver{
        static code for registration with DriverManager
      } 

                              Java Program
                             |
                             | 1. Driver class is loaded
                             v
                 +-----------------------------+
                 |  com.mysql.cj.jdbc.Driver   |
                 |-----------------------------|
                 |  static {                   |
                 |     new Driver();           |
                 |     DriverManager.register( |
                 |           thisDriver );     |
                 |  }                          |
                 +---------------+-------------+
                                 |
                                 | 2. Driver auto-registers
                                 v
                 +------------------------------------+
                 |        java.sql.DriverManager      |
                 |------------------------------------|
                 |  Maintains list of registered       |
                 |  JDBC drivers                       |
                 +------------------------------------+
                                 |
                                 | 3. When you call
                                 |    DriverManager.getConnection()
                                 v
                     +-----------------------------+
                     |  MySQL Driver handles URL   |
                     |  jdbc:mysql://...           |
                     +-----------------------------+
                        
