package com.example.common.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState

abstract class BasePagingSource<T : Any>(
) : PagingSource<Int, T>() {
    /***
     * The getRefreshKey function is responsible for determining a key that can be used to load the latest data from the server.
     * The key should be based on the current state of the PagingSource
     ***/
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    abstract override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T>

}