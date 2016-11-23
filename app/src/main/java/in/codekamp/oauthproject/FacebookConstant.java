package in.codekamp.oauthproject;

/**
 * Created by Himanshu on 3/13/2016.
 */
public class FacebookConstant {

    public static final String CONSUMER_KEY = "3e5be2cda7614208acc19cc29807df10";

    public static final String CONSUMER_SECRET = "c56520836e18433690a4a312edd4ae91";


    public static final String AUTHORIZATION_VERIFIER_SERVER_URL = "https://api.instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=code";

    public static final String TOKEN_SERVER_URL = "https://api.instagram.com/oauth/access_token";

    public static final String REDIRECT_URL = "http://localhost/callback";

    private FacebookConstant() {
    }
}
