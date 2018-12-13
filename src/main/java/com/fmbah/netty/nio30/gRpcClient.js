var PROTO_FILE_PATH="/root/IdeaProjects/distributed/netty_lecture/src/main/proto/Student.proto";
var grpc = require('grpc');
var grpcService = grpc.load(PROTO_FILE_PATH).com.fmbah.netty.nio24;

var client = new grpcService.StudentService('localhost:8099', grpc.credentials.createInsecure());

client.GetRealNameByUsername({'username':'lisi'}, function(error, respData) {
    console.log(respData);
})