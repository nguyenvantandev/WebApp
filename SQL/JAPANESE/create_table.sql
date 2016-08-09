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
test_content text,
question text,
anwser_1 text,
anwser_2 text,
anwser_3 text,
anwser_4 text,
result_anwser character varying(1),
result_question text,
test_level character varying(1),
item character varying(10)
);



SELECT id, test_content, question, anwser_1, anwser_2, anwser_3, anwser_4, result_anwser, result_question FROM test_tbl 
WHERE test_level = '1' AND item = '言葉'
ORDER BY id ASC

SELECT role FROM login_tbl WHERE name = 'NTTN' AND password = '123'



