CREATE DATABASE IF NOT EXISTS football_stakes;

USE football_stakes;

 CREATE TABLE IF NOT EXISTS regular_commands (
id_regular_command INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
command_name VARCHAR(50) NOT NULL,
history BLOB,
trainer_name VARCHAR(50) NOT NULL,
country_of_origin VARCHAR(40) NOT NULL,
won_games INT(11) NOT NULL DEFAULT 0,
lose_games INT(11) NOT NULL DEFAULT 0,
draw_games INT(11) NOT NULL DEFAULT 0,
goals_scored TINYINT(4) NOT NULL DEFAULT 0,
photo_path VARCHAR(150),
year_foundation INT(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS regular_games(
id_regular_game INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_command1 INT(11) NOT NULL,
id_command2 INT(11) NOT NULL,
score_command1 TINYINT(2) NOT NULL DEFAULT 0,
score_command2 TINYINT(2) NOT NULL DEFAULT 0,
coefficient_first_command DOUBLE(8,4) NOT NULL,
coefficient_second_command DOUBLE(8,4) NOT NULL,
start_game_date DATETIME NOT NULL,
finished_game BOOLEAN NOT NULL DEFAULT FALSE,
result_of_game TINYINT(1)
);

CREATE TABLE IF NOT EXISTS tournament_commands(
id_tournament_command INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
command_name VARCHAR(50) NOT NULL,
history BLOB,
trainer VARCHAR(50) NOT NULL,
year_foundation INT(4) NOT NULL,
photo_path VARCHAR(150),
won_games INT(11) NOT NULL DEFAULT 0,
lose_games INT(11) NOT NULL DEFAULT 0,
goals_scored TINYINT(4) NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS tournament_games(
id_tournament_game INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_command1 INT(11) NOT NULL,
id_command2 INT(11) NOT NULL,
score_command1 TINYINT(2) NOT NULL DEFAULT 0,
score_command2 TINYINT(2) NOT NULL DEFAULT 0,
coefficient_first_command DOUBLE(8,4) NOT NULL,
coefficient_second_command DOUBLE(8,4) NOT NULL,
start_game_date DATETIME NOT NULL,
finished_game BOOLEAN NOT NULL DEFAULT FALSE,
result_of_game TINYINT(1),
id_tournament_stage INT(11)
);

CREATE TABLE IF NOT EXISTS tournament_stages(
id_tournament_stage INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_tournament INT(11) NOT NULL,
stage DOUBLE NOT NULL,
active TINYINT(1) NOT NULL,
finished_stage TINYINT(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS tournament(
id_tournament INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
tournament_name VARCHAR(50) NOT NULL,
year_of_playing INT(4) NOT NULL,
max_amount_stages TINYINT(2) NOT NULL,
max_amount_commands TINYINT(2) NOT NULL,
active TINYINT(1) NOT NULL,
finished_tournament TINYINT(1) NOT NULL,
winner_cup_id_command INT(11)
);
