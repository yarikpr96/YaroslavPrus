

CREATE TABLE bugs(id INT, open_date DATE, close_date DATE, severity CHAR);
INSERT INTO bugs VALUES(1,STR_TO_DATE('01/01/2012', '%m/%d/%Y'),STR_TO_DATE('02/01/2012', '%m/%d/%Y'),'H');
INSERT INTO bugs VALUES(2,STR_TO_DATE('02/01/2012', '%m/%d/%Y'),STR_TO_DATE('03/01/2012', '%m/%d/%Y'),'M');
INSERT INTO bugs VALUES(3,STR_TO_DATE('02/01/2012', '%m/%d/%Y'),STR_TO_DATE('03/01/2012', '%m/%d/%Y'),'M');
INSERT INTO bugs VALUES(4,STR_TO_DATE('04/01/2012', '%m/%d/%Y'),null,'L');
INSERT INTO bugs VALUES(5,STR_TO_DATE('06/01/2012', '%m/%d/%Y'),null,'L');


SELECT b.open_date,count(b.id) AS totalbugs FROM bugs b WHERE b.open_date BETWEEN '01/01/2012' AND curdate()
GROUP BY b.open_date
ORDER BY b.open_date