const mongoose = require('mongoose');
const TrueFalseSchema = mongoose.Schema({
    isTrue: Boolean,
});
module.exports = TrueFalseSchema;