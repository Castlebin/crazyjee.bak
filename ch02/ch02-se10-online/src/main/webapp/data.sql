use crazyjee;

create table online_inf
(
 session_id varchar(255) primary key,
 username varchar(255),
 user_ip varchar(255),
 access_res varchar(255),
 last_access bigint
);
