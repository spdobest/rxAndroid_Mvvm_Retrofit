package spinc.mvvmretrofitrxandroid.net;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;
import spinc.mvvmretrofitrxandroid.model.ArticleModel;

public interface Api {
    @GET("/spm")
    public Observable<List<ArticleModel>> getArticle();
}