CREATE DEFINER=`dalonzom`@`%` PROCEDURE `getUnansweredQuestions`()
BEGIN


CREATE TABLE `temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(45) DEFAULT NULL,
  `num_incorrect` int(11) DEFAULT NULL,
  `module` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


INSERT INTO temp (question_text, num_incorrect, module) 
SELECT q.text,  COUNT(a.correct_answer) , q. module FROM answer a 
JOIN question q ON a.question_id = q.id
GROUP BY a.question_id
HAVING SUM(a.correct_answer) = 0; 



SELECT question_text AS 'Question', num_incorrect AS 'Number of Answers', module AS 'Module' FROM temp 
GROUP BY module 
HAVING MAX(num_incorrect);


DROP TABLE temp; 





END