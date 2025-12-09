Develop a Spring Boot project that, using the Jakarta Persistence API (JPA), performs CRUD operations on a MySQL table containing data about cars.

Both the cars table (masini) and the database that contains it must be created programmatically. The cars table will be pre-populated through the data.sql file with data for 5 cars.

For each car, the following information is stored:

license plate number

brand

manufacturing year

color

mileage (number of kilometers)

The program must include a repository that provides data access by offering methods that allow:

a. Adding a car to the database b. Deleting a car identified by its license plate number c. Searching for a car by license plate number d. Retrieving a list of all cars in the database e. Determining the number of cars in the database that have a specific brand entered from the keyboard f. Determining the number of cars in the database that have less than 100,000 km g. Retrieving a list containing the cars that are newer than 5 years

In the main program, the repository methods will be called to verify their proper operation, and the data will be displayed in the console both using System.out.println() and a Logger.
