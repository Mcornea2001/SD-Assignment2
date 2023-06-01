insert into teacher(id, logged_in, password, username)
values
    (1, false, '1234', 'admin'),
    (2, false, 'password1', 'teacher1');

insert into student(id, name, username, password, email, hobby, token, group_number, logged_in)
values
    (1, 'student1', 'student1', 'password1', 'example', 'gaming', 'abcde', 1, false),
    (2, 'student2', 'student2', 'password2', 'example2', 'football', '1dasdu', 2, false);

insert into assignment(id, deadline, description, name)
values
    (1, '2020-12-12', 'description1', 'assignment1'),
    (2, '2020-12-12', 'description2', 'assignment2');