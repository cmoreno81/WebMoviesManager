
drop sequence pid_seq restrict;
create table roles(
    id  INT PRIMARY KEY,
    rol VARCHAR (40) NOT NULL,
    estado BOOLEAN);
create sequence pid_seq as int start with 1 increment by 1 no cycle;