insert into roles(name)
values('USER'),
      ('ADMIN');

insert into users(id, first_name, last_name, username, password, role_name)
values (1, 'John', 'Doe', 'JDoe', 'test', 'ADMIN'),
       (2, 'Max', 'Mustermann', 'MM', 'test1', 'USER');
