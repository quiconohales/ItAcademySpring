//DROP table IF EXISTS jobs;
//DROP TABLE IF EXISTS employee;


CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `employee_fk` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
);

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(250) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
  
);


insert into employee(name,salary)values('Pepe', 1);
insert into employee(name,salary)values('Juan', 2);

insert into job (position, salary) values ('JEFE',100000);
insert into job (position, salary) values ('Currante',5000);

