create table people (
                        id bigint unsigned comment '主键' auto_increment,
                        name varchar(128) not null comment '姓名',
                        constraint pk primary key (id)
) default character set utf8mb4  auto_increment=1