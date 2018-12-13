// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var src_main_proto_Student_pb = require('../../../src/main/proto/Student_pb.js');

function serialize_com_fmbah_netty_nio24_MyRequest(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.MyRequest)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.MyRequest');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_MyRequest(buffer_arg) {
  return src_main_proto_Student_pb.MyRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_MyResponse(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.MyResponse)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.MyResponse');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_MyResponse(buffer_arg) {
  return src_main_proto_Student_pb.MyResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_StreamRequest(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.StreamRequest)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.StreamRequest');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_StreamRequest(buffer_arg) {
  return src_main_proto_Student_pb.StreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_StreamResponse(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.StreamResponse)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.StreamResponse');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_StreamResponse(buffer_arg) {
  return src_main_proto_Student_pb.StreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_StudentRequest(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.StudentRequest)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.StudentRequest');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_StudentRequest(buffer_arg) {
  return src_main_proto_Student_pb.StudentRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_StudentResponse(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.StudentResponse)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.StudentResponse');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_StudentResponse(buffer_arg) {
  return src_main_proto_Student_pb.StudentResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_fmbah_netty_nio24_StudentResponseList(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.StudentResponseList)) {
    throw new Error('Expected argument of type com.fmbah.netty.nio24.StudentResponseList');
  }
  return new Buffer(arg.serializeBinary());
}

function deserialize_com_fmbah_netty_nio24_StudentResponseList(buffer_arg) {
  return src_main_proto_Student_pb.StudentResponseList.deserializeBinary(new Uint8Array(buffer_arg));
}


var StudentServiceService = exports.StudentServiceService = {
  getRealNameByUsername: {
    path: '/com.fmbah.netty.nio24.StudentService/GetRealNameByUsername',
    requestStream: false,
    responseStream: false,
    requestType: src_main_proto_Student_pb.MyRequest,
    responseType: src_main_proto_Student_pb.MyResponse,
    requestSerialize: serialize_com_fmbah_netty_nio24_MyRequest,
    requestDeserialize: deserialize_com_fmbah_netty_nio24_MyRequest,
    responseSerialize: serialize_com_fmbah_netty_nio24_MyResponse,
    responseDeserialize: deserialize_com_fmbah_netty_nio24_MyResponse,
  },
  getStudentsByAge: {
    path: '/com.fmbah.netty.nio24.StudentService/GetStudentsByAge',
    requestStream: false,
    responseStream: true,
    requestType: src_main_proto_Student_pb.StudentRequest,
    responseType: src_main_proto_Student_pb.StudentResponse,
    requestSerialize: serialize_com_fmbah_netty_nio24_StudentRequest,
    requestDeserialize: deserialize_com_fmbah_netty_nio24_StudentRequest,
    responseSerialize: serialize_com_fmbah_netty_nio24_StudentResponse,
    responseDeserialize: deserialize_com_fmbah_netty_nio24_StudentResponse,
  },
  getStudentsWrapperByAges: {
    path: '/com.fmbah.netty.nio24.StudentService/GetStudentsWrapperByAges',
    requestStream: true,
    responseStream: false,
    requestType: src_main_proto_Student_pb.StudentRequest,
    responseType: src_main_proto_Student_pb.StudentResponseList,
    requestSerialize: serialize_com_fmbah_netty_nio24_StudentRequest,
    requestDeserialize: deserialize_com_fmbah_netty_nio24_StudentRequest,
    responseSerialize: serialize_com_fmbah_netty_nio24_StudentResponseList,
    responseDeserialize: deserialize_com_fmbah_netty_nio24_StudentResponseList,
  },
  biTalk: {
    path: '/com.fmbah.netty.nio24.StudentService/BiTalk',
    requestStream: true,
    responseStream: true,
    requestType: src_main_proto_Student_pb.StreamRequest,
    responseType: src_main_proto_Student_pb.StreamResponse,
    requestSerialize: serialize_com_fmbah_netty_nio24_StreamRequest,
    requestDeserialize: deserialize_com_fmbah_netty_nio24_StreamRequest,
    responseSerialize: serialize_com_fmbah_netty_nio24_StreamResponse,
    responseDeserialize: deserialize_com_fmbah_netty_nio24_StreamResponse,
  },
};

exports.StudentServiceClient = grpc.makeGenericClientConstructor(StudentServiceService);
