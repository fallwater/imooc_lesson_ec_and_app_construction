package com.ifall.fallwater21071129;

import com.ifall.fallwater.delegate.LatteDelegate;

import android.os.Bundle;
import android.support.annotation.Nullable;

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

    }
}
