
--Creating Game db
--1. create database capstonebackend
--2. \connect capstonebackend
--3. CREATE TABLE game(
--       id BIGINT PRIMARY KEY     NOT NULL,
--       organizer VARCHAR(20),
--       location VARCHAR(20)
--   );
--4. \dt
--5. select * from game;    //(show all the data in this table named game )

--Creating Player db
--
--3. CREATE TABLE player(
--       id BIGINT PRIMARY KEY     NOT NULL,
--       firstName VARCHAR(20),
--       userName VARCHAR(20),
--       gamesPlayed INTEGER
--       UNIQUE(userName)
--   );


   ///// second attempt at creating tables

1. create database capstonebackend
2. \connect capstonebackend
3. ...

CREATE TABLE location (
  id serial PRIMARY KEY
, latitude float
, longitude float
);

CREATE TABLE game (
  game_id serial PRIMARY KEY
, title text NOT NULL
, description text NOT NULL
, game_date date NOT NULL DEFAULT CURRENT_DATE
, location_id int NOT NULL references location(id) ON DELETE CASCADE
);


CREATE TABLE game_player (
  game_id int REFERENCES game (game_id) ON UPDATE CASCADE ON DELETE CASCADE
, player_id int REFERENCES player (player_id) ON UPDATE CASCADE
, role text NOT NULL DEFAULT 'player'
, CONSTRAINT game_player_pkey PRIMARY KEY(game_id, player_id)
);

CREATE TABLE player (
  player_id serial PRIMARY KEY
, first_name text NOT NULL
, user_name text NOT NULL
, games_played int DEFAULT 0
, profile_picture VARCHAR (255) DEFAULT 'https://saage.edu.sg/wp-content/uploa)ds/2018/08/Unknown-Girl.jpg'
);