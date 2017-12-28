package com.xw.programmer.generators;

import com.annotations.AppRegisterGenerator;
import com.xw.programmer_nucleus.wechat.tenpltes.AppRegisterTemplate;

/**
 * Created by nazi on
 * date： 2017/12/28
 */

@AppRegisterGenerator(
        packageName = "com.xw.programmer",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
