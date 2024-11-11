CREATE TABLE IF NOT EXISTS hero(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(1000) NOT NULL,
    `image_url` varchar(1000) NOT NULL,
    `likes` bigint(10) NOT NULL,
    `dislike` bigint(10) NOT NULL,
    PRIMARY KEY (`id`)
);