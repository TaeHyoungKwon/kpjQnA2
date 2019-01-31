INSERT INTO USER (ID, USER_ID, USER_PASSWORD, USER_NAME, USER_EMAIL) VALUES (1, 'kth5604', '12345', '권태형', 'kwon5604@naver.com');
INSERT INTO USER (ID, USER_ID, USER_PASSWORD, USER_NAME, USER_EMAIL) VALUES (2, 'kwon5604', '12345', '이태형', 'kth5604@naver.com');

INSERT INTO QUESTION (id, writer_id, title, contents, create_date, count_of_answer) VALUES (1, 1, '12345', 'asdfasdfasdfasf', CURRENT_TIMESTAMP(),0);
INSERT INTO QUESTION (id, writer_id, title, contents, create_date, count_of_answer) VALUES (2, 2, '1234123412341234', '1234123412341234', CURRENT_TIMESTAMP(),0);