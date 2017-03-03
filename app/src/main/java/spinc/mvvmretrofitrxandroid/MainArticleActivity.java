package spinc.mvvmretrofitrxandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import spinc.mvvmretrofitrxandroid.adapter.ArticleAdapter;
import spinc.mvvmretrofitrxandroid.databinding.ActivityArticleBinding;
import spinc.mvvmretrofitrxandroid.model.ArticleModel;
import spinc.mvvmretrofitrxandroid.net.ApiService;

public class MainArticleActivity extends AppCompatActivity implements Observer<Object> {
    private static final String TAG = "MainArticleActivity";
    public String imageUrl = "http://lorempixel.com/400/200/";
    ApiService apiService;
    List<ArticleModel> listArticle = new ArrayList<>();
    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityArticleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_article);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.contactList.setLayoutManager(layoutManager);
        adapter = new ArticleAdapter(listArticle, this);
        binding.contactList.setAdapter(adapter);
        apiService = new ApiService(false);
        loadArticles();
    }

    private void loadArticles() {
        apiService.getApi()
                .getArticle()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Object o) {
        Log.i(TAG, "onNext: " + o.toString());
        List<Object> listObject = (List<Object>) o;
        if (listObject.get(0) instanceof ArticleModel) {
            listArticle.addAll((List<ArticleModel>) o);
            adapter.notifyDataSetChanged();
            Log.i(TAG, "onNext: " + o.toString());
        }
    }
}