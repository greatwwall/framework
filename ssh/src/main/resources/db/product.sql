drop table if exists `product`;
create table `product`(
	`id` int(4) primary key not null auto_increment,
	`name` varchar(100) not null,
	`price` double(7,2) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

