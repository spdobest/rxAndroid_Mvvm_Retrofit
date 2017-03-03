package spinc.mvvmretrofitrxandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import spinc.mvvmretrofitrxandroid.R;
import spinc.mvvmretrofitrxandroid.databinding.ItemviewArticleBinding;
import spinc.mvvmretrofitrxandroid.model.ArticleModel;
import spinc.mvvmretrofitrxandroid.viewmodel.ArticleViewModel;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {

    private List<ArticleModel> mArticles;
    private Context mContext;

    public ArticleAdapter(List<ArticleModel> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemviewArticleBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.itemview_article, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemviewArticleBinding binding = holder.binding;
        binding.setAvm(new ArticleViewModel(mArticles.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemviewArticleBinding binding;

        public BindingHolder(ItemviewArticleBinding binding) {
            super(binding.contactCard);
            this.binding = binding;
        }
    }
}