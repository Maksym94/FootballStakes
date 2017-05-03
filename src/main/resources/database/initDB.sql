CREATE DATABASE IF NOT EXISTS football_stakes;
CREATE TABLE regular_commands(
id_regular_command PRIMARY KEY NOT NULL AUTO_INCREMENT,
command_name VARCHAR(50) NOT NULL,
history VARCHAR(50),
trainer_name VARCHAR(50) NOT NULL,
won_games INT(11) NOT NULL DEFAULT 0,
lose_games INT(11) NOT NULL DEFAULT 0,
draw_games INT(11) NOT NULL DEFAULT 0,
photo_path VARCHAR(150),
year_foundation INT(4) NOT NULL
)