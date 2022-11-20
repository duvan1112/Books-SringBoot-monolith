--bibliotecario
--rVks1aK.xZeXjWyM

create table libro
(
    id          int primary key auto_increment,
    nombre      varchar(200)  not null,
    descripcion varchar(2000) not null,
    imagen_url  varchar(500)  not null
);


insert into libro(nombre, descripcion, imagen_url)
values ('El principito',
        'El principito es un cuento infantil escrito por el aviador y escritor francés Antoine de Saint-Exupéry, publicado en 1943. La obra es una fábula filosófica que trata sobre la amistad, la soledad, la sabiduría y la pérdida de la inocencia.',
        'https://image.isu.pub/150228213310-8e3fceaebcf6fbb4285d7867c427df34/jpg/page_1.jpg');
insert into libro(nombre, descripcion, imagen_url)
values ('Java For Dummies',
        'Como un lenguaje de programación orientado a objetos imparable e independiente de la plataforma, Java se utiliza para desarrollar aplicaciones web y móviles.  En este libro superventas actualizado, el autor veterano Barry Burd le muestra cómo crear objetos básicos de Java y explica claramente cuándo debería simplemente reutilizar el código existente.',
        'https://m.media-amazon.com/images/I/51Gck4g+y9L._SX258_BO1,204,203,200_.jpg');


create table editorial
(
    id          int primary key auto_increment,
    nombre      varchar(200)  not null,
    sitio_web   varchar(500)
);

INSERT INTO editorial(id, nombre, sitio_web) VALUES (1, 'Editorial Planeta', 'https://www.planetadelibros.com.co/'),
                                                    (2, 'Mirahadas', 'https://www.miradas.com/'),
                                                    (3, 'Editorial Norma', 'https://www.normaeditorial.com/'),
                                                    (4, 'Editorial Oceano', 'https://www.editorialoceano.com/'),
                                                    (5, 'Editorial Planeta', 'https://www.planetadelibros.com.co/'),
                                                    (6, 'Editorial Norma', 'https://www.normaeditorial.com/'),
                                                    (7, 'Editorial Oceano', 'https://www.editorialoceano.com/'),
                                                    (8, 'Editorial Planeta', 'https://www.planetadelibros.com.co/'),
                                                    (9, 'Editorial Norma', 'https://www.normaeditorial.com/'),
                                                    (10, 'Editorial Oceano', 'https://www.editorialoceano.com/');

alter table libro
    add column editorial_id int,
    add foreign key (editorial_id) references editorial(id);

update libro set editorial_id = 1 where id in (1,5);
update libro set editorial_id = 2 where id in (2);
update libro set editorial_id = 3 where id in (3);
update libro set editorial_id = 4 where id in (4);
update libro set editorial_id = 5 where id in (6);
update libro set editorial_id = 6 where id in (7);
update libro set editorial_id = 7 where id in (8);

alter table libro
modify editorial_id int not null;