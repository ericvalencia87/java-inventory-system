
--Create Users Table
create table users(
	user_id int AUTO_INCREMENT,
    username varchar(250) UNIQUE NOT NULL,
    password varchar(1000),
    user_type boolean DEFAULT true, -- true = admin,  false = regular user
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL,
    status boolean DEFAULT true,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)
);

--Insert Dummy Data to users table
INSERT INTO users(username, first_name, last_name)
VALUES("egv", "eric", "valencia"),
("kgv", "kristine", "valencia"),
("fgv", "frederick", "valencia"),
("agv", "ericka", "valencia")


