package com.fmbah.netty.nio25_28_imitate;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: imitate.proto")
public final class ImitategRpcGrpc {

  private ImitategRpcGrpc() {}

  public static final String SERVICE_NAME = "imitate.ImitategRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Preq,
      Pres> getP2pMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "p2p",
      requestType = Preq.class,
      responseType = Pres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Preq,
      Pres> getP2pMethod() {
    io.grpc.MethodDescriptor<Preq, Pres> getP2pMethod;
    if ((getP2pMethod = ImitategRpcGrpc.getP2pMethod) == null) {
      synchronized (ImitategRpcGrpc.class) {
        if ((getP2pMethod = ImitategRpcGrpc.getP2pMethod) == null) {
          ImitategRpcGrpc.getP2pMethod = getP2pMethod = 
              io.grpc.MethodDescriptor.<Preq, Pres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "imitate.ImitategRpc", "p2p"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Preq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Pres.getDefaultInstance()))
                  .setSchemaDescriptor(new ImitategRpcMethodDescriptorSupplier("p2p"))
                  .build();
          }
        }
     }
     return getP2pMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Preq,
      Pres> getP2sMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "p2s",
      requestType = Preq.class,
      responseType = Pres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Preq,
      Pres> getP2sMethod() {
    io.grpc.MethodDescriptor<Preq, Pres> getP2sMethod;
    if ((getP2sMethod = ImitategRpcGrpc.getP2sMethod) == null) {
      synchronized (ImitategRpcGrpc.class) {
        if ((getP2sMethod = ImitategRpcGrpc.getP2sMethod) == null) {
          ImitategRpcGrpc.getP2sMethod = getP2sMethod = 
              io.grpc.MethodDescriptor.<Preq, Pres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "imitate.ImitategRpc", "p2s"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Preq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Pres.getDefaultInstance()))
                  .setSchemaDescriptor(new ImitategRpcMethodDescriptorSupplier("p2s"))
                  .build();
          }
        }
     }
     return getP2sMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Preq,
      Pres> getS2pMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "s2p",
      requestType = Preq.class,
      responseType = Pres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<Preq,
      Pres> getS2pMethod() {
    io.grpc.MethodDescriptor<Preq, Pres> getS2pMethod;
    if ((getS2pMethod = ImitategRpcGrpc.getS2pMethod) == null) {
      synchronized (ImitategRpcGrpc.class) {
        if ((getS2pMethod = ImitategRpcGrpc.getS2pMethod) == null) {
          ImitategRpcGrpc.getS2pMethod = getS2pMethod = 
              io.grpc.MethodDescriptor.<Preq, Pres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "imitate.ImitategRpc", "s2p"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Preq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Pres.getDefaultInstance()))
                  .setSchemaDescriptor(new ImitategRpcMethodDescriptorSupplier("s2p"))
                  .build();
          }
        }
     }
     return getS2pMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Preq,
      Pres> getS2sMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "s2s",
      requestType = Preq.class,
      responseType = Pres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<Preq,
      Pres> getS2sMethod() {
    io.grpc.MethodDescriptor<Preq, Pres> getS2sMethod;
    if ((getS2sMethod = ImitategRpcGrpc.getS2sMethod) == null) {
      synchronized (ImitategRpcGrpc.class) {
        if ((getS2sMethod = ImitategRpcGrpc.getS2sMethod) == null) {
          ImitategRpcGrpc.getS2sMethod = getS2sMethod = 
              io.grpc.MethodDescriptor.<Preq, Pres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "imitate.ImitategRpc", "s2s"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Preq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Pres.getDefaultInstance()))
                  .setSchemaDescriptor(new ImitategRpcMethodDescriptorSupplier("s2s"))
                  .build();
          }
        }
     }
     return getS2sMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImitategRpcStub newStub(io.grpc.Channel channel) {
    return new ImitategRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImitategRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ImitategRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImitategRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ImitategRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class ImitategRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void p2p(Preq request,
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      asyncUnimplementedUnaryCall(getP2pMethod(), responseObserver);
    }

    /**
     */
    public void p2s(Preq request,
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      asyncUnimplementedUnaryCall(getP2sMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Preq> s2p(
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      return asyncUnimplementedStreamingCall(getS2pMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Preq> s2s(
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      return asyncUnimplementedStreamingCall(getS2sMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getP2pMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Preq,
                Pres>(
                  this, METHODID_P2P)))
          .addMethod(
            getP2sMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Preq,
                Pres>(
                  this, METHODID_P2S)))
          .addMethod(
            getS2pMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                Preq,
                Pres>(
                  this, METHODID_S2P)))
          .addMethod(
            getS2sMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                Preq,
                Pres>(
                  this, METHODID_S2S)))
          .build();
    }
  }

  /**
   */
  public static final class ImitategRpcStub extends io.grpc.stub.AbstractStub<ImitategRpcStub> {
    private ImitategRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImitategRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImitategRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImitategRpcStub(channel, callOptions);
    }

    /**
     */
    public void p2p(Preq request,
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getP2pMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void p2s(Preq request,
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getP2sMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Preq> s2p(
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getS2pMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Preq> s2s(
        io.grpc.stub.StreamObserver<Pres> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getS2sMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ImitategRpcBlockingStub extends io.grpc.stub.AbstractStub<ImitategRpcBlockingStub> {
    private ImitategRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImitategRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImitategRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImitategRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public Pres p2p(Preq request) {
      return blockingUnaryCall(
          getChannel(), getP2pMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Pres> p2s(
        Preq request) {
      return blockingServerStreamingCall(
          getChannel(), getP2sMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ImitategRpcFutureStub extends io.grpc.stub.AbstractStub<ImitategRpcFutureStub> {
    private ImitategRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImitategRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImitategRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImitategRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Pres> p2p(
        Preq request) {
      return futureUnaryCall(
          getChannel().newCall(getP2pMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_P2P = 0;
  private static final int METHODID_P2S = 1;
  private static final int METHODID_S2P = 2;
  private static final int METHODID_S2S = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImitategRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImitategRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_P2P:
          serviceImpl.p2p((Preq) request,
              (io.grpc.stub.StreamObserver<Pres>) responseObserver);
          break;
        case METHODID_P2S:
          serviceImpl.p2s((Preq) request,
              (io.grpc.stub.StreamObserver<Pres>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_S2P:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.s2p(
              (io.grpc.stub.StreamObserver<Pres>) responseObserver);
        case METHODID_S2S:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.s2s(
              (io.grpc.stub.StreamObserver<Pres>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ImitategRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImitategRpcBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Imitate.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImitategRpc");
    }
  }

  private static final class ImitategRpcFileDescriptorSupplier
      extends ImitategRpcBaseDescriptorSupplier {
    ImitategRpcFileDescriptorSupplier() {}
  }

  private static final class ImitategRpcMethodDescriptorSupplier
      extends ImitategRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImitategRpcMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ImitategRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImitategRpcFileDescriptorSupplier())
              .addMethod(getP2pMethod())
              .addMethod(getP2sMethod())
              .addMethod(getS2pMethod())
              .addMethod(getS2sMethod())
              .build();
        }
      }
    }
    return result;
  }
}
