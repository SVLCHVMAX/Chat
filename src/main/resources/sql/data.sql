INSERT INTO role VALUES
(0,'ADMINISTRATOR'),
(1,'MODERATOR'),
(2, 'USER');

INSERT INTO users VALUES
(0,'Max','Max123','password',2),
(1,'Alena','Alenka','password',2),
(2,'Misha','Mishka','password',2),
(3,'Igor','Igor333','password',2);

INSERT INTO room VALUES
(0,'Комната 1'),
(1,'Комната 2');

INSERT INTO message VALUES
(0,'Всем привет!',0,0),
(1,'Приветики! Как дела!',1,0),
(2,'Все отлично!',0,0),
(3,'Пока!',1,0),
(4,'Есть кто?',2,1),
(5,'Ну я!',3,1);

INSERT INTO user_room VALUES
(0,0),
(1,0),
(2,1),
(3,1);
