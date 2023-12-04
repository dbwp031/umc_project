ALTER TABLE store DROP FOREIGN KEY FKschfgppyql8cgv1v4724mlese;
ALTER TABLE review DROP FOREIGN KEY FK74d12ba8sxxu9vpnc59b43y30;
ALTER TABLE review DROP FOREIGN KEY FKk0ccx5i4ci2wd70vegug074w1;
ALTER TABLE store_region DROP FOREIGN KEY FKltuv7kc577t2xc9u9arapoxg9;
ALTER TABLE store_region DROP FOREIGN KEY FKc8v893b1ls0hqlty9wb8q4004;
ALTER TABLE mission DROP FOREIGN KEY FKckx1b8plp95qtdk73kylhy12n;
ALTER TABLE member_mission DROP FOREIGN KEY FKibnub11mc8k2g39v44smt9jqi;
ALTER TABLE member_mission DROP FOREIGN KEY FKpgw7uojmq1tkna2ubpxmhlyuo;
ALTER TABLE member_agree DROP FOREIGN KEY FKg33d9g6nwdsilmn85of0tt35q;
ALTER TABLE member_agree DROP FOREIGN KEY FKidc8ol6y753cph4vuq9fa9scd;
ALTER TABLE liked_food_category DROP FOREIGN KEY FKbvx4wsmg5lc1ni7788ghevgey;
ALTER TABLE liked_food_category DROP FOREIGN KEY FKh04y8vkawh0f28ud2rvxrmpvf;

DROP TABLE IF EXISTS store_region;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS liked_food_category;
DROP TABLE IF EXISTS member_mission;
DROP TABLE IF EXISTS member_agree;
DROP TABLE IF EXISTS mission;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS terms;
DROP TABLE IF EXISTS food_category;


create table food_category (
                               id bigint not null auto_increment,
                               created_at datetime(6),
                               updated_at datetime(6),
                               name varchar(255),
                               primary key (id)
);
create table liked_food_category (
                                     id bigint not null auto_increment,
                                     created_at datetime(6),
                                     updated_at datetime(6),
                                     food_category_id bigint,
                                     member_id bigint,
                                     primary key (id)
);
create table member (
                        id bigint not null auto_increment,
                        created_at datetime(6),
                        updated_at datetime(6),
                        address varchar(255),
                        age integer,
                        email varchar(255),
                        gender varchar(255),
                        inactivate_date date,
                        name varchar(255),
                        point float,
                        social_type varchar(255),
                        spec_address varchar(255),
                        status varchar(255),
                        primary key (id)
);
create table member_agree (
                              id bigint not null auto_increment,
                              created_at datetime(6),
                              updated_at datetime(6),
                              member_id bigint,
                              terms_id bigint,
                              primary key (id)
);
create table member_mission (
                                id bigint not null auto_increment,
                                created_at datetime(6),
                                updated_at datetime(6),
                                status varchar(255),
                                member_id bigint,
                                mission_id bigint,
                                primary key (id)
);
create table mission (
                         id bigint not null auto_increment,
                         created_at datetime(6),
                         updated_at datetime(6),
                         content varchar(255),
                         deadline datetime(6),
                         reward float,
                         store_id bigint,
                         primary key (id)
);
create table region (
                        id bigint not null auto_increment,
                        created_at datetime(6),
                        updated_at datetime(6),
                        name varchar(255),
                        primary key (id)
);
create table review (
                        id bigint not null auto_increment,
                        created_at datetime(6),
                        updated_at datetime(6),
                        content varchar(255),
                        member_id bigint,
                        store_id bigint,
                        primary key (id)
);
create table store (
                       id bigint not null auto_increment,
                       created_at datetime(6),
                       updated_at datetime(6),
                       address varchar(255),
                       name varchar(255),
                       score float,
                       food_category_id bigint,
                       primary key (id)
);
create table store_region (
                              id bigint not null auto_increment,
                              created_at datetime(6),
                              updated_at datetime(6),
                              region_id bigint,
                              store_id bigint,
                              primary key (id)
);
create table terms (
                       id bigint not null auto_increment,
                       created_at datetime(6),
                       updated_at datetime(6),
                       context varchar(255),
                       optional bit,
                       title varchar(255),
                       primary key (id)
);
alter table liked_food_category
    add constraint FKh04y8vkawh0f28ud2rvxrmpvf
        foreign key (food_category_id)
            references food_category (id);

alter table liked_food_category
    add constraint FKbvx4wsmg5lc1ni7788ghevgey
        foreign key (member_id)
            references member (id);

alter table member_agree
    add constraint FKidc8ol6y753cph4vuq9fa9scd
        foreign key (member_id)
            references member (id);

alter table member_agree
    add constraint FKg33d9g6nwdsilmn85of0tt35q
        foreign key (terms_id)
            references terms (id);

alter table member_mission
    add constraint FKpgw7uojmq1tkna2ubpxmhlyuo
        foreign key (member_id)
            references member (id);

alter table member_mission
    add constraint FKibnub11mc8k2g39v44smt9jqi
        foreign key (mission_id)
            references mission (id);

alter table mission
    add constraint FKckx1b8plp95qtdk73kylhy12n
        foreign key (store_id)
            references store (id);

alter table review
    add constraint FKk0ccx5i4ci2wd70vegug074w1
        foreign key (member_id)
            references member (id);

alter table review
    add constraint FK74d12ba8sxxu9vpnc59b43y30
        foreign key (store_id)
            references store (id);

alter table store
    add constraint FKschfgppyql8cgv1v4724mlese
        foreign key (food_category_id)
            references food_category (id);

alter table store_region
    add constraint FKc8v893b1ls0hqlty9wb8q4004
        foreign key (region_id)
            references region (id);
alter table store_region
    add constraint FKltuv7kc577t2xc9u9arapoxg9
        foreign key (store_id)
            references store (id);