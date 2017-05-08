CREATE DATABASE IF NOT EXISTS football_stakes;

USE football_stakes;

 CREATE TABLE IF NOT EXISTS regular_commands (
id_regular_command INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
command_name VARCHAR(50) NOT NULL,
history VARCHAR(50),
trainer_name VARCHAR(50) NOT NULL,
won_games INT(11) NOT NULL DEFAULT 0,
lose_games INT(11) NOT NULL DEFAULT 0,
draw_games INT(11) NOT NULL DEFAULT 0,
photo_path VARCHAR(150),
year_foundation INT(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS tournament_commands(
id_tournament_command INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
command_name VARCHAR(50) NOT NULL,
history BLOB,
trainer VARCHAR(50) NOT NULL,
country_of_origin VARCHAR(40) NOT NULL,
won_games INT(11) NOT NULL DEFAULT 0,
lose_games INT(11) NOT NULL DEFAULT 0,
winning_cups INT(11) NOT NULL DEFAULT 0
);