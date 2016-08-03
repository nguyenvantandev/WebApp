CREATE TABLE login_tbl
(
id integer NOT NULL CONSTRAINT login_pkey PRIMARY KEY, 
name character varying(40),
password character varying(16),
role character varying(1)
);

CREATE TABLE news_tbl
(
id integer NOT NULL CONSTRAINT news_pkey PRIMARY KEY,
title character varying(80),
japanese text,
vietnamese text,
insert_day timestamp without time zone
);

CREATE TABLE vocabulary_tbl
(
id integer NOT NULL CONSTRAINT vocabulary_pkey PRIMARY KEY,
word character varying(80),
hiragana character varying(80),
meaning character varying(100),
sort character varying(10),
example text,
level character varying(1)
);


CREATE TABLE grammar_tbl
(
id integer NOT NULL CONSTRAINT grammar_pkey PRIMARY KEY,
grammar character varying(80),
syntax character varying(100),
meaning character varying(100),
example text,
gra_comment text,
gra_note text,
gra_level character varying(1),
gra_group character varying(1)
);

CREATE TABLE test_tbl
(
id integer NOT NULL CONSTRAINT test_pkey PRIMARY KEY,
question text,
anwser_1 character varying(200),
anwser_2 character varying(200),
anwser_3 character varying(200),
anwser_4 character varying(200),
test_level character varying(1),
item character varying(10)
);
