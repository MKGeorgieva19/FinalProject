# Movie management system example implemented with three layer model in JAVA.

A simple implementation of a movie management system divided into seperate software architectural layers.


## Documentation

[Documentation](https://linktodocumentation)

## Presentation

[Presentation](https://codingburgas-my.sharepoint.com/:p:/g/personal/dyanakiev_codingburgas_bg/ERqOKShsycVEsBhkd1zZwdkB1r1cBTQGt3Bk_GSYnry19Q?e=GavgmI)


## Environment Variables

To run this project, you will need to change the host machine name in the ProjectProperties class under Utilities.

`.../SQLEXPRESS`

`YOUR_DEVICE_NAME/SQLEXPRESS`


## UML Diagrams

#ERD https://lucid.app/lucidchart/e468a30d-ac0e-4cd9-9ffd-84abd4ca8ab5/edit?invitationId=inv_78324e31-cd6d-4350-8237-26bd697814a2
This entity-relationship diagram (ERD) illustrates the relationships between four classes: Actor, Genre, Movie, and User.
The Actor class is represented by a table with the title "Actor", and has two attributes: id and name. The id attribute is a unique identifier for each actor, and the name attribute is the name of the actor.

The Genre class is represented by a table with the title "Genre", and has two attributes: id and name. The id attribute is a unique identifier for each genre, and the name attribute is the name of the genre.

The Movie class is represented by a table with the title "Movie", and has several attributes: id, name, movieOrSeries, yearOfPublishing, description, company, duration, IMDBScore, numberOfSeasons. The id attribute is a unique identifier for each movie, and the name attribute is the name of the movie, movieOrSeries tells us whether it's a movie or series, yearOfPublishing is the year when it was published, description is a brief summary of the movie, company is the company that produced the movie, duration is the length of the movie, IMDBScore is the IMDB rating of the movie, numberOfSeasons is the number of seasons if it's a series.

The User class is represented by a table with the title "User", and has several attributes: id, firstName, lastName, username, password, email, salt and admin. The id attribute is a unique identifier for each user, the firstName and lastName attributes store the user's first and last names, username attribute is the user's unique username, password attribute stores the hashed password, email attribute is the user's email address, salt attribute is used for password hashing, admin attribute is a boolean variable that stores whether the user is an admin or not.

#Class diagram https://lucid.app/lucidchart/0e26e411-a974-422c-bf93-073425a36c08/edit?invitationId=inv_56e0a89e-f0ac-40ac-956f-772c86fcafc2         
In this class diagram, 

An actor is represented by the "Actor" class, and has two attributes: id and name.

A genre is represented by the "Genre" class, and has two attributes: id and name.

A movie is represented by the "Movie" class, and has several attributes: id, name, movieOrSeries, yearOfPublishing, description, company, duration, IMDBScore, numberOfSeasons.

A user is represented by the "User" class, and has several attributes: id, firstName, lastName, username, password, email, salt and admin status.

It is important to note that this is just one possible way to diagram the classes and their relationships, and there may be other ways that are more appropriate depending on the specific requirements of your application.
