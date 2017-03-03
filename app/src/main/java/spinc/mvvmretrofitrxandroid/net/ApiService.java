package spinc.mvvmretrofitrxandroid.net;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class ApiService {

    //    private static final String FORUM_SERVER_URL = "http://jsonplaceholder.typicode.com";
    private static final String FORUM_SERVER_URL = "https://gist.githubusercontent.com/spdobest/484caddbe902deb3969b31eb0a4f7a16/raw/b39942272671f8df1fe1dfd83fd156ee3195e444";
    String url;
    private Api mForumApi;

    public ApiService(boolean isTrue) {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        if (!isTrue) {
            url = FORUM_SERVER_URL;
        } else {
            url = FORUM_SERVER_URL;
        }


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(url)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mForumApi = restAdapter.create(Api.class);
    }

    public Api getApi() {

        return mForumApi;
    }


}