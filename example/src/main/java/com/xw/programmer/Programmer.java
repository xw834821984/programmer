package com.xw.programmer;

import com.xw.programmer.ec.launcher.LauncherScrollDelegate;
import com.xw.programmer_nucleus.activities.ProxyActivitie;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;

public class Programmer extends ProxyActivitie {


    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }

}
