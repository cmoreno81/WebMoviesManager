
drop sequence pid_seq restrict;
create table usuario(
    id  INT PRIMARY KEY,
    usuario VARCHAR (40) NOT NULL,
    password VARCHAR (40) NOT NULL,
    estado BOOLEAN, 
    roles VARCHAR (40));
create sequence pid_seq as int start with 1 increment by 1 no cycle;