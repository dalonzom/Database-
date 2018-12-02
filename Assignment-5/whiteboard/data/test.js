require('./db')();
var universityDao = require('./daos/university.dao.server');


//universityDao.findAnswersByStudent(234).then(newAnswers=>console.log(newAnswers8))


universityDao.truncateDatabase().then(answer =>
    universityDao.populateDatabase()).then(newAnswer =>
        universityDao.testStudentsInitialCount().then(newStudents => console.log("Initial Students " + newStudents),
         universityDao.testQuestionsInitialCount().then(newQuestions => console.log("Initial Questions " + newQuestions),
            universityDao.testAnswersInitialCount().then(newAnswers => console.log("Initial Answers " + newAnswers))),
            universityDao.testDeleteAnswer().then(newNumbers=> universityDao.testDeleteQuestion().then(newQuestions=>
            universityDao.testDeleteStudent()))));



