package com.xw.programmer.generators;

import com.annotations.EntryGenerator;
import com.xw.programmer_nucleus.wechat.tenpltes.WXEntryTemplate;

/**
 * Created by nazi on
 * date： 2017/12/28
 */
@EntryGenerator(
        packageName = "com.xw.programmer",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
