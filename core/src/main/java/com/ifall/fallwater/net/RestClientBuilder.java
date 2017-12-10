package com.ifall.fallwater.net;

import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.IRequest;
import com.ifall.fallwater.net.callback.ISuccess;

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

    private RequestBody mBody;

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

    public final RestClientBuilder parms(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
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

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mError, mFailure);
    }
}
