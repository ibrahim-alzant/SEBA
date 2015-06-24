# --- !Ups
INSERT INTO language (language_name, id) VALUES ('English', 1);
INSERT INTO language (language_name, id) VALUES ('German', 2);
INSERT INTO language (language_name, id) VALUES ('Arabic', 3);
INSERT INTO language (language_name, id) VALUES ('Russian', 4);
INSERT INTO language (language_name, id) VALUES ('French', 5);

INSERT INTO gender (gender_name,id) VALUES ('Male',1);
INSERT INTO gender (gender_name,id) VALUES ('Female', 2);

INSERT INTO dance_style (dance_style_name, id) VALUES ('Salsa', 1);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Tango', 2);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Samba', 3);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Bachata',4);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Danza', 5);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Reggaeton', 6);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Jive', 7);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Rumba', 8);



INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (1, 'Frank', 1, 'Mueller', 'Sabener Strasse 51-57, 81547 Munchen', 'frank','123', 'frank@gmail.com', '+4874562386',
 'https://lh5.googleusercontent.com/-ZadaXoUTBfs/AAAAAAAAAAI/AAAAAAAAAGA/19US52OmBqc/photo.jpg',
 'I have been taking salsa classes since 2013', 185, TIMESTAMP '1990-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (3, 'Albert', 1, 'Volkov', ' Arcisstrasse 21, D-80333 Munich', 'albert_000','123', 'albert@gmail.com', '+487456686',
 'http://organicthemes.com/demo/profile/files/2012/12/profile_img.png',
 'Im just a beginner', 175, TIMESTAMP '1989-08-01 00:00:00.00');

  INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (4, 'Aleksander', 1, 'Produn', 'Jochbergweg 7, 85748, Garcheng b. Muenchen ', 'alex','123', 'alex@gmail.com', '+487456686',
 'https://pbs.twimg.com/profile_images/1456072735/TwitterProfileSquare_sm.jpg',
 'Not a professional. Like dancing salsa on weekends', 183, TIMESTAMP '1991-08-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (2, 'Anna', 2, 'Dallawer', 'Sabener Strasse 40, 81547 Munchen', 'anna', '123', 'anna@gmail.com', '+4874562386',
 'http://www.google.com/+/images/learnmore/getstarted/feat-profile.png',
 'I like salsa', 165, TIMESTAMP '1992-09-01 00:00:00.00');

 INSERT INTO student_language (student_id, language_id ) VALUES (1,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (1,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (3,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (4,1);

 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (1,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (3,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (4,1);

# --- !Downs
DELETE FROM student_language;
DELETE FROM student_dance_style;
DELETE FROM student;
DELETE FROM language;
DELETE FROM gender;
DELETE FROM dance_style;
