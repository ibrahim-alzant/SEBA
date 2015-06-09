# --- !Ups
INSERT INTO language (language_name, id) VALUES ('Englich', language_seq.nextval);
INSERT INTO language (language_name, id) VALUES ('German', language_seq.nextval);
INSERT INTO language (language_name, id) VALUES ('Arabic', language_seq.nextval);
INSERT INTO language (language_name, id) VALUES ('Russian', language_seq.nextval);

INSERT INTO gender (gender_name,id) VALUES ('Male', gender_seq.nextval);
INSERT INTO gender (gender_name,id) VALUES ('Female', gender_seq.nextval);

INSERT INTO dance_style (dance_style_name, id) VALUES ('Tango', dance_style_seq.nextval);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Samba', dance_style_seq.nextval);
INSERT INTO dance_style (dance_style_name, id) VALUES ('Salsa', dance_style_seq.nextval);

# --- !Downs
DELETE FROM language;
DELETE FROM gender;
DELETE FROM dance_style;