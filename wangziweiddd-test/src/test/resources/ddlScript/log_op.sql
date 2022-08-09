create table log_op (
                        id bigint unsigned comment '主键' auto_increment,
                        opPeopleName varchar(128) not null comment '姓名',
                        logTime date,
                        logTypeEnum varchar(128),
                        value varchar(128),
                        itemkey varchar(128),
                        constraint pk primary key (id)
) default character set utf8mb4  auto_increment=1