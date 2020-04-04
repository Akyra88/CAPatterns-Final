# CAPatterns-Final
 
I have managed to create a DAO class successfully and a Singleton class.

 The Singleton class was my choice since it is one of the most popular design patterns
and not as complicated as some other ones. The class Singleton restricts a class to
instantiate its multiple objects. It is used where only a single instance of a class 
is required to control the action throughout the execution of this project.
A DAO class is responsible for getting data from a data source which in this case is
a database given by the lecturer. It  isolates the business layer (logic) from the 
persistence layer (such as database) by using an abstract API. In simple words the DAO 
provides an abstract interface to a database. The great thing about this is that as it
separetes the bussiness logic and the data, the application does not know any details about the 
database as it is the DAOs job and as well giving the client a way to work with a database
without having to modify any code.
