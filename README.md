# Hero/Character API

This project exposes a set of endpoints for interacting with the resource Character based on the next requirement [Requirement](https://github.com/leo-from-BX/likeDislike).

## Cors

The endpoints are protected by cors policy, only the client http://localhost:3000/ can consume without problem.

## Run instructions

In order to run this project in your local is prerequisite to have docker installed in a recent version.
To run this project in your local execute the next commands

`docker build --tag=blue-server:latest .`
`docker run -p 8080:8080 blue-server:latest`

If you want to remove and stop it:

`docker stop blue-server`
`docker rm blue-server`

### API get random character

url:http://localhost:8080/characters/random
http operation: GET

### API get specific character by id

url: http://localhost:8080/characters/{id}
http operation: GET

### API get the top 5 characters order by likes number

url: http://localhost:8080/characters?orderBy=LIKE
http operation: GET
Order by possible values: LIKE,DISLIKE

### API search character by name

url: http://localhost:8080/characters?name=super
http operation: GET

### API get the character with the most recent like or dislike

url: http://localhost:8080/characters/last
http operation: GET

### API add a new like to character

url: http://localhost:8080/characters/{id}/like
http operation: PATCH

### API add a new dislike to character

url: http://localhost:8080/characters/{id}/dislike
http operation: PATCH

## Improvements

### Security
1. Request sanitization.
2. Jwt token for authorization.
3. Secure protocol.

### Idempotency
How bad is having duplication on like or dislike operation?
Assuming that all the interactions are anonymous (the user is not stored):
1. Idempotency-key header, for the patch operations like and dislike, the client must send a header (UUID).
2. The client (browser) must store this key at least 24 hours and incase of sending like from the same browser, the key should be the same.
3. The backend must store (cache) the key and once a request is received, validate if this key was previously processed. All the associated keys to successful requests must be stored during 24 hours.

### Pagination
Adding pagination for the get operations.

### Instrumentation (AOP)
1. Logging.
2. Monitoring the database interactions.
