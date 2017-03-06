package spinc.mvvmretrofitrxandroid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
    //    https://github.com/spdobest/rxAndroid_Mvvm_Retrofit
    ApiService apiService;
    List<ArticleModel> listArticle = new ArrayList<>();
    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  VehicleComponent component = Dagger_VehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        ActivityArticleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_article);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.contactList.setLayoutManager(layoutManager);
        adapter = new ArticleAdapter(listArticle, this);
        binding.contactList.setAdapter(adapter);
        apiService = new ApiService();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sample_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:
                for (int i = 0; i < listArticle.size(); i++) {
                    ArticleModel articleModel = listArticle.get(i);
                    if (articleModel.isRead()) {
                        listArticle.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
                break;

            default:
                break;
        }

        return true;
    }
}