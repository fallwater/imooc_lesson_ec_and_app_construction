package com.ifall.fallwater.net;

import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.IRequest;
import com.ifall.fallwater.net.callback.ISuccess;

import java.util.Map;

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

    public final static Map<String, Object> PARAMS = RestCreator.getParams();

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IError ERROR;

    private final IFailure FAILURE;

    public RestClient(String url, Map<String, Object> params,
            IRequest request, ISuccess success, IError error,
            IFailure failure) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
