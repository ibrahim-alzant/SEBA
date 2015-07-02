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
VALUES (1000, 'Frank', 1, 'Mueller', 'Sabener Strasse 51-57, 81547 Munchen', 'frank','123', 'frank@gmail.com', '+4874562386',
 'https://lh5.googleusercontent.com/-ZadaXoUTBfs/AAAAAAAAAAI/AAAAAAAAAGA/19US52OmBqc/photo.jpg',
 'I have been taking salsa classes since 2013', 185, TIMESTAMP '1990-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (3000, 'Albert', 1, 'Volkov', ' Arcisstrasse 21, D-80333 Munich', 'albert_000','123', 'albert@gmail.com', '+487456686',
 'http://organicthemes.com/demo/profile/files/2012/12/profile_img.png',
 'Im just a beginner', 175, TIMESTAMP '1989-08-01 00:00:00.00');

  INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (4000, 'Aleksander', 1, 'Produn', 'Jochbergweg 7, 85748, Garcheng b. Muenchen ', 'alex','123', 'alex@gmail.com', '+487456686',
 'https://pbs.twimg.com/profile_images/1456072735/TwitterProfileSquare_sm.jpg',
 'Not a professional. Like dancing salsa on weekends', 183, TIMESTAMP '1991-08-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (5000, 'Anna', 2, 'Dallawer', 'Sabener Strasse 40, 81547 M�nchen', 'anna', '123', 'anna@gmail.com', '+4874562386',
 'http://www.google.com/+/images/learnmore/getstarted/feat-profile.png',
 'I like salsa', 165, TIMESTAMP '1992-09-01 00:00:00.00');

  INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (2000, 'Michaela', 2, 'Graedener', 'Theresienstra�e 54, 80333 Muenchen', 'michaela', '123', 'MichaelaEva@gmx.de', '+4917656551337',
 'https://lh3.googleusercontent.com/-t1J7FOyjBFM/AAAAAAAAAAI/AAAAAAAAADQ/SglVouQUOVA/photo.jpg ',
 'I am taking dance classes since I 9 years now, but actually just for fun, I have no ambition for any competitions. I like the dance partys at Neubeck-Ebel!', 182, TIMESTAMP '1992-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (6000, 'Julian', 1, 'Nast-Kolb', 'Leopoldstra�e 257, 80807 Muenchen', 'julian', '123', 'julijunk@nast-kolb.com', '+49898876543',
 'https://x1.xingassets.com/image/a_3_a_da13ffc44_17780556_3/julian-nast-kolb-foto.1024x1024.jpg',
 'Actually I only take dance classes because my girlfriend wants me to.... :/', 180, TIMESTAMP '1990-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (7000, 'Sylvia', 2, 'Krohn', 'Josefstrasse 1, 82041 Deisenhofen', 'sylvia', '123', 'ssylviee2@gmail.com', '+498948876543',
 'http://1.bp.blogspot.com/-sOqeRQEmCBY/UXjXkhpUpCI/AAAAAAAABq4/thh_NX40b2k/s1600/Woman-back-of-head.jpg',
 'Passionate about everything with music! So far I only took Standard courses, but I want to try something new! Contact me :) ', 170, TIMESTAMP '1958-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (8000, 'Angelika', 2, 'Rausch', 'Promenadepl. 2, 80333 Muenchen', 'angy', '123', 'angy-rausch@gmail.com', '+4989448876543',
 'http://www.extra-blatt.de/images/248810/248820/252168/254974/1016041/1127197/1127237/1130247_v1.jpg',
 'Sooo interested in this platform! Salsa is my passion, I hope to find many interesting classes here.', 176, TIMESTAMP '1975-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (9000, 'Richard', 1, 'Graedener', 'Graedenerstrasse 1 , 20257 Hamburg', 'richard', '123', 'richardgraedener@gmail.com', '+4989448876543',
 'http://data.onb.ac.at/nlv_lex/perslex/G/images/Graedener_Hermann.jpg',
 'The man on the picture is my grandgrandfather, not me haha... Just wanted to see if there are cool courses and/or partners around here... Check out my guitar lessons btw!', 190,
  TIMESTAMP '1950-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (10000, 'Ulrike', 2, 'Schaefer', 'Lipowskystra�e 3, 81373 Muenchen', 'ulli', '123', 'ulr.schlbeck@gmail.com', '+4994488743',
 'http://www.med.fs.tum.de/fileadmin/_processed_/csm_Ulrike_Schindlbeck__1.Studienjahr_OEZ_01_5bc5d98789.jpg',
 'Hope to meet new people here. I wanted to do some Bachata improvement.... anyone interested?', 162, TIMESTAMP '1987-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (11000, 'Victor', 1, 'Avramescu', 'Lipowskystra�e 3, 81373 Muenchen', 'victor', '123', 'vikiavramescumuc@gmail.com', '+49172394488743',
 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xft1/v/t1.0-1/p160x160/10991160_10205674493734214_1655783128023597736_n.jpg?oh=ddc7a96efb6ab272518a9f1cce3f2cfe&oe=561C2941&__gda__=1441345132_fbbb2a1d30ad72393dad87493754db66',
 'I am a professional, dancing in the Standard A League for several years now. I might register as a teacher but for now I am interested in the world of Latin...' , 179, TIMESTAMP '1985-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (12000, 'Carsten', 1, 'Steffen', 'Goetheweg 10, 85748 Garching', 'carsten', '123', 'casrsteff@gmail.com', '+4917394488743',
 'https://igcdn-photos-e-a.akamaihd.net/hphotos-ak-xaf1/t51.2885-19/11410540_1451294895167324_138541756_a.jpg',
 'Im a complete beginner but hope to find some classes in Garching (Tango anyone?)', 187, TIMESTAMP '1991-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (13000, 'Sophie', 2, 'Acker', 'Gr�nwalder Str. 22, 81547 Muenchen', 'sophie', '123', 'sphacker@gmail.com', '+49173943488743',
 'http://hairstyles.thehairstyler.com/hairstyle_views/left_view_images/4921/original/Nancy-Melarango--for-The-Brown-Aveda-Institute_-Mentor_-OH_003.jpg',
 'Dancing is my way to work out! I want to try Bachata, but also Tango and Reggeaton', 178, TIMESTAMP '1988-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (14000, 'Linda', 2, 'Sim', 'Schellingstrasse 33, 80333 Muenchen', 'lina', '123', 'lsmnoan@gmail.com', '+49173943488743',
 'http://www.castingshow-news.de/wp-content/uploads/2011/07/Linda-Teodosiu-e1311322322813.jpg',
 'I took some Salsa lessons in Cuba and want to improve my skills here in Munich!', 174, TIMESTAMP '1992-09-01 00:00:00.00');

 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (15000, 'Julia', 2, 'Bureckk', 'Prinzregentenstra�e 1, 80538 M�nchen', 'julia', '123', 'juliabreck1212@gmail.com', '+49173943488743',
 'https://c4.staticflickr.com/4/3062/2745853244_34a37df243_b.jpg',
 'Professional, looking for a partner (at least 190cm please!)', 183, TIMESTAMP '1995-09-01 00:00:00.00');


 INSERT INTO student (id, first_name, gender_id, last_name, address, user_name, password,
email, mobile, img_url, additional_information,  height, date_of_birth )
VALUES (16000, 'Simon', 1, 'Breme', 'Steinickeweg 7, 80798 Muenchen', 'simon', '123', 'simonbremer22312@gmail.com', '+491739434882343',
 'https://lh6.googleusercontent.com/-1XMVib3ISno/AAAAAAAAAAI/AAAAAAAAAFs/iEHirehXeOU/photo.jpg',
 'Want to try some Jive with me?', 186, TIMESTAMP '1988-09-01 00:00:00.00');


 INSERT INTO student_language (student_id, language_id ) VALUES (1000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (1000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (2000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (3000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (4000,1);

 INSERT INTO student_language (student_id, language_id ) VALUES (2000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (2000,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (2000,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (2000,8);
 INSERT INTO student_language (student_id, language_id ) VALUES (2000,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (3000,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (4000,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (4000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (5000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (6000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (6000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (6000,9);

 INSERT INTO student_language (student_id, language_id ) VALUES (7000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (7000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (7000,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (8000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (8000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (8000,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (9000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (12000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (12000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (10000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (10000,3);
 INSERT INTO student_language (student_id, language_id ) VALUES (10000,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (11000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (11000,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (13000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (13000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (13000,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (13000,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (13000,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (14000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (14000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (14000,4);
 INSERT INTO student_language (student_id, language_id ) VALUES (14000,6);
 INSERT INTO student_language (student_id, language_id ) VALUES (14000,7);
 INSERT INTO student_language (student_id, language_id ) VALUES (15000,1);
 INSERT INTO student_language (student_id, language_id ) VALUES (15000,2);
 INSERT INTO student_language (student_id, language_id ) VALUES (15000,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (16000,9);
 INSERT INTO student_language (student_id, language_id ) VALUES (16000,5);
 INSERT INTO student_language (student_id, language_id ) VALUES (16000,1);

 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (1000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (3000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (4000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (1000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (3000,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (2000,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (5000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (5000,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6000,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (6000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7000,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (7000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8000,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (8000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (9000,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (10000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (10000,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (11000,8);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (12000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (13000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (14000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,1);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,2);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,3);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,4);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,5);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (15000,6);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (16000,7);
 INSERT INTO student_dance_style (student_id, dance_style_id ) VALUES (16000,5);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (1000, 'Johannes', 1, 'Spogg','TeacherJohannes', '123', 'jspogg@gmail.com', '+491739434882343',
 'http://www.teachballroomdancing.com/wp-content/uploads/2013/08/9_GreatDanceTeacher.jpg',
 'Normaly working at Steuer Dance School. Try my courses here!', '1960-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (1000,1);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (1000,2);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (1000,7);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (1000,1);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (1000,3);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (1000,7);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (2000, 'Martin', 1, 'Zellner', 'TeacherMartin', '123', 'martiiiin@gmail.com', '+491739434882343',
 'http://www.milomiles.com/wp-content/uploads/2012/05/A1.jpg',
 'Passionate Salsa dancer. I have experience from all over the world!', '1970-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (2000,4);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (2000,2);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (2000,9);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (2000,2);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (2000,4);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (2000,8);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (3000, 'Felix', 1, 'Brauer', 'TeacherFelix', '123', 'felixbrauer@gmail.com', '+491739434882343',
 'http://www.universaldancecreations.com/images/samba-latin-dancers.jpg',
 'Want some hot dance classes? Try my courses... I will fulfill your wishes', '1980-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (3000,4);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (3000,3);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (3000,6);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (3000,4);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (3000,5);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (3000,6);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (4000, 'Thomas', 1, 'Kork', 'TeachingThomas', '123', 'Tommy12325@gmail.com', '+491739434882343',
 'http://www.universaldancecreations.com/images/samba-latin-dancers.jpg',
 'Want to know how to move your body? Come to my courses!' , '1985-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (4000,1);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (4000,6);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (4000,7);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (4000,6);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (4000,7);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (4000,8);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (5000, 'Anneliese', 2, 'Gola', 'TeacherAnny', '123', 'AnnelieseGgg@gmail.com', '+491739434882343',
 'http://ecx.images-amazon.com/images/I/41WonBsoO8L._SY445_.jpg',
 'Probably the best Tango dancer you can find in town :) Check out my courses!' , '1986-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (5000,1);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (5000,2);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (5000,3);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (5000,4);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (5000,2);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (5000,1);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (6000, 'Laura', 2, 'Wittner', 'TeacherLaura', '123', 'LauraW.2312@gmail.com', '+491739434882343',
 'https://s-media-cache-ak0.pinimg.com/236x/cb/57/fe/cb57fe80a8b81783bb6267dce5f01ad5.jpg',
 'Experienced teacher for many many years!' , '1976-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (6000,1);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (6000,5);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (6000,6);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (6000,1);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (6000,7);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (6000,5);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (7000, 'Marlin', 2, 'Wagner', 'TeacherMarlin', '123', 'MarlinTeacher@gmail.com', '+491739434882343',
 'http://g01.a.alicdn.com/kf/HTB1UKMJHFXXXXcUXVXXq6xXFXXXI/-font-b-Ballroom-b-font-O-neck-short-sleeve-modern-Latin-font-b-dance-b.jpg',
 'Dancing and teaching is my passion! LOVE this new opportunity! Elbailelatino rocks!!!' , '1981-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (7000,4);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (7000,2);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (7000,9);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (7000,3);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (7000,6);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (7000,1);

INSERT INTO teacher (id, first_name, gender_id, last_name, user_name, password, email, mobile, img_url, professional_experience, date_of_birth )
VALUES (8000, 'Myriam', 2, 'F.', 'TeacherMyriam', '123', 'MyriFeller@gmail.com', '+491739434882343',
 'https://s-media-cache-ak0.pinimg.com/736x/a9/4d/4c/a94d4c73e3e27fd642221e0bd73699ba.jpg',
 'Ever wondered how to dance a perfect Jive? I will tell you... No worries!' , '1986-09-01 00:00:00.00');

 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (8000,2);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (8000,4);
 INSERT INTO teacher_language (teacher_id, language_id ) VALUES (8000,5);

 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (8000,2);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (8000,4);
 INSERT INTO teacher_dance_style (teacher_id, dance_style_id ) VALUES (8000,8);


 INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (1000, 1000,'Salsa for everyone', '2015-09-01 15:00:00.00', 8, 0, 20, 1, 1, 'Open for everyone! Well do the basics', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 100, 'http://www.salsa-libre.eu/salsalibre/wp-content/uploads/2013/01/Salsa-libre-banner-3.jpg', '' );


 INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (000, 2000,'Die Tangostunden deines Lebens!', '2015-07-30 12:00:00.00', 10, 0, 24, 2, 2, 'Fortgeschritten, aber Hauptsache motiviert! Yeah!', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 120, 'http://www.tango-buenos-aires.com.ar/wp-content/gallery/gallery/e9fc1f15-9f4b-0141-25b7-c40731371ae4.jpg', '' );


 INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (3000, 3000,'Sexy Samba!', '2015-07-30 13:00:00.00', 10, 0, 24, 1, 3, 'Learn all the samba steps you need to impress!', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 90, 'http://www.tango-buenos-aires.com.ar/wp-content/gallery/gallery/e9fc1f15-9f4b-0141-25b7-c40731371ae4.jpg', '' );

 INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (4000, 4000,'Bachata - Beginners', '2015-07-30 13:00:00.00', 15, 0, 30, 1, 4, 'Never heard of it? No problem!', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 150, 'http://photos3.meetupstatic.com/photos/event/9/3/3/c/event_129037692.jpeg', '' );

 INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (5000, 5000,'Danza - Move your body!', '2015-08-30 13:00:00.00', 10, 0, 30, 1, 4, 'basic - just feel the rhythm and youll have fun', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 150, 'http://misleibyblug.zumba.com/zumba-class-0911-004.jpg', '' );

  INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (6000, 5000,'Groovy Reggeaton', '2015-08-30 13:00:00.00', 10, 0, 30, 1, 4, 'Everyone!', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 150, 'http://www.timba.com/blog_files/0000/0957/TripsToCuba12.jpg', '' );

  INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (7000, 7000,'Jive Professional', '2015-08-30 13:00:00.00', 15, 0, 10, 1, 4, 'Only professionals please!', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 300, 'http://www.dancesportindia.com/wp-content/uploads/2012/03/JIV.jpg', '' );

  INSERT INTO course (id, teacher_id, title, start_date, number_of_classes, number_of_participants, max_number_of_participants, language_id, dance_style_id, dance_level,
 status, location, location_code, participant_fee, picture_url, video_url)
 VALUES (8000, 8000,'Rumba f�r Anfaenger', '2015-08-30 13:00:00.00', 10, 0, 30, 1, 4, 'Anfaenger', 'open', 'Turnhalle 1, Olympiazentrum',
  '48.263418850644165,11.66921496347640', 150, 'http://www.kandsmusic.net/_Media/img_3445_med.jpeg', '' );



# --- !Downs
DELETE FROM student_language;
DELETE FROM student_dance_style;
DELETE FROM student;
DELETE FROM language;
DELETE FROM gender;
DELETE FROM dance_style;
