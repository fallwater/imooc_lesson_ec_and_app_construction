package com.ifall.fallwater.net;

import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.IRequest;
import com.ifall.fallwater.net.callback.ISuccess;
import com.ifall.fallwater.ui.LoaderStyle;

import android.content.Context;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/10.
 * @mail 1667376033@qq.com
 * description:
 */

public class RestClientBuilder {

    private String mUrl;

    private static final Map<String, Object> PARAMS = RestCreator.getParams();

    private IRequest mRequest;

    private ISuccess mSuccess;

    private IError mError;

    private IFailure mFailure;

    private RequestBody mRequestBody;

    private File mFile;

    private LoaderStyle mLoaderStyle;

    private Context mContext;

    public RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mRequestBody = RequestBody
                .create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String filePath) {
        this.mFile = new File(filePath);
        return this;
    }


    public final RestClientBuilder requestBody(RequestBody requestBody) {
        this.mRequestBody = requestBody;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder request(IRequest iRequest) {
        this.mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder loader(LoaderStyle loaderStyle, Context context) {
        this.mLoaderStyle = loaderStyle;
        this.mContext = context;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        this.mContext = context;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mError, mFailure, mRequestBody,
                mFile, mLoaderStyle, mContext);
    }
}
