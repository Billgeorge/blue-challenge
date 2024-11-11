# Hero/Character API

This project exposes a set of endpoints for interacting with the resource Character based on the next requirement [Requirement](https://github.com/leo-from-BX/likeDislike).

## Run instructions

In order to run this project in your local is prerequisite to have docker installed in a recent version.
To run this project in your local execute the next commands

`docker build --tag=blue-server:latest .`
`docker run -p 8080:8080 blue-server:latest`

If you want to remove and stop it:

`docker stop blue-server`
`docker rm blue-server`

### API get random character

url:http://localhost:8080/character/random
http operation: GET

### API get specific character by id

url: http://localhost:8080/character/{id}
http operation: GET

### API get the top 5 characters order by likes number

url: http://localhost:8080/character/all/like
http operation: GET

### API get the top 5 characters order by dislikes number

url: http://localhost:8080/character/all/dislike
http operation: GET

### API search character by name

url: http://localhost:8080/character/search?name=super
http operation: GET

### API get the character with the most recent like or dislike

url: http://localhost:8080/character/last
http operation: GET

### API add a new like to character

url: http://localhost:8080/character/{id}/like
http operation: PATCH

### API add a new dislike to character

url: http://localhost:8080/character/{id}/dislike
http operation: PATCH
