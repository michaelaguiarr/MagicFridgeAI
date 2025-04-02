CREATE TABLE FOOD_ITEM (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           nome VARCHAR(255) NOT NULL,
                           categoria VARCHAR(255),
                           quantidade INT NOT NULL,
                           validade DATE
);
