package com.example.queenabergen.banyc.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.queenabergen.banyc.NaviActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

import static com.facebook.AccessToken.getCurrentAccessToken;

/**
 * Created by Hyun on 2/5/17.
 */

public class FacebookLoginActivity extends AppCompatActivity {

    private AccessToken accessToken;
    private AccessTokenTracker accessTokenTracker;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
//                accessToken = currentAccessToken;
//                setCurrentAccessToken(accessToken);
//                LoginManager.getInstance().logInWithReadPermissions(
//                        FacebookLoginActivity.this,
//                        Arrays.asList("email"));
            }
        };
        // If the access token is available already assign it.
        accessToken = getCurrentAccessToken();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(this,NaviActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }
}
