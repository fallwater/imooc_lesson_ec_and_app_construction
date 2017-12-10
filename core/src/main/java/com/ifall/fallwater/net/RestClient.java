package com.ifall.fallwater.net;

import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.IRequest;
import com.ifall.fallwater.net.callback.ISuccess;
import com.ifall.fallwater.net.callback.RequestCallback;
import com.ifall.fallwater.ui.LatteLoader;
import com.ifall.fallwater.ui.LoaderStyle;

import android.content.Context;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/10.
 * @mail 1667376033@qq.com
 * description:
 */

public class RestClient {

    private final String URL;

    private final static Map<String, Object> PARAMS = RestCreator.getParams();

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IError ERROR;

    private final IFailure FAILURE;

    private final LoaderStyle LOADER_STYTLE;

    private final Context CONTEXT;

    public RestClient(String url, Map<String, Object> params,
            IRequest request, ISuccess success, IError error,
            IFailure failure, LoaderStyle loaderStyle, Context context) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.LOADER_STYTLE = loaderStyle;
        this.CONTEXT = context;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();

        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        if (LOADER_STYTLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYTLE);
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case PUT:
                break;
            case POST:
                break;
            case DELETE:
                break;
            case UPLOAD:
                break;
            case PUT_RAW:
                break;
            case DOWNLOAD:
                break;
            case POST_RAW:
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallback(REQUEST, SUCCESS, ERROR, FAILURE, LOADER_STYTLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }


}
