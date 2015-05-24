# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table dance_style (
  id                        bigint not null,
  dance_style_name          varchar(255),
  constraint uq_dance_style_dance_style_name unique (dance_style_name),
  constraint pk_dance_style primary key (id))
;

create table language (
  id                        bigint not null,
  language_name             varchar(255),
  constraint pk_language primary key (id))
;

create table teacher (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  img_url                   varchar(255),
  professional_experience   varchar(255),
  nationality               varchar(255),
  date_of_birth             timestamp,
  constraint pk_teacher primary key (id))
;

create sequence dance_style_seq;

create sequence language_seq;

create sequence teacher_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists dance_style;

drop table if exists language;

drop table if exists teacher;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists dance_style_seq;

drop sequence if exists language_seq;

drop sequence if exists teacher_seq;

