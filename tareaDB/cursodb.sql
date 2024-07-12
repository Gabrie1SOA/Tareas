create database curso;
use curso;

create table usuariosadministrador (
	codigo int primary key auto_increment,
    nombre varchar(20),
    cedula varchar(20),
	correo varchar(30)
);

select * from usuariosadministrador;

create table estudiantes(
	codigo_matricula int primary key,
    nombre_apellido varchar(100),
    direccion varchar(20),
    edad varchar(20),
    telefono varchar(10),
    correo varchar(20),
    nota1 double,
    nota2 double

);

select * from estudiantes;

insert into estudiantes(codigo_matricula,nombre_apellido,direccion,edad,telefono,correo,nota1,nota2) VALUES
	(1,"Gabriel Santiago","Quito","20","09912345","ejemplo@mail.com",8.5,10)
;

insert into usuariosadministrador (nombre,cedula,correo) values
	("Juan","123456789","ejemplo@mail.com")
;