package com.dorvis.quizapp.fcm;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
public class TokenService extends FirebaseInstanceIdService {
    private static final String TAG ="TokenService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.w("notification", refreshedToken);
        sendRegistrationToServer(refreshedToken);

       // Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    private void sendRegistrationToServer(String token) {
    }
}
