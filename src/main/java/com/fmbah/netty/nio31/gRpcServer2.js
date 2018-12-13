var messages = require('/root/IdeaProjects/distributed/netty_lecture/src/main/java/com/fmbah/netty/nio31/src/main/proto/Student_pb.js');
var services = require('/root/IdeaProjects/distributed/netty_lecture/src/main/java/com/fmbah/netty/nio31/src/main/proto/Student_grpc_pb.js');

var grpc = require('grpc')

function main () {
    var server = new grpc.Server();
    server.addService(services.StudentServiceService, {
        getRealNameByUsername: getRealNameByUsername,
        getStudentsByAge: getStudentsByAge,
        getStudentsWrapperByAges: getStudentsWrapperByAges,
        biTalk: biTalk
    });
    server.bind('localhost:8099', grpc.ServerCredentials.createInsecure());
    server.start();
}

function getRealNameByUsername(call, callback) {
    console.log("call: " + call.request.getUsername());

    var reply = new messages.MyResponse();
    reply.setRealname('lll')
    callback(null, reply);
}
function getStudentsByAge() {

}
function getStudentsWrapperByAges() {

}
function biTalk() {

}

main();