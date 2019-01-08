
Creating Game db
1. create database capstonebackend
2. \connect capstonebackend
3. CREATE TABLE game(
       id BIGINT PRIMARY KEY     NOT NULL,
       organizer VARCHAR(20),
       location VARCHAR(20)
   );
4. \dt
5. select * from game;    //(show all the data in this table named game )

Creating User db

3. CREATE TABLE user(
       id BIGINT PRIMARY KEY     NOT NULL,
       firstName VARCHAR(20),
       userName VARCHAR(20),
       gamesPlayed INTEGER
       UNIQUE(userName)
   );