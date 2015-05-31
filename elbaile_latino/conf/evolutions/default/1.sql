# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                        integer not null,
  teacher_id                bigint,
  title                     varchar(255),
  start_date                timestamp,
  number_of_classes         integer,
  number_of_participants    integer,
  max_number_of_participants integer,
  language_id               bigint,
  dance_style_id            bigint,
  dance_level               varchar(255),
  status                    varchar(255),
  constraint pk_course primary key (id))
;

create table dance_style (
  id                        bigint not null,
  teacher_id                bigint not null,
  dance_style_name          varchar(255),
  constraint uq_dance_style_dance_style_name unique (dance_style_name),
  constraint pk_dance_style primary key (id))
;

create table language (
  id                        bigint not null,
  teacher_id                bigint not null,
  language_name             varchar(255),
  constraint uq_language_language_name unique (language_name),
  constraint pk_language primary key (id))
;

create table teacher (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  img_url                   varchar(255),
  professional_experience   varchar(255),
  nationality               varchar(255),
  date_of_birth             timestamp,
  constraint uq_teacher_user_name unique (user_name),
  constraint uq_teacher_email unique (email),
  constraint pk_teacher primary key (id))
;

create sequence course_seq;

create sequence dance_style_seq;

create sequence language_seq;

create sequence teacher_seq;

alter table course add constraint fk_course_teacher_1 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;
create index ix_course_teacher_1 on course (teacher_id);
alter table course add constraint fk_course_language_2 foreign key (language_id) references language (id) on delete restrict on update restrict;
create index ix_course_language_2 on course (language_id);
alter table course add constraint fk_course_danceStyle_3 foreign key (dance_style_id) references dance_style (id) on delete restrict on update restrict;
create index ix_course_danceStyle_3 on course (dance_style_id);
alter table dance_style add constraint fk_dance_style_teacher_4 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;
create index ix_dance_style_teacher_4 on dance_style (teacher_id);
alter table language add constraint fk_language_teacher_5 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;
create index ix_language_teacher_5 on language (teacher_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists course;

drop table if exists dance_style;

drop table if exists language;

drop table if exists teacher;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists course_seq;

drop sequence if exists dance_style_seq;

drop sequence if exists language_seq;

drop sequence if exists teacher_seq;

