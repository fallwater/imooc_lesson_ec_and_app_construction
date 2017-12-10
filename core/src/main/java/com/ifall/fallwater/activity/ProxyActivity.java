package com.ifall.fallwater.activity;

import com.ifall.fallwater.R;
import com.ifall.fallwater.delegate.LatteDelegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/2.
 * @mail 1667376033@qq.com
 * description:
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }
}
