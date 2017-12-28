package com.xw.programmer.generators;

import com.annotations.PayEntryGenerator;
import com.xw.programmer_nucleus.wechat.tenpltes.WXPayEntryTemplate;

/**
 * Created by nazi on
 * date： 2017/12/28
 */
@PayEntryGenerator(
        packageName = "com.xw.programmer",
        payEntryTemplete = WXPayEntryTemplate.class
)

public interface WeChatPayEntry {
}
