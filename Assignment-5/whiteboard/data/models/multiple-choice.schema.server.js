const mongoose = require('mongoose');
const MultipleChoiceSchema = mongoose.Schema({
    choices: String,
    correct: Number,
});
module.exports = MultipleChoiceSchema;