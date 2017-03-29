package com.nickmillward.unsplashdemo.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by nmillward on 3/29/17.
 * Referenced -- https://gist.github.com/nesquena/d09dc68ff07e845cc622
 */

public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {

    private int minItemsBeforeNextLoad = 5;
    private int startingPage = 1;
    private int currentPage = 1;
    private int lastestTotalItemCount = 0;
    private boolean isLoading = true;

    GridLayoutManager layoutManager;

    public InfiniteScrollListener(GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        minItemsBeforeNextLoad *= layoutManager.getSpanCount();
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        int totalItemCount = layoutManager.getItemCount();

        // Assume list was invalidated -- set back to default
        if (totalItemCount < lastestTotalItemCount) {
            this.currentPage = this.startingPage;
            this.lastestTotalItemCount = totalItemCount;
        }

        // If still loading and dataset size has been updated,
        // update load state and last item count
        if (isLoading && totalItemCount > lastestTotalItemCount) {
            isLoading = false;
            lastestTotalItemCount = totalItemCount;
        }

        // If not loading and within threashold limit, increase current page and load more data
        if (!isLoading && (lastVisibleItemPosition + minItemsBeforeNextLoad > totalItemCount)) {
            currentPage++;
            onLoadMore(currentPage, totalItemCount, recyclerView);
            isLoading = true;
        }

        Log.d("SCROLL", "currentPage: " + currentPage);
        Log.d("SCROLL", "totalItemCount: " + totalItemCount);
    }

    public abstract void onLoadMore(int page, int totalItemsCount, RecyclerView view);
}