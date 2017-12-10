package com.ifall.fallwater21071129;

import com.ifall.fallwater.app.Latte;
import com.ifall.fallwater.delegate.LatteDelegate;
import com.ifall.fallwater.net.RestClient;
import com.ifall.fallwater.net.callback.IError;
import com.ifall.fallwater.net.callback.IFailure;
import com.ifall.fallwater.net.callback.ISuccess;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/10.
 * @mail 1667376033@qq.com
 * description:
 */

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState) {
        testRestClient();

    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com")
//                .params("", "")
//                .loader(Latte.getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(ExampleDelegate.this.getActivity(), "test restClient toast",
                                Toast.LENGTH_LONG)
                                .show();

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int errorCode, String errorMessage) {

                    }
                })
                .build()
                .get();

    }
}
