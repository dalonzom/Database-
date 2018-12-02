const studentModel = require('../models/student.model.server')
const questionModel = require('../models/question.model.server')
const answerModel = require('../models/answer.model.server')

createStudent = student =>
    studentModel.create(student)
findAllStudents = () => studentModel.find()
findStudentById = studentId => studentModel.findById(studentId)
updateStudent = (studentId, student) => studentModel.update({_id: studentId}, {$set: student})
deleteStudent = studentId => studentModel.remove({_id: studentId})

createQuestion = question =>
    questionModel.create(question)
deleteQuestion = questionId => questionModel.remove({_id: questionId})
findAllQuestions = () => questionModel.find()
findQuestionById = questionId => questionModel.findById(questionId)



createAnswer = answer =>
    answerModel.create(answer)
deleteAnswer = answerId => answerModel.remove({_id: answerId})
findAllAnswers = () => answerModel.find()
findAnswerById = answerId => answerModel.findById(answerId)
findAnswersByStudent = studentId =>answerModel.find({student: studentId})
findAnswersByQuestion = questionId =>answerModel.find({question: questionId})


truncateDatabase = () => answerModel.deleteMany({}).then(status =>questionModel.deleteMany({})).then(status=>studentModel.deleteMany({}))
testStudentsInitialCount = () => findAllStudents().count({})
testQuestionsInitialCount = () => findAllQuestions().count({})
testAnswersInitialCount = () => findAllAnswers().count({})
testDeleteAnswer = () => deleteAnswer(890)
    .then(newAnswer=>findAllAnswers().count({})
        .then(newAnswer => console.log(
            "Deleting Answer, New Number of Total Answers " + newAnswer),
            findAnswersByStudent(234).count({})
                .then(newNumber =>
                     console.log("New Number of Bob's answers " + newNumber))));
testDeleteQuestion = () => deleteQuestion(321)
    .then(newQuestion=>findAllQuestions().count({})
        .then(newCount => console.log("Deleting Question, New Number of Questions " + newCount)));
testDeleteStudent = () => deleteStudent(234)
    .then(newStudent =>findAllStudents().count()
        .then(newCount => console.log("Deleting Student, New Number of Students " + newCount)));
populateDatabase = () => createStudent(
    {
        '_id': 123,
        'username': 'alice',
        'password': 'alice',
        'firstName': 'Alice',
        'lastName': 'Wonderland',
        'gradYear': 2020,
        'scholarship': 15000,
    }
).then(newStudent =>
    createStudent(
        {
            '_id': 234,
            'username': 'bob',
            'password': 'bob',
            'firstName': 'Bob',
            'lastName': 'Hope',
            'gradYear': 2021,
            'scholarship': 12000,
        }
    ).then(newStudent =>
        createQuestion(
            {
                '_id': 321,
                'question': 'Is the following schema valid?',
                'points': 10,
                'questionType': 'TRUE_FALSE',
                'trueFalse': {'isTrue': false},
            }
        ).then(newQuestion =>
            createQuestion(
                {
                    '_id': 432,
                    'question': 'DAO stands for Dynamic Access Object?',
                    'points': 10,
                    'questionType': 'TRUE_FALSE',
                    'trueFalse': {'isTrue' : false},
                }
            ).then(newQuestion =>
                createQuestion(
                    {
                        '_id': 543,
                        'question': 'What does JPA stand for?',
                        'points': 10,
                        'questionType': 'MULTIPLE_CHOICE',
                        'multipleChoice:': {'choices': 'Java Persistence API,Java Persisted Application,' +
                                'JavaScript Persistence API,JSON Persistent Associations',
                            'correct': 1},
                    }
                ).then(newQuestion =>
                createQuestion(
                    {
                        '_id': 654,
                        'question': 'What does ORM stand for?',
                        'points': 10,
                        'questionType': 'MULTIPLE_CHOICE',
                        'multipleChoice': {'choices': 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
                            'correct': 4},
                    }
                ).then(newQuestion =>
                    createAnswer(
                        {
                            '_id': 123,
                            'trueFalseAnswer': true,
                            'student': 123,
                            'question': 321,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 234,
                            'trueFalseAnswer': false,
                            'student': 123,
                            'question': 432,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 345,
                            'multipleChoiceAnswer': 1,
                            'student': 123,
                            'question': 543,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 456,
                            'multipleChoiceAnswer': 2,
                            'student': 123,
                            'question': 654,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 567,
                            'trueFalseAnswer': false,
                            'student': 234,
                            'question': 321,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 678,
                            'trueFalseAnswer': true,
                            'student': 234,
                            'question': 432,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 789,
                            'multipleChoiceAnswer': 3,
                            'student': 234,
                            'question': 543,
                        }
                    ).then(newAnswer => createAnswer(
                        {
                            '_id': 890,
                            'multipleChoiceAnswer': 4,
                            'student': 234,
                            'question': 654,
                        }
                    ).then(newAnswer => console.log("done")))))))))))))));


module.exports = {
    createStudent, findAllStudents, findStudentById, updateStudent, deleteStudent, createQuestion, truncateDatabase,
    findAllQuestions,  findQuestionById, findAnswerById, findAnswersByStudent,
    findAnswersByQuestion, deleteQuestion, deleteAnswer, findAllAnswers, createAnswer, populateDatabase,
    testStudentsInitialCount, testAnswersInitialCount, testQuestionsInitialCount, testDeleteAnswer, testDeleteQuestion,
    testDeleteStudent}