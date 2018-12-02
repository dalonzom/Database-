const mongoose = require('mongoose');
const StudentSchema = mongoose.Schema({
    _id: Number,
    firstName: String,
    lastName: String,
    username: String,
    password: String,
    gradYear: Number,
    scholarship: Number,
    }, {collection: 'student'}
);
module.exports = StudentSchema;