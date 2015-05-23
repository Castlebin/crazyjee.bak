
    drop table if exists news_inf

    drop table if exists NEWS_ID_GEN

    create table news_inf (
        id integer not null,
        content varchar(255),
        title varchar(255),
        primary key (id)
    ) ENGINE=InnoDB

    create table NEWS_ID_GEN (
         gen_key varchar(255),
         gen_value integer 
    ) ENGINE=InnoDB
