package user;

import com.demoApp.grpc.User;
import com.demoApp.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");
        String username = request.getUsername();
        String password = request.getPassword();
        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if (!username.isEmpty() && !password.isEmpty()) {
            // success
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        } else {
            // failure
            response.setResponseCode(400).setResponseMessage("FAILURE");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside logout");
        responseObserver.onCompleted();
    }
}
