# Songr

## Lab11 - Building Full-Stack Web Apps

### Overview 

Building a basic webapp that using Spring MVC Data and Thymeleaf.


### Controller

- SongrController

### Model

- Album Model

### Routers:

- index (root page) => http://localhost:8080/

- hello (Welcome page) => http://localhost:8080/hello

- capitalize (capitalize page) => http://localhost:8080/capitalize/hello

- albums => http://localhost:8080/albums

### Classes :

#### Album Class 

- String title => album title.

- String artist => artist name.

- int songCount => the number of songs in the album.

- long length =>  the total lenght of songs in seconds.

- String imageUrl => the album image URL.

Generating a constructor with the previous variables. And also generating getters and setters for all variables . 





## Lab: 12 - Spring and REST

### Overview 

Updating Album model so that it can be saved in a database.
An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album's art.
- Allowing the user to add albums to the site using @PostMapping annotation .  
- Allowing the user to see information about all the albums on the site using @GetMapping annotation .
- Adding a form to the albums.html file to allow the users to add a new album .


## Lab: 13 - Related Resources and Integration Testing

## Overview

The requirement for this lab is how the user can add a song to the specific album by fill the forms.

Ensure that the relationship between Albums and Songs is appropriately set up (one to many)

- A user should be able to see information about all the songs on the site.
- A user should be able to view a page with data about one particular album.
- A user should be able to add songs to an album.
- A user should be able to see the songs that belong to an album when looking at that album.

