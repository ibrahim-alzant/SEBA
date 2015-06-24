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
  location                  varchar(255),
  location_code             varchar(255),
  participant_fee           float,
  picture_url               varchar(255),
  video_url                 varchar(255),
  constraint pk_course primary key (id))
;

create table dance_style (
  id                        bigint not null,
  dance_style_name          varchar(255),
  constraint uq_dance_style_dance_style_name unique (dance_style_name),
  constraint pk_dance_style primary key (id))
;

create table gender (
  id                        bigint not null,
  gender_name               varchar(255),
  constraint uq_gender_gender_name unique (gender_name),
  constraint pk_gender primary key (id))
;

create table language (
  id                        bigint not null,
  language_name             varchar(255),
  constraint uq_language_language_name unique (language_name),
  constraint pk_language primary key (id))
;

create table student (
  id                        bigint not null,
  first_name                varchar(255),
  gender_id                 bigint,
  last_name                 varchar(255),
  address                   varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  img_url                   varchar(255),
  additional_information    varchar(255),
  height                    integer,
  date_of_birth             timestamp,
  constraint uq_student_user_name unique (user_name),
  constraint uq_student_email unique (email),
  constraint pk_student primary key (id))
;

create table teacher (
  id                        bigint not null,
  first_name                varchar(255),
  gender_id                 bigint,
  last_name                 varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  mobile                    varchar(255),
  img_url                   varchar(255),
  professional_experience   varchar(255),
  date_of_birth             timestamp,
  constraint uq_teacher_user_name unique (user_name),
  constraint uq_teacher_email unique (email),
  constraint pk_teacher primary key (id))
;

create table time_slot (
  id                        bigint not null,
  day_of_the_week           varchar(255),
  time                      varchar(255),
  constraint pk_time_slot primary key (id))
;


create table course_student (
  course_id                      integer not null,
  student_id                     bigint not null,
  constraint pk_course_student primary key (course_id, student_id))
;

create table student_language (
  student_id                     bigint not null,
  language_id                    bigint not null,
  constraint pk_student_language primary key (student_id, language_id))
;

create table student_dance_style (
  student_id                     bigint not null,
  dance_style_id                 bigint not null,
  constraint pk_student_dance_style primary key (student_id, dance_style_id))
;

create table teacher_language (
  teacher_id                     bigint not null,
  language_id                    bigint not null,
  constraint pk_teacher_language primary key (teacher_id, language_id))
;

create table teacher_dance_style (
  teacher_id                     bigint not null,
  dance_style_id                 bigint not null,
  constraint pk_teacher_dance_style primary key (teacher_id, dance_style_id))
;
create sequence course_seq;

create sequence dance_style_seq;

create sequence gender_seq;

create sequence language_seq;

create sequence student_seq;

create sequence teacher_seq;

create sequence time_slot_seq;

alter table course add constraint fk_course_teacher_1 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;
create index ix_course_teacher_1 on course (teacher_id);
alter table course add constraint fk_course_language_2 foreign key (language_id) references language (id) on delete restrict on update restrict;
create index ix_course_language_2 on course (language_id);
alter table course add constraint fk_course_danceStyle_3 foreign key (dance_style_id) references dance_style (id) on delete restrict on update restrict;
create index ix_course_danceStyle_3 on course (dance_style_id);
alter table student add constraint fk_student_gender_4 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_student_gender_4 on student (gender_id);
alter table teacher add constraint fk_teacher_gender_5 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_teacher_gender_5 on teacher (gender_id);



alter table course_student add constraint fk_course_student_course_01 foreign key (course_id) references course (id) on delete restrict on update restrict;

alter table course_student add constraint fk_course_student_student_02 foreign key (student_id) references student (id) on delete restrict on update restrict;

alter table student_language add constraint fk_student_language_student_01 foreign key (student_id) references student (id) on delete restrict on update restrict;

alter table student_language add constraint fk_student_language_language_02 foreign key (language_id) references language (id) on delete restrict on update restrict;

alter table student_dance_style add constraint fk_student_dance_style_studen_01 foreign key (student_id) references student (id) on delete restrict on update restrict;

alter table student_dance_style add constraint fk_student_dance_style_dance__02 foreign key (dance_style_id) references dance_style (id) on delete restrict on update restrict;

alter table teacher_language add constraint fk_teacher_language_teacher_01 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;

alter table teacher_language add constraint fk_teacher_language_language_02 foreign key (language_id) references language (id) on delete restrict on update restrict;

alter table teacher_dance_style add constraint fk_teacher_dance_style_teache_01 foreign key (teacher_id) references teacher (id) on delete restrict on update restrict;

alter table teacher_dance_style add constraint fk_teacher_dance_style_dance__02 foreign key (dance_style_id) references dance_style (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists course;

drop table if exists course_student;

drop table if exists dance_style;

drop table if exists gender;

drop table if exists language;

drop table if exists student;

drop table if exists student_language;

drop table if exists student_dance_style;

drop table if exists teacher;

drop table if exists teacher_language;

drop table if exists teacher_dance_style;

drop table if exists time_slot;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists course_seq;

drop sequence if exists dance_style_seq;

drop sequence if exists gender_seq;

drop sequence if exists language_seq;

drop sequence if exists student_seq;

drop sequence if exists teacher_seq;

drop sequence if exists time_slot_seq;

