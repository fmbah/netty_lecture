var PROTO_FILE_PATH="/root/IdeaProjects/distributed/netty_lecture/src/main/proto/Student.proto";
var grpc = require('grpc');
var grpcService = grpc.load(PROTO_FILE_PATH).com.fmbah.netty.nio24;

var server = new grpc.Server();

server.addService(grpcService.StudentService.service, {
    getRealNameByUsername: getRealNameByUsername,
    getStudentsByAge: getStudentsByAge,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk: biTalk
})

server.bind('localhost:8099', grpc.ServerCredentials.createInsecure());

server.start();

function getRealNameByUsername(call, callback) {
    console.log("call: " + call.request.username);
    callback(null, {realname: 'zhangsan'});
}

function getStudentsByAge() {

}
function getStudentsWrapperByAges() {

}
function biTalk() {

}