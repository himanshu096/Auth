package in.codekamp.oauthproject;

import android.hardware.camera2.params.Face;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.Lists;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connectTwitter(View view) {

        TwitterLoader loader = new TwitterLoader();
        loader.execute();
    }

    public class TwitterLoader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ClientParametersAuthentication keys = new ClientParametersAuthentication(TwitterConstants.CONSUMER_KEY,
                    TwitterConstants.CONSUMER_SECRET);

            OAuth oauth = OAuth.newInstance(
                    getApplicationContext(),
                    getSupportFragmentManager(),
                    keys,
                    TwitterConstants.AUTHORIZATION_VERIFIER_SERVER_URL,
                    TwitterConstants.TOKEN_SERVER_URL,
                    TwitterConstants.REDIRECT_URL,
                    Lists.<String> newArrayList(),
                    TwitterConstants.TEMPORARY_TOKEN_REQUEST_URL);

            try {
                Credential credentials = oauth.authorize10a("All in one!").getResult();
                Log.d("codekamp", credentials.getAccessToken());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public void connectFacebook(View view) {

        FacebookLoader loader = new FacebookLoader();
        loader.execute();
    }

    public class FacebookLoader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ClientParametersAuthentication keys = new ClientParametersAuthentication(FacebookConstant.CONSUMER_KEY,
                    FacebookConstant.CONSUMER_SECRET);

            OAuth oauth = OAuth.newInstance(
                    getApplicationContext(),
                    getSupportFragmentManager(),
                    keys,
                    FacebookConstant.AUTHORIZATION_VERIFIER_SERVER_URL,
                    FacebookConstant.TOKEN_SERVER_URL,
                    FacebookConstant.REDIRECT_URL,
                    Lists.<String> newArrayList());



            try {
                Credential credentials = oauth.authorizeExplicitly("All in one!").getResult();
                Log.d("codekamp", credentials.getAccessToken());
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),"kya hua yr login bi na hora tumse",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            return null;
        }
    }

    public void connectFlicker(View view) {

        FLickerLoader loader = new FLickerLoader();
        loader.execute();
    }

    public class FLickerLoader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ClientParametersAuthentication keys = new ClientParametersAuthentication(FlickerConstants.CONSUMER_KEY,
                    FlickerConstants.CONSUMER_SECRET);

            OAuth oauth = OAuth.newInstance(
                    getApplicationContext(),
                    getSupportFragmentManager(),
                    keys,
                    FlickerConstants.AUTHORIZATION_VERIFIER_SERVER_URL,
                    FlickerConstants.TOKEN_SERVER_URL,
                    FlickerConstants.REDIRECT_URL,
                    Lists.<String> newArrayList(),
                    FlickerConstants.TEMPORARY_TOKEN_REQUEST_URL);

            try {
                Credential credentials = oauth.authorize10a("All in one!").getResult();
                Log.d("codekamp", credentials.getAccessToken());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
