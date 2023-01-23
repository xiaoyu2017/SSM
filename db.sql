CREATE DATABASE SSM;

USE SSM;

CREATE TABLE IF NOT EXISTS user
(
    `id`       int AUTO_INCREMENT,
    `name`     varchar(20) UNICODE,
    `age`      int,
    `email`    varchar(20) UNICODE NOT NULL,
    `birthday` timestamp,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;