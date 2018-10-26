CREATE DEFINER=`dalonzom`@`%` PROCEDURE `endorsedUsersForWeek`(IN date1 DATE, IN date2 DATE)
BEGIN
SELECT  a.posted_by_id, p.firstname, p.lastname, SUM(a.correct_answer)
FROM answer a
JOIN question q ON q.id = a.question_id
JOIN person p ON p.id = a.posted_by_id
WHERE q.posted_on < date1 AND q.posted_on > date2 
GROUP BY posted_by_id
HAVING SUM(a.correct_answer) >  0
ORDER BY p.firstname
LIMIT 5;
END