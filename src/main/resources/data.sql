insert into roles values(1,'ADMIN');
insert into roles values(2,'USER');

insert into users values(1, 'testuser1@email.com', '$2a$17$Vx1flKEej6VDhMnOatREKu.DoMBLcs02QW63/HTgn0ts3gW.bYBJm', 'testuser1');--password is testuser1
insert into users values(2, 'testuser2@email.com', '$2a$17$UoChmeCt9aDori9QIPfJd.wCg9OHmFkWH403rrANhFZbG/ZPToyrm', 'testuser2');--password is testuser2

insert into users_roles values(1,1);
insert into users_roles values(2,2);