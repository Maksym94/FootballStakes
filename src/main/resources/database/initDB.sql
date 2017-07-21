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

CREATE TABLE IF NOT EXISTS users(
id_user INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
username VARCHAR(50) NOT NULL,
balance DECIMAL(6,2),
stakes_won TINYINT(6) DEFAULT 0,
stakes_lose TINYINT(6) DEFAULT 0,
money_won DECIMAL(6,2),
money_lose DECIMAL(6,2),
received_gift_money DECIMAL(6,2),
sent_gift_money DECIMAL(6,2)
);

CREATE TABLE IF NOT EXISTS roles(
id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
role_name VARCHAR(15) NOT NULL);

CREATE TABLE IF NOT EXISTS credentials(
id_login INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
login VARCHAR(100) NOT NULL, 
password VARCHAR(255));

CREATE TABLE IF NOT EXISTS user_operations(
id_operation INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_user INT(11) NOT NULL,
date VARCHAR(20) NOT NULL,
amount DECIMAL(10,2) NOT NULL,
current_balance DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS system_balance(
id_system_money INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
received_bank_money DECIMAL(10,2) NOT NULL DEFAULT 0,
received_users_money DECIMAL(10,2) NOT NULL DEFAULT 0,
payed_users_money DECIMAL(10,2) NOT NULL DEFAULT 0,
received_commissions_gift_money DECIMAL(10,2) NOT NULL DEFAULT 0
);
