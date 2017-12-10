package com.ifall.fallwater21071129;

import com.ifall.fallwater.activity.ProxyActivity;
import com.ifall.fallwater.delegate.LatteDelegate;

/**
 * @author Fallwater
 * @mail 1667376033.com
 */
public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
