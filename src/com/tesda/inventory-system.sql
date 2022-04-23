
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

--insert the default admin
INSERT INTO users(username,password, first_name, last_name)
VALUES("admin", "5b424035656630346235:a877643f145245c28aa2d26ff9e610bd48c0d998dc590919a69e22ec979e9c37af70a13a76f445b7c3861a29d619dd0e39408f8b7ab216b0a36e40b3876d8e2b","admin", "admin")

--Insert Dummy Data to users table
INSERT INTO users(username, user_type,  first_name, last_name)
VALUES("egv",0, "eric", "valencia"),
("kgv",0, "kristine", "valencia"),
("fgv",0, "frederick", "valencia"),
("agv",0, "ericka", "valencia")


