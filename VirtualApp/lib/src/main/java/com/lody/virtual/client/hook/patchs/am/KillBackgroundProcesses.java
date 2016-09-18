package com.lody.virtual.client.hook.patchs.am;

import android.text.TextUtils;

import com.lody.virtual.client.hook.base.Hook;

import java.lang.reflect.Method;

/**
 * @author Lody
 *
 * @see android.app.IActivityManager#killBackgroundProcesses(String, int)
 *
 */

public class KillBackgroundProcesses extends Hook {

    @Override
    public String getName() {
        return "killBackgroundProcesses";
    }

    @Override
    public Object call(Object who, Method method, Object... args) throws Throwable {
        String packageName = (String) args[0];
        if(!TextUtils.isEmpty(packageName) && packageName.contains(getHostPkg())) {
            return null;
        }
        return method.invoke(who, args);
    }

    @Override
    public boolean isEnable() {
        return isAppProcess();
    }
}
