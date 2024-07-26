package com.example.mydseapp;

import static android.util.Log.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager; // declare the var as a global var
    private LoginButton loginButton;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login_button); //linked the login button
        textView = findViewById(R.id.tv_name);
        imageView = findViewById(R.id.iv_profilPic);

        callbackManager = CallbackManager.Factory.create(); //liked the callback manager

        //permissions
        loginButton.setPermissions(Collections.singletonList("user_birthday,user_photos,user_gender"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult){
                Log.d("Demo","Login Successful!");
            }
            @Override
            public void onCancel(){
                //if canceled handles this code
               Log.d("Demo","Login Canceled!");
            }
            @Override
            public void onError(@NonNull FacebookException error) {
            //if error handles this code
              Log.d("Demo","Login Error!");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // pass the login result to the login manager via callback manager
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);


        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
            new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted( JSONObject object, GraphResponse response) {
                    //onCompleted method it is called when graphRequest completes
                    // response is the response from graph
                    Log.d("Demo", object.toString());
                    try {
                        String name = object.getString("name");
                        String id = object.getString("id");
                        textView.setText(name);
                        //picasso library for displaying images easy
                        Picasso.get().load("https://graph.facebook.com/" + id + "/picture?type=large")
                                .into(imageView);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            });

        Bundle bundle = new Bundle();
        bundle.putString("fields","id, name, gender, birthday, location");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync(); // executes on a separate threat and in the background

    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        //when the access token changes thi function is called automatically
        //check if the token has changed, if no, user logged out
            if(currentAccessToken == null) {
                LoginManager.getInstance().logOut();
                    textView.setText("");
                    imageView.setImageResource(0);
            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }
}