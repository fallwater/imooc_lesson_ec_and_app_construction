package com.ifall.fallwater.net;

import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.IRequest;
import com.ifall.fallwater.net.callback.ISuccess;
import com.ifall.fallwater.net.callback.RequestCallback;
import com.ifall.fallwater.ui.LatteLoader;
import com.ifall.fallwater.ui.LoaderStyle;

import android.content.Context;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    private final RequestBody REQUEST_BODY;

    private final File FILE;

    private final LoaderStyle LOADER_STYLE;

    private final Context CONTEXT;

    public RestClient(String url, Map<String, Object> params,
            IRequest request, ISuccess success, IError error,
            IFailure failure, RequestBody requestBody,
            File file, LoaderStyle loaderStyle, Context context) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.REQUEST_BODY = requestBody;
        this.FILE = file;
        this.LOADER_STYLE = loaderStyle;
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

        if (LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
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
                final RequestBody requestBody = RequestBody
                        .create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part part = MultipartBody.Part
                        .createFormData("file", FILE.getName());
                break;
            case PUT_RAW:
                call = service.putRaw(URL, REQUEST_BODY);
                break;
            case DOWNLOAD:
                break;
            case POST_RAW:
                call = service.posRaw(URL, REQUEST_BODY);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallback(REQUEST, SUCCESS, ERROR, FAILURE, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (REQUEST_BODY == null && PARAMS != null && !PARAMS.isEmpty()) {
            request(HttpMethod.POST);
        } else if (REQUEST_BODY != null && (PARAMS == null || PARAMS.isEmpty())) {
            request(HttpMethod.POST_RAW);
        } else {
            throw new RuntimeException("params or requestBody must be have one exist, ");
        }
    }

    public final void put() {
        if (REQUEST_BODY == null) {
            request(HttpMethod.PUT);
        } else {
            request(HttpMethod.POST_RAW);
        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }


}
