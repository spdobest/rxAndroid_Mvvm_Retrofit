package spinc.mvvmretrofitrxandroid.net;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class ApiService {
    private static final String ROOT_URL = "https://gist.githubusercontent.com/spdobest/484caddbe902deb3969b31eb0a4f7a16/raw/b39942272671f8df1fe1dfd83fd156ee3195e444";

    private Api mForumApi;

    public ApiService() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mForumApi = restAdapter.create(Api.class);
    }

    public Api getApi() {

        return mForumApi;
    }


}