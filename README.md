Watchlist Application
This is a Spring Boot-based application to manage a movie watchlist. It allows users to perform basic CRUD operations for movies, directors, and movie-director pairings. The project uses an in-memory data structure (HashMap) to store movie and director data, which is an alternative to using a database for simplicity.

Features
Add a Movie

Endpoint: POST /movies/add-movie
Pass a Movie object in the request body to add a new movie to the watchlist.
Add a Director

Endpoint: POST /movies/add-director
Pass a Director object in the request body to add a new director to the list.
Pair a Movie with a Director

Endpoint: PUT /movies/add-movie-director-pair
Pass movieName and directorName as request parameters to associate a director with a movie.
Get a Movie by Name

Endpoint: GET /movies/get-movie-by-name
Pass movieName as a query parameter to retrieve the movie details.
Get a Director by Name

Endpoint: GET /movies/get-director-by-name
Pass directorName as a query parameter to retrieve director details.
Get Movies by Director Name

Endpoint: GET /movies/get-movies-by-director-name
Pass directorName as a query parameter to get all movies directed by a specific director.
Delete Director and Their Movies

Endpoint: DELETE /movies/delete-director-by-name
Pass directorName as a request parameter to delete a director and all their associated movies from the list.
Delete All Directors and Their Movies

Endpoint: DELETE /movies/delete-all-directors
Removes all directors and their movies from the records.
Technologies Used
Spring Boot - Java-based framework for building the application.
RESTful API - For communication and data exchange.
HashMap - Used to store movie, director, and movie-director pair data in memory.
Setup & Installation
Clone the repository:

bash
Copy
Edit
git clone <repository-url>
Navigate to the project folder:

bash
Copy
Edit
cd <project-folder>
Build and run the project using Maven:

bash
Copy
Edit
mvn spring-boot:run
Once the application starts, you can test the endpoints using tools like Postman or cURL.

Example Requests
1. Add a Movie
Endpoint: POST /movies/add-movie
Body:
json
Copy
Edit
{
  "name": "Inception",
  "durationInMinutes": 148,
  "imdbRating": 8.8
}
2. Add a Director
Endpoint: POST /movies/add-director
Body:
json
Copy
Edit
{
  "name": "Christopher Nolan",
  "numberOfMovies": 10,
  "imdbRating": 8.5
}
3. Pair a Movie with a Director
Endpoint: PUT /movies/add-movie-director-pair?movieName=Inception&directorName=Christopher Nolan
4. Get Movie by Name
Endpoint: GET /movies/get-movie-by-name?movieName=Inception
5. Get Movies by Director
Endpoint: GET /movies/get-movies-by-director-name?directorName=Christopher Nolan
Contributing
Feel free to fork this repository and submit a pull request with any enhancements or bug fixes.

License
This project is licensed under the MIT License - see the LICENSE file for details.

You can replace <repository-url> and <project-folder> with your actual repository URL and folder name.
