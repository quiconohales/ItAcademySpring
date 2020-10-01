
DROP TABLE IF EXISTS employee;
DROP table IF EXISTS job;


CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(250) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
  
);
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `employee_fk` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
);

insert into job (position, salary) values ('JEFE',100000);
insert into job (position, salary) values ('Currante',5000);

insert into employee(name,job_id)values('Pepe', 2);
insert into employee(name,job_id)values('Juan', 1);
