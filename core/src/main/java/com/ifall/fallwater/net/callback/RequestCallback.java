package com.ifall.fallwater.net.callback;

import com.ifall.fallwater.ui.LatteLoader;
import com.ifall.fallwater.ui.LoaderStyle;

import android.os.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/10.
 * @mail 1667376033@qq.com
 * description:
 */

public class RequestCallback implements Callback<String> {

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IError ERROR;

    private final IFailure FAILURE;

    private final LoaderStyle LOADING_STYLE;

    private static final Handler HANDLER = new Handler();

    public RequestCallback(IRequest request, ISuccess success,
            IError error, IFailure failure, LoaderStyle loaderStyle) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.LOADING_STYLE = loaderStyle;

    }


    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        if (LOADING_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 1000);

        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

    }
}
