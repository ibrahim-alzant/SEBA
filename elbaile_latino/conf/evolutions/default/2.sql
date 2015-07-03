# --- !Ups
INSERT INTO language (language_name, id) VALUES ('English', 1);
INSERT INTO language (language_name, id) VALUES ('German', 2);
INSERT INTO language (language_name, id) VALUES ('Arabic', 3);
INSERT INTO language (language_name, id) VALUES ('Russian', 4);
INSERT INTO language (language_name, id) VALUES ('French', 5);
INSERT INTO language (language_name, id) VALUES ('Bavarian', 6);
INSERT INTO language (language_name, id) VALUES ('Polish', 7);
INSERT INTO language (language_name, id) VALUES ('Korean', 8);
INSERT INTO language (language_name, id) VALUES ('Spanish', 9);

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
VALUES (5, 'Anna', 2, 'Dallawer', 'Sabener Strasse 40, 81547 München', 'anna', '123', 'anna@gmail.com', '+4874562386',
 'http://www.google.com/+/images/learnmore/getstarted/feat-profile.png',
 'I like salsa', 165, TIMESTAMP '1992-09-01 00:00:00.00');

  INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (2, 'Michaela', 2, 'Graedener', 'Theresienstraße 54, 80333 Muenchen', 'michaela', '123', 'MichaelaEva@gmx.de', '+4917656551337',
 'https://lh3.googleusercontent.com/-t1J7FOyjBFM/AAAAAAAAAAI/AAAAAAAAADQ/SglVouQUOVA/photo.jpg ',
 'I am taking dance classes since I 9 years now, but actually just for fun, I have no ambition for any competitions. I like the dance partys at Neubeck-Ebel!', 182, TIMESTAMP '1992-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (6, 'Julian', 1, 'Nast-Kolb', 'Leopoldstraße 257, 80807 Muenchen', 'julian', '123', 'julijunk@nast-kolb.com', '+49898876543',
 'https://x1.xingassets.com/image/a_3_a_da13ffc44_17780556_3/julian-nast-kolb-foto.1024x1024.jpg',
 'Actually I only take dance classes because my girlfriend wants me to.... :/', 180, TIMESTAMP '1990-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (7, 'Sylvia', 2, 'Krohn', 'Josefstrasse 1, 82041 Deisenhofen', 'sylvia', '123', 'ssylviee2@gmail.com', '+498948876543',
 'http://1.bp.blogspot.com/-sOqeRQEmCBY/UXjXkhpUpCI/AAAAAAAABq4/thh_NX40b2k/s1600/Woman-back-of-head.jpg',
 'Passionate about everything with music! So far I only took Standard courses, but I want to try something new! Contact me :) ', 170, TIMESTAMP '1958-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (8, 'Angelika', 2, 'Rausch', 'Promenadepl. 2, 80333 Muenchen', 'angy', '123', 'angy-rausch@gmail.com', '+4989448876543',
 'http://www.extra-blatt.de/images/248810/248820/252168/254974/1016041/1127197/1127237/1130247_v1.jpg',
 'Sooo interested in this platform! Salsa is my passion, I hope to find many interesting classes here.', 176, TIMESTAMP '1975-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (9, 'Richard', 1, 'Graedener', 'Graedenerstrasse 1 , 20257 Hamburg', 'richard', '123', 'richardgraedener@gmail.com', '+4989448876543',
 'http://data.onb.ac.at/nlv_lex/perslex/G/images/Graedener_Hermann.jpg',
 'The man on the picture is my grandgrandfather, not me haha... Just wanted to see if there are cool courses and/or partners around here... Check out my guitar lessons btw!', 190,
  TIMESTAMP '1950-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (10, 'Ulrike', 2, 'Schaefer', 'Lipowskystraße 3, 81373 Muenchen', 'ulli', '123', 'ulr.schlbeck@gmail.com', '+4994488743',
 'http://www.med.fs.tum.de/fileadmin/_processed_/csm_Ulrike_Schindlbeck__1.Studienjahr_OEZ_01_5bc5d98789.jpg',
 'Hope to meet new people here. I wanted to do some Bachata improvement.... anyone interested?', 162, TIMESTAMP '1987-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (11, 'Victor', 1, 'Avramescu', 'Lipowskystraße 3, 81373 Muenchen', 'victor', '123', 'vikiavramescumuc@gmail.com', '+49172394488743',
 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xft1/v/t1.0-1/p160x160/10991160_10205674493734214_1655783128023597736_n.jpg?oh=ddc7a96efb6ab272518a9f1cce3f2cfe&oe=561C2941&__gda__=1441345132_fbbb2a1d30ad72393dad87493754db66',
 'I am a professional, dancing in the Standard A League for several years now. I might register as a teacher but for now I am interested in the world of Latin...' , 179, TIMESTAMP '1985-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (12, 'Carsten', 1, 'Steffen', 'Goetheweg 10, 85748 Garching', 'carsten', '123', 'casrsteff@gmail.com', '+4917394488743',
 'https://igcdn-photos-e-a.akamaihd.net/hphotos-ak-xaf1/t51.2885-19/11410540_1451294895167324_138541756_a.jpg',
 'Im a complete beginner but hope to find some classes in Garching (Tango anyone?)', 187, TIMESTAMP '1991-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (13, 'Sophie', 2, 'Acker', 'Grünwalder Str. 22, 81547 Muenchen', 'sophie', '123', 'sphacker@gmail.com', '+49173943488743',
 'http://hairstyles.thehairstyler.com/hairstyle_views/left_view_images/4921/original/Nancy-Melarango--for-The-Brown-Aveda-Institute_-Mentor_-OH_003.jpg',
 'Dancing is my way to work out! I want to try Bachata, but also Tango and Reggeaton', 178, TIMESTAMP '1988-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (14, 'Linda', 2, 'Sim', 'Schellingstrasse 33, 80333 Muenchen', 'lina', '123', 'lsmnoan@gmail.com', '+49173943488743',
 'http://www.castingshow-news.de/wp-content/uploads/2011/07/Linda-Teodosiu-e1311322322813.jpg',
 'I took some Salsa lessons in Cuba and want to improve my skills here in Munich!', 174, TIMESTAMP '1992-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (15, 'Julia', 2, 'Bureckk', 'Prinzregentenstraße 1, 80538 München', 'julia', '123', 'juliabreck1212@gmail.com', '+49173943488743',
 'https://c4.staticflickr.com/4/3062/2745853244_34a37df243_b.jpg',
 'Professional, looking for a partner (at least 190cm please!)', 183, TIMESTAMP '1995-09-01 00:00:00.00');


 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (16, 'Simon', 1, 'Breme', 'Steinickeweg 7, 80798 Muenchen', 'simon', '123', 'simonbremer22312@gmail.com', '+491739434882343',
 'https://lh6.googleusercontent.com/-1XMVib3ISno/AAAAAAAAAAI/AAAAAAAAAFs/iEHirehXeOU/photo.jpg',
 'Want to try some Jive with me?', 186, TIMESTAMP '1988-09-01 00:00:00.00');


 INSERT INTO student_language (student_id, language_id ) VALUES (1,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (1,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (3,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (4,1);

 INSERT INTO student_language (student_id, language_id ) VALUES (2,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,8);
 INSERT INTO student_language (student_id, language_id ) VALUES (2,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (3,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (4,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (4,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (5,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (6,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (6,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (6,9);

 INSERT INTO student_language (student_id, language_id ) VALUES (7,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (7,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (7,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (8,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (8,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (8,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (9,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (12,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (12,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (10,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (10,3);
 INSERT INTO student_language (student_id, language_id ) VALUES (10,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (11,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (11,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (13,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (13,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (13,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (13,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (13,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (14,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (14,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (14,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (14,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (14,7);
 INSERT INTO student_language (student_id, language_id ) VALUES (15,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (15,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (15,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (16,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (16,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (16,1);

 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (1,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (3,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (4,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (1,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (3,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (5,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (5,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (9,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (10,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (10,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (12,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (14,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (16,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (16,5);

# --- !Downs
DELETE FROM student_language;
DELETE FROM student_dance_style;
DELETE FROM student;
DELETE FROM language;
DELETE FROM gender;
DELETE FROM dance_style;
DELETE FROM teacher_dance_style;
DELETE FROM teacher;
DELETE FROM course;
DELETE FROM teacher_language;
