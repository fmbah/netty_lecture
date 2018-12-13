var messages = require('/root/IdeaProjects/distributed/netty_lecture/src/main/java/com/fmbah/netty/nio31/src/main/proto/Student_pb.js');
var services = require('/root/IdeaProjects/distributed/netty_lecture/src/main/java/com/fmbah/netty/nio31/src/main/proto/Student_grpc_pb.js');

var grpc = require('grpc')

function main() {
    var client = new services.StudentServiceClient('localhost:8099', grpc.credentials.createInsecure());
    var request = new messages.MyRequest();

    request.setUsername('lisi');
    client.getRealNameByUsername(request, function(err, resData) {
        console.log('getRealNameByUsername: ', resData.getRealname())
    });
}

main();